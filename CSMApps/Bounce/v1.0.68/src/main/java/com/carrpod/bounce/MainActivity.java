package com.carrpod.bounce;

import android.Manifest;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanSettings;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.net.wifi.p2p.WifiP2pConfig;
import android.net.wifi.p2p.WifiP2pManager;
import android.net.wifi.p2p.nsd.WifiP2pDnsSdServiceInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends Activity {

    private static final int PERM_REQ = 1001;
    private WebView webView;
    private LinearLayout headerOverlay;
    private boolean cleanMode = false;
    private Button cleanBtn;
    private TextView tagTextView;
    private WifiManager wifiManager;
    private WifiP2pManager p2pManager;
    private WifiP2pManager.Channel p2pChannel;
    private LocationManager locationManager;
    private SensorManager sensorManager;
    private BluetoothAdapter bluetoothAdapter;
    private BluetoothLeScanner bleScanner;
    private boolean btScanning = false;
    private int btHitCount = 0;
    private PowerManager.WakeLock wakeLock;
    private final float[] accelData = new float[3];
    private final float[] magnetData = new float[3];
    private boolean hasAccel = false, hasMagnet = false;
    private boolean scanning = false, broadcasting = false;
    private final Handler scanHandler = new Handler(Looper.getMainLooper());
    private int scanCount = 0;
    private long lastScanTime = 0;
    private final Map<String, Long> ssidLog = new HashMap<>();
    private final Map<String, Float> ssidRssiHistory = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            getWindow().setDecorFitsSystemWindows(false);
        } else {
            getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }

        FrameLayout root = new FrameLayout(this) {
            @Override public WindowInsets onApplyWindowInsets(WindowInsets insets) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                    int sbh = insets.getInsets(WindowInsets.Type.statusBars()).top;
                    webView.post(() -> injectJs("UI.setInsets(" + sbh + ",0)"));
                }
                return super.onApplyWindowInsets(insets);
            }
        };

        root.setBackgroundColor(Color.parseColor("#0A0A0F"));

        webView = buildWebView();
        root.addView(webView);

        headerOverlay = buildHeader();
        root.addView(headerOverlay);

        root.addView(buildControlBar());
        setContentView(root);

        PowerManager pm = (PowerManager) getSystemService(POWER_SERVICE);
        wakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "Bounce:TrailRecorder");
        wakeLock.acquire();

        wifiManager = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
        p2pManager = (WifiP2pManager) getSystemService(WIFI_P2P_SERVICE);
        if (p2pManager != null) {
            p2pChannel = p2pManager.initialize(this, Looper.getMainLooper(), null);
        }
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            boolean needLoc = checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED;
            boolean needWifi = Build.VERSION.SDK_INT >= 33 &&
                checkSelfPermission(Manifest.permission.NEARBY_WIFI_DEVICES) != PackageManager.PERMISSION_GRANTED;
            boolean needBt = Build.VERSION.SDK_INT >= 31 &&
                checkSelfPermission(Manifest.permission.BLUETOOTH_SCAN) != PackageManager.PERMISSION_GRANTED;

            if (needLoc || needWifi || needBt) {
                java.util.ArrayList<String> perms = new java.util.ArrayList<>();
                if (needLoc) { perms.add(Manifest.permission.ACCESS_FINE_LOCATION); perms.add(Manifest.permission.ACCESS_COARSE_LOCATION); }
                if (needWifi) perms.add(Manifest.permission.NEARBY_WIFI_DEVICES);
                if (needBt) { perms.add(Manifest.permission.BLUETOOTH_SCAN); perms.add(Manifest.permission.BLUETOOTH_CONNECT); }

                new Handler(Looper.getMainLooper()).postDelayed(() -> {
                    requestPermissions(perms.toArray(new String[0]), PERM_REQ);
                    Toast.makeText(MainActivity.this, "Grant permissions for scanning, GPS, and Bluetooth", Toast.LENGTH_LONG).show();
                }, 500);
                return;
            }
        }

        startServices();
    }

    @Override
    public void onRequestPermissionsResult(int code, String[] perms, int[] results) {
        super.onRequestPermissionsResult(code, perms, results);
        if (code == PERM_REQ) {
            boolean granted = results.length > 0 && results[0] == PackageManager.PERMISSION_GRANTED;
            Toast.makeText(this, granted ? "Permissions granted" : "Denied — scanner disabled", Toast.LENGTH_LONG).show();
            if (granted) startServices();
        }
    }

    private void startServices() {
        startWifiScanning();
        startGpsTracking();
        startSensors();
        startBtScanning();
    }

    private void startBtScanning() {
        if (Build.VERSION.SDK_INT >= 31) {
            if (checkSelfPermission(Manifest.permission.BLUETOOTH_SCAN) != PackageManager.PERMISSION_GRANTED) return;
        }
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (bluetoothAdapter == null || !bluetoothAdapter.isEnabled()) return;
        bleScanner = bluetoothAdapter.getBluetoothLeScanner();
        if (bleScanner == null) return;
        btScanning = true;
        try {
            ScanSettings settings = new ScanSettings.Builder().setScanMode(ScanSettings.SCAN_MODE_LOW_LATENCY).build();
            bleScanner.startScan(null, settings, btCallback);
        } catch (Exception ignored) {}
    }

    private final ScanCallback btCallback = new ScanCallback() {
        public void onScanResult(int callbackType, android.bluetooth.le.ScanResult result) {
            if (result == null || webView == null) return;
            BluetoothDevice dev = result.getDevice();
            if (btHitCount++ < 3) Toast.makeText(MainActivity.this, "BT found: " + (dev.getName() != null ? dev.getName() : dev.getAddress()), Toast.LENGTH_SHORT).show();
            int rssi = result.getRssi();
            float dist = (float) Math.pow(10, (-40 - rssi) / 20.0);
            webView.post(() -> {
                String json = "{\"name\":\"" + escapeJson(dev.getName()) + "\",\"addr\":\"" + dev.getAddress()
                    + "\",\"rssi\":" + rssi + ",\"dist\":" + String.format("%.1f", dist) + "}";
                injectJs("Bounce.onBtResult(" + json + ")");
            });
        }
        public void onScanFailed(int errorCode) {
            Toast.makeText(MainActivity.this, "BT scan failed: " + errorCode, Toast.LENGTH_LONG).show();
            injectJs("Bounce.onBtStatus({status:'failed',code:" + errorCode + "})");
        }
    };

    private void startSensors() {
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        if (sensorManager == null) return;
        Sensor accel = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        Sensor magnet = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        if (accel != null) sensorManager.registerListener(sensorListener, accel, SensorManager.SENSOR_DELAY_UI);
        if (magnet != null) sensorManager.registerListener(sensorListener, magnet, SensorManager.SENSOR_DELAY_UI);
    }

    private final SensorEventListener sensorListener = new SensorEventListener() {
        public void onSensorChanged(SensorEvent event) {
            if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
                System.arraycopy(event.values, 0, accelData, 0, 3);
                hasAccel = true;
            } else if (event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD) {
                System.arraycopy(event.values, 0, magnetData, 0, 3);
                hasMagnet = true;
            }
            if (hasAccel && hasMagnet) {
                float[] R = new float[9], I = new float[9];
                if (SensorManager.getRotationMatrix(R, I, accelData, magnetData)) {
                    float[] orientation = new float[3];
                    SensorManager.getOrientation(R, orientation);
                    float azimuth = (float) Math.toDegrees(orientation[0]);
                    if (azimuth < 0) azimuth += 360;
                    float pitch = (float) Math.toDegrees(orientation[1]);
                    String orn = Math.abs(pitch) < 20 ? "flat" : Math.abs(pitch) > 60 ? "upright" : "tilted";
                    final float az = azimuth; final String or = orn;
                    if (webView != null) {
                        webView.post(() -> injectJs("Bounce.onCompass(" + az + ",'" + or + "')"));
                    }
                }
            }
        }
        public void onAccuracyChanged(Sensor sensor, int accuracy) {}
    };

    private long broadcastStartTime = 0;
    private boolean transitionInProgress = false;
    private Handler timeoutHandler = new Handler(Looper.getMainLooper());
    private Runnable transitionTimeout = null;

    private boolean preflightCheck() {
        if (p2pManager == null || p2pChannel == null) return false;
        if (wifiManager == null || !wifiManager.isWifiEnabled()) return false;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)
                return false;
        }
        return true;
    }

    private void armTransitionTimeout() {
        if (transitionTimeout != null) timeoutHandler.removeCallbacks(transitionTimeout);
        transitionTimeout = new Runnable() { public void run() {
            if (transitionInProgress) {
                transitionInProgress = false;
                injectJs("Bounce.onBroadcastStatus({status:'timeout'})");
            }
        }};
        timeoutHandler.postDelayed(transitionTimeout, 10000);
    }

    private void disarmTransitionTimeout() {
        if (transitionTimeout != null) {
            timeoutHandler.removeCallbacks(transitionTimeout);
            transitionTimeout = null;
        }
    }

    public void startP2pBroadcast(String ssidCode) {
        if (transitionInProgress) {
            injectJs("Bounce.onBroadcastStatus({status:'busy'})");
            return;
        }
        if (!preflightCheck()) {
            injectJs("Bounce.onBroadcastStatus({status:'not_ready',reason:'check_wifi_perms'})");
            return;
        }
        if (ssidCode == null || ssidCode.isEmpty()) {
            injectJs("Bounce.onBroadcastStatus({status:'invalid_code'})");
            return;
        }

        transitionInProgress = true;
        broadcastStartTime = System.currentTimeMillis();
        armTransitionTimeout();

        String code = ssidCode.length() > 25 ? ssidCode.substring(0, 25) : ssidCode;
        doCreateGroup(code);
    }

    private void doCreateGroup(String code) {
        if (!preflightCheck()) { onGroupFailed(); return; }
        if (code == null) { onGroupFailed(); return; }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            try {
                WifiP2pConfig config = new WifiP2pConfig.Builder()
                    .setNetworkName(code)
                    .setPassphrase("Bounce-2026")
                    .setGroupOperatingBand(WifiP2pConfig.GROUP_OWNER_BAND_5GHZ)
                    .build();
                if (p2pManager != null && p2pChannel != null) {
                    p2pManager.createGroup(p2pChannel, config, new WifiP2pManager.ActionListener() {
                        public void onSuccess() { onGroupCreated(code, "bare"); }
                        public void onFailure(int r) { tryWithDirect(code); }
                    });
                } else { onGroupFailed(); }
            } catch (IllegalArgumentException e) {
                tryWithDirect(code);
            } catch (Exception e) {
                tryWithDirect(code);
            }
        } else {
            doLegacyCreateGroup(code);
        }
    }

    private void tryWithDirect(String code) {
        if (!preflightCheck()) { onGroupFailed(); return; }
        try {
            WifiP2pConfig config = new WifiP2pConfig.Builder()
                .setNetworkName("DIRECT-" + code)
                .setPassphrase("Bounce-2026")
                .setGroupOperatingBand(WifiP2pConfig.GROUP_OWNER_BAND_5GHZ)
                .build();
            if (p2pManager != null && p2pChannel != null) {
                p2pManager.createGroup(p2pChannel, config, new WifiP2pManager.ActionListener() {
                    public void onSuccess() { onGroupCreated("DIRECT-" + code, "direct-prefix"); }
                    public void onFailure(int r) { doLegacyCreateGroup(code); }
                });
            } else { onGroupFailed(); }
        } catch (Exception e) { doLegacyCreateGroup(code); }
    }

    private void onGroupCreated(String ssid, String method) {
        disarmTransitionTimeout();
        broadcasting = true;
        transitionInProgress = false;
        long elapsed = System.currentTimeMillis() - broadcastStartTime;
        if (webView != null) {
            injectJs("Bounce.onTransitionTiming(" + elapsed + ",'" + ssid + "','" + method + "')");
            injectJs("Bounce.onBroadcastStatus({status:'visible',ssid:'" + ssid + "',method:'" + method + "'})");
        }
        try { Toast.makeText(MainActivity.this, ssid + " (" + elapsed + "ms)", Toast.LENGTH_SHORT).show(); } catch (Exception ignored) {}
    }

    private void doLegacyCreateGroup(String code) {
        if (!preflightCheck()) { onGroupFailed(); return; }
        try {
            java.lang.reflect.Method setDev = WifiP2pManager.class.getMethod("setDeviceName",
                WifiP2pManager.Channel.class, String.class, WifiP2pManager.ActionListener.class);
            setDev.invoke(p2pManager, p2pChannel, code, new WifiP2pManager.ActionListener() {
                public void onSuccess() {
                    if (p2pManager != null && p2pChannel != null) {
                        p2pManager.createGroup(p2pChannel, new WifiP2pManager.ActionListener() {
                            public void onSuccess() { onGroupCreated(code, "legacy"); }
                            public void onFailure(int r) { onGroupFailed(); }
                        });
                    } else { onGroupFailed(); }
                }
                public void onFailure(int r) {
                    if (p2pManager != null && p2pChannel != null) {
                        p2pManager.createGroup(p2pChannel, new WifiP2pManager.ActionListener() {
                            public void onSuccess() { onGroupCreated(code, "legacy-fallback"); }
                            public void onFailure(int r2) { onGroupFailed(); }
                        });
                    } else { onGroupFailed(); }
                }
            });
        } catch (Exception e) { onGroupFailed(); }
    }

    private void onGroupFailed() {
        disarmTransitionTimeout();
        broadcasting = false;
        transitionInProgress = false;
        injectJs("Bounce.onBroadcastStatus({status:'failed'})");
    }

    public void refreshBroadcastSSID(String newCode) {
        if (transitionInProgress) return;
        if (!broadcasting) return;
        if (!preflightCheck()) return;
        if (newCode == null || newCode.isEmpty()) return;

        transitionInProgress = true;
        broadcastStartTime = System.currentTimeMillis();
        armTransitionTimeout();

        String code = newCode.length() > 25 ? newCode.substring(0, 25) : newCode;

        if (p2pManager != null && p2pChannel != null) {
            p2pManager.removeGroup(p2pChannel, new WifiP2pManager.ActionListener() {
                public void onSuccess() {
                    new Handler(Looper.getMainLooper()).postDelayed(() -> {
                        if (transitionInProgress && preflightCheck()) {
                            doCreateGroup(code);
                        } else {
                            onGroupFailed();
                        }
                    }, 600);
                }
                public void onFailure(int r) {
                    if (preflightCheck()) {
                        doCreateGroup(code);
                    } else {
                        onGroupFailed();
                    }
                }
            });
        } else {
            onGroupFailed();
        }
    }

    private void startBonjourBroadcast(String ssidCode) {
        p2pManager.clearLocalServices(p2pChannel, new WifiP2pManager.ActionListener() {
            public void onSuccess() {} public void onFailure(int r) {}
        });

        Map<String, String> record = new HashMap<>();
        record.put("taf", ssidCode);
        record.put("v", "1.0.13");

        WifiP2pDnsSdServiceInfo info = WifiP2pDnsSdServiceInfo.newInstance("_bounce._tcp", ssidCode, record);
        p2pManager.addLocalService(p2pChannel, info, new WifiP2pManager.ActionListener() {
            public void onSuccess() {
                broadcasting = true;
                p2pManager.discoverPeers(p2pChannel, new WifiP2pManager.ActionListener() {
                    public void onSuccess() {
                        injectJs("Bounce.onBroadcastStatus({status:'visible',ssid:'" + ssidCode + "',method:'Bonjour+Discoverable'})");
                    }
                    public void onFailure(int r) {
                        injectJs("Bounce.onBroadcastStatus({status:'broadcasting',ssid:'" + ssidCode + "',method:'Bonjour-only'})");
                    }
                });
            }
            public void onFailure(int r) {
                injectJs("Bounce.onBroadcastStatus({status:'failed',reason:'bonjour_failed'})");
            }
        });
    }

    public void stopP2pBroadcast() {
        if (p2pManager == null || p2pChannel == null) return;
        transitionInProgress = false;
        p2pManager.removeGroup(p2pChannel, new WifiP2pManager.ActionListener() {
            public void onSuccess() {}
            public void onFailure(int r) {
                // Try clearing services if group removal fails
                p2pManager.clearLocalServices(p2pChannel, new WifiP2pManager.ActionListener() {
                    public void onSuccess() {} public void onFailure(int r2) {}
                });
            }
        });
        broadcasting = false;
        injectJs("Bounce.onBroadcastStatus({status:'stopped'})");
    }

    private void startGpsTracking() {
        if (locationManager == null) return;
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) return;
            }
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2000, 1f, gpsListener, Looper.getMainLooper());
        } catch (Exception e) {
            injectJs("androidBridge('gpsStatus',{status:'error',msg:'" + e.getMessage() + "'})");
        }
    }

    private final LocationListener gpsListener = new LocationListener() {
        public void onLocationChanged(Location loc) {
            if (loc == null || webView == null) return;
            webView.post(() -> {
                String json = "{lat:" + loc.getLatitude() + ",lng:" + loc.getLongitude()
                    + ",alt:" + loc.getAltitude() + ",speed:" + loc.getSpeed()
                    + ",bearing:" + loc.getBearing() + ",acc:" + loc.getAccuracy() + "}";
                injectJs("Bounce.onGps(" + json + ")");
            });
        }
        public void onStatusChanged(String p, int s, Bundle b) {}
        public void onProviderEnabled(String p) {}
        public void onProviderDisabled(String p) {
            injectJs("androidBridge('gpsStatus',{status:'disabled'})");
        }
    };

    private void startWifiScanning() {
        if (wifiManager == null || !wifiManager.isWifiEnabled()) {
            Toast.makeText(this, "Enable Wi-Fi for Bounce scanning", Toast.LENGTH_LONG).show();
            return;
        }

        IntentFilter filter = new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION);
        registerReceiver(wifiScanReceiver, filter);

        scanning = true;
        lastScanTime = System.currentTimeMillis();
        wifiManager.startScan();
        pushScanResults();

        scanHandler.postDelayed(new Runnable() {
            public void run() {
                if (scanning) {
                    lastScanTime = System.currentTimeMillis();
                    wifiManager.startScan();
        pushScanResults();
                    scanHandler.postDelayed(this, 1000);
                }
            }
        }, 1000);
    }

    private final BroadcastReceiver wifiScanReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            boolean success = intent.getBooleanExtra(WifiManager.EXTRA_RESULTS_UPDATED, false);
            if (!success) return;
            List<android.net.wifi.ScanResult> results = wifiManager.getScanResults();
            if (results == null || results.isEmpty()) return;
            long elapsed = System.currentTimeMillis() - lastScanTime;
            lastScanTime = System.currentTimeMillis();
            sendScanResultsToJs(results, elapsed);
        }
    };

    private void pushScanResults() {
        if (wifiManager == null || webView == null) return;
        try {
            List<android.net.wifi.ScanResult> results = wifiManager.getScanResults();
            if (results == null || results.isEmpty()) {
                // No results yet — tell JS we're still scanning
                injectJs("Bounce.onScanStatus({status:'empty',msg:'no networks found'})");
                return;
            }
            sendScanResultsToJs(results, 0);
        } catch (SecurityException se) {
            injectJs("Bounce.onScanStatus({status:'denied',msg:'location permission needed'})");
        } catch (Exception e) {
            injectJs("Bounce.onScanStatus({status:'error',msg:'"+e.getMessage()+"'})");
        }
    }

    private void sendScanResultsToJs(List<android.net.wifi.ScanResult> results, long elapsed) {
        scanCount++;
        long now = System.currentTimeMillis();
        StringBuilder json = new StringBuilder("[");
        boolean first = true;
        for (android.net.wifi.ScanResult r : results) {
            if (!first) json.append(","); first = false;
            String ssid = escapeJson(r.SSID);
            String bssid = r.BSSID;
            long firstSeen = ssidLog.containsKey(bssid) ? ssidLog.get(bssid) : now;
            if (!ssidLog.containsKey(bssid)) ssidLog.put(bssid, now);
            long persistence = (now - firstSeen) / 1000;
            Float prevRssi = ssidRssiHistory.get(bssid);
            boolean reliable = prevRssi != null && Math.abs(r.level - prevRssi) < 15;
            float distance = estimateDistance(r.level, r.frequency);
            ssidRssiHistory.put(bssid, (float) r.level);
            json.append("{\"ssid\":\"").append(ssid).append("\",\"bssid\":\"").append(bssid)
                .append("\",\"rssi\":").append(r.level).append(",\"freq\":").append(r.frequency)
                .append(",\"dist\":").append(String.format("%.1f", distance))
                .append(",\"persist\":").append(persistence).append(",\"reliable\":").append(reliable).append(",\"caps\":\"\"}");
        }
        json.append("]");
        String meta = "{\"scanNum\":" + scanCount + ",\"elapsed\":" + elapsed + ",\"total\":" + ssidLog.size() + "}";
        injectJs("Bounce.onScanResults(" + json.toString() + "," + meta + ")");
    }

    private float estimateDistance(int rssi, int frequency) {
        float exp = (27.55f - (20f * (float) Math.log10(frequency > 0 ? frequency : 2400)) + Math.abs(rssi)) / 20f;
        return (float) Math.pow(10f, exp);
    }

    private String escapeJson(String s) {
        if (s == null || s.isEmpty()) return "---";
        return s.replace("\\", "\\\\").replace("\"", "\\\"").replace("\n", "\\n").replace("\r", "");
    }

    private WebView buildWebView() {
        WebView wv = new WebView(this);
        wv.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        WebSettings s = wv.getSettings();
        s.setJavaScriptEnabled(true);
        s.setDomStorageEnabled(true);
        s.setAllowFileAccess(true);
        s.setAllowFileAccessFromFileURLs(true);
        s.setAllowUniversalAccessFromFileURLs(true);
        s.setMediaPlaybackRequiresUserGesture(false);
        wv.setWebChromeClient(new WebChromeClient());
        wv.setWebViewClient(new WebViewClient() {
            public void onPageFinished(WebView v, String u) {
                v.postDelayed(() -> {
                    v.evaluateJavascript("androidBridge('onReady',{loaded:true})", null);
                    v.evaluateJavascript("UI.setInsets(40,34)", null);
                }, 2000);
            }
        });
        wv.addJavascriptInterface(new JsBridge(), "BounceBridge");
        wv.loadUrl("file:///android_asset/bounce.html");
        return wv;
    }

    private LinearLayout buildHeader() {
        LinearLayout h = new LinearLayout(this);
        h.setOrientation(LinearLayout.VERTICAL);
        h.setGravity(Gravity.CENTER);
        h.setPadding(dp(16), dp(44), dp(16), dp(10));
        h.setBackgroundColor(Color.argb(190, 10, 10, 15));
        FrameLayout.LayoutParams hp = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        hp.gravity = Gravity.TOP | Gravity.CENTER_HORIZONTAL;
        h.setLayoutParams(hp);

        TextView logo = new TextView(this);
        logo.setText("BOUNCE");
        logo.setTextSize(26f);
        logo.setTextColor(Color.parseColor("#FF6600"));
        logo.setTypeface(Typeface.DEFAULT_BOLD);
        logo.setGravity(Gravity.CENTER);

        TextView tag = new TextView(this);
        tag.setText("Trail + BT 3D · v1.0.49");
        tag.setTextSize(11f);
        tag.setTextColor(Color.parseColor("#E8E8F0"));
        tag.setGravity(Gravity.CENTER);
        tagTextView = tag;

        h.addView(logo);
        h.addView(tag);
        return h;
    }

    private FrameLayout buildControlBar() {
        FrameLayout bar = new FrameLayout(this);
        bar.setBackgroundColor(Color.parseColor("#E50A0A0F"));
        FrameLayout.LayoutParams bp = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        bp.gravity = Gravity.BOTTOM;
        bar.setLayoutParams(bp);

        LinearLayout row = new LinearLayout(this);
        row.setOrientation(LinearLayout.HORIZONTAL);
        row.setGravity(Gravity.CENTER);
        row.setPadding(0, dp(8), 0, dp(8));

        row.addView(mkBtn("SCAN", "#00FF88", v -> {
            if (wifiManager != null) {
                boolean started = wifiManager.startScan();
                // Also push cached results immediately
                pushScanResults();
                if (!started) Toast.makeText(MainActivity.this, "Scan throttled — cached results shown", Toast.LENGTH_SHORT).show();
            }
        }));
        row.addView(mkBtn("+VEH", "#f97316", v -> injectJs("Bounce.showPlateInput()")));
        row.addView(mkBtn("BROADCAST", "#4488FF", v -> injectJs("Bounce.toggleBroadcast()")));
        row.addView(mkBtn("FLEET", "#a855f7", v -> injectJs("Bounce.toggleFleet()")));

        cleanBtn = mkBtn("CLEAN", "#FF6600", v -> {
            cleanMode = !cleanMode;
            cleanBtn.setText(cleanMode ? "SHOW" : "CLEAN");
            cleanBtn.setTextColor(Color.parseColor(cleanMode ? "#FF4466" : "#FF6600"));
            headerOverlay.setVisibility(cleanMode ? View.GONE : View.VISIBLE);
        });
        row.addView(cleanBtn);

        bar.addView(row);
        return bar;
    }

    private Button mkBtn(String t, String color, View.OnClickListener l) {
        Button b = new Button(this);
        b.setText(t); b.setTextSize(10f); b.setTextColor(Color.parseColor(color));
        b.setBackgroundColor(Color.parseColor("#1A1A2E"));
        b.setPadding(dp(8), dp(8), dp(8), dp(8));
        b.setLayoutParams(new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f));
        b.setOnClickListener(l); return b;
    }

    private void injectJs(String s) { try { if (webView != null) webView.evaluateJavascript(s, null); } catch (Exception ignored) {} }
    private int dp(int px) { return (int)(px * getResources().getDisplayMetrics().density); }

    @Override public void onBackPressed() { super.onBackPressed(); }
    @Override protected void onDestroy() {
        super.onDestroy();
        if (wakeLock != null && wakeLock.isHeld()) wakeLock.release();
        scanning = false;
        scanHandler.removeCallbacksAndMessages(null);
        try { unregisterReceiver(wifiScanReceiver); } catch (Exception ignored) {}
        if (broadcasting) stopP2pBroadcast();
        if (btScanning && bleScanner != null) {
            btScanning = false;
            try { bleScanner.stopScan(btCallback); } catch (Exception ignored) {}
        }
    }

    public class JsBridge {
        @JavascriptInterface
        public void onReady(String j) {
            runOnUiThread(() -> Toast.makeText(MainActivity.this, "Bounce v1.0.5 · WiFi Direct + Scanner", Toast.LENGTH_SHORT).show());
        }

        @JavascriptInterface
        public void startBroadcast(String ssidCode) {
            runOnUiThread(() -> startP2pBroadcast(ssidCode));
        }

        @JavascriptInterface
        public void stopBroadcast() {
            runOnUiThread(() -> stopP2pBroadcast());
        }
        @JavascriptInterface
        public void refreshBroadcastSSID(String newSsid) {
            runOnUiThread(() -> refreshBroadcastSSID(newSsid));
        }
        @JavascriptInterface
        public void updateHeaderText(String text) {
            runOnUiThread(() -> {
                if (tagTextView != null) tagTextView.setText(text);
            });
        }
    }
}
