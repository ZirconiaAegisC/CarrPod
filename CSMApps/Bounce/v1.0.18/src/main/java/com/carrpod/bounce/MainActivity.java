package com.carrpod.bounce;

import android.Manifest;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Typeface;
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
    private WifiManager wifiManager;
    private WifiP2pManager p2pManager;
    private WifiP2pManager.Channel p2pChannel;
    private LocationManager locationManager;
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

        wifiManager = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
        p2pManager = (WifiP2pManager) getSystemService(WIFI_P2P_SERVICE);
        if (p2pManager != null) {
            p2pChannel = p2pManager.initialize(this, Looper.getMainLooper(), null);
        }
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_WIFI_STATE,
                    Manifest.permission.CHANGE_WIFI_STATE,
                    Manifest.permission.NEARBY_WIFI_DEVICES
                }, PERM_REQ);
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
    }

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

        scanHandler.postDelayed(new Runnable() {
            public void run() {
                if (scanning) {
                    lastScanTime = System.currentTimeMillis();
                    wifiManager.startScan();
                    scanHandler.postDelayed(this, 5000);
                }
            }
        }, 5000);
    }

    private final BroadcastReceiver wifiScanReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            boolean success = intent.getBooleanExtra(WifiManager.EXTRA_RESULTS_UPDATED, false);
            if (!success) return;

            List<ScanResult> results = wifiManager.getScanResults();
            if (results == null || results.isEmpty()) return;

            scanCount++;
            long now = System.currentTimeMillis();
            long elapsed = now - lastScanTime;
            lastScanTime = now;

            StringBuilder json = new StringBuilder("[");
            boolean first = true;

            for (ScanResult r : results) {
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

                json.append("{");
                json.append("\"ssid\":\"").append(ssid).append("\",");
                json.append("\"bssid\":\"").append(bssid).append("\",");
                json.append("\"rssi\":").append(r.level).append(",");
                json.append("\"freq\":").append(r.frequency).append(",");
                json.append("\"dist\":").append(String.format("%.1f", distance)).append(",");
                json.append("\"persist\":").append(persistence).append(",");
                json.append("\"reliable\":").append(reliable).append(",\"caps\":\"\"");
                json.append("}");
            }

            json.append("]");
            String meta = "{\"scanNum\":" + scanCount + ",\"elapsed\":" + elapsed + ",\"total\":" + ssidLog.size() + "}";
            injectJs("Bounce.onScanResults(" + json.toString() + "," + meta + ")");
        }
    };

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
        tag.setText("Defensive Broadcast · v1.0.18");
        tag.setTextSize(11f);
        tag.setTextColor(Color.parseColor("#E8E8F0"));
        tag.setGravity(Gravity.CENTER);

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
            if (wifiManager != null) wifiManager.startScan();
            injectJs("Bounce._refreshUI()");
        }));
        row.addView(mkBtn("+VEH", "#f97316", v -> injectJs("Bounce.addSimVehicle()")));
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

    private void injectJs(String s) { if (webView != null) webView.evaluateJavascript(s, null); }
    private int dp(int px) { return (int)(px * getResources().getDisplayMetrics().density); }

    @Override public void onBackPressed() { super.onBackPressed(); }
    @Override protected void onDestroy() {
        super.onDestroy();
        scanning = false;
        scanHandler.removeCallbacksAndMessages(null);
        try { unregisterReceiver(wifiScanReceiver); } catch (Exception ignored) {}
        if (broadcasting) stopP2pBroadcast();
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
    }
}
