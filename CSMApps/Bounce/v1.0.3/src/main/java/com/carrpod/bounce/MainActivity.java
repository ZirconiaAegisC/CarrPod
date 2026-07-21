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
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
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
    private boolean scanning = false;
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

        FrameLayout root = new FrameLayout(this);
        root.setBackgroundColor(Color.parseColor("#0A0A0F"));

        webView = buildWebView();
        root.addView(webView);

        headerOverlay = buildHeader();
        root.addView(headerOverlay);

        root.addView(buildControlBar());
        setContentView(root);

        wifiManager = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED ||
                checkSelfPermission(Manifest.permission.ACCESS_WIFI_STATE) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_WIFI_STATE,
                    Manifest.permission.CHANGE_WIFI_STATE
                }, PERM_REQ);
                Toast.makeText(this, "Grant Wi-Fi + Location permissions for Bounce scanner", Toast.LENGTH_LONG).show();
                return;
            }
        }

        startWifiScanning();
    }

    @Override
    public void onRequestPermissionsResult(int code, String[] perms, int[] results) {
        super.onRequestPermissionsResult(code, perms, results);
        if (code == PERM_REQ) {
            boolean granted = results.length > 0 && results[0] == PackageManager.PERMISSION_GRANTED;
            Toast.makeText(this, granted ? "Permissions granted — starting Wi-Fi scanner" : "Permissions denied — Wi-Fi scanning disabled", Toast.LENGTH_LONG).show();
            if (granted) startWifiScanning();
        }
    }

    private void startWifiScanning() {
        if (wifiManager == null || !wifiManager.isWifiEnabled()) {
            Toast.makeText(this, "Wi-Fi must be enabled for Bounce scanning", Toast.LENGTH_LONG).show();
            return;
        }

        IntentFilter filter = new IntentFilter();
        filter.addAction(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION);
        registerReceiver(wifiScanReceiver, filter);

        scanning = true;
        lastScanTime = System.currentTimeMillis();
        boolean started = wifiManager.startScan();
        if (!started) {
            injectJs("androidBridge('scanStatus',{status:'throttled'})");
        }

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
                json.append("\"reliable\":").append(reliable).append(",");
                json.append("\"capabilities\":\"").append(escapeJson(r.capabilities)).append("\"");
                json.append("}");
            }

            json.append("]");

            String meta = "{\"scanNum\":" + scanCount + ",\"elapsed\":" + elapsed + ",\"totalSSIDs\":" + ssidLog.size() + "}";
            injectJs("Bounce.onScanResults(" + json.toString() + "," + meta + ")");
        }
    };

    private float estimateDistance(int rssi, int frequency) {
        float exp = (27.55f - (20f * (float) Math.log10(frequency > 0 ? frequency : 2400)) + Math.abs(rssi)) / 20f;
        return (float) Math.pow(10f, exp);
    }

    private String escapeJson(String s) {
        if (s == null) return "";
        return s.replace("\\", "\\\\").replace("\"", "\\\"").replace("\n", "\\n").replace("\r", "");
    }

    private WebView buildWebView() {
        WebView wv = new WebView(this);
        wv.setLayoutParams(new FrameLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        WebSettings s = wv.getSettings();
        s.setJavaScriptEnabled(true);
        s.setDomStorageEnabled(true);
        s.setAllowFileAccess(true);
        s.setAllowFileAccessFromFileURLs(true);
        s.setAllowUniversalAccessFromFileURLs(true);
        s.setMediaPlaybackRequiresUserGesture(false);
        s.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        s.setSupportZoom(false);
        s.setBuiltInZoomControls(false);
        wv.setWebChromeClient(new WebChromeClient());
        wv.setWebViewClient(new WebViewClient() {
            public void onPageFinished(WebView v, String u) {
                v.postDelayed(() -> v.evaluateJavascript(
                    "androidBridge('onReady',{loaded:true})", null), 2000);
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
        h.setPadding(dp(16), dp(10), dp(16), dp(10));
        h.setBackgroundColor(Color.argb(190, 10, 10, 15));
        FrameLayout.LayoutParams hp = new FrameLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        hp.gravity = Gravity.TOP | Gravity.CENTER_HORIZONTAL;
        hp.topMargin = dp(20);
        h.setLayoutParams(hp);

        TextView logo = new TextView(this);
        logo.setText("BOUNCE");
        logo.setTextSize(26f);
        logo.setTextColor(Color.parseColor("#FF6600"));
        logo.setTypeface(Typeface.DEFAULT_BOLD);
        logo.setGravity(Gravity.CENTER);

        TextView tag = new TextView(this);
        tag.setText("TAF/DMV Mesh · Real Wi-Fi Scanner · v1.0.3");
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
        FrameLayout.LayoutParams bp = new FrameLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        bp.gravity = Gravity.BOTTOM;
        bar.setLayoutParams(bp);

        LinearLayout row = new LinearLayout(this);
        row.setOrientation(LinearLayout.HORIZONTAL);
        row.setGravity(Gravity.CENTER);
        row.setPadding(0, dp(8), 0, dp(8));

        row.addView(mkBtn("SCAN", "#00FF88", v -> {
            if (!scanning) startWifiScanning();
            wifiManager.startScan();
            Toast.makeText(MainActivity.this, "Scan triggered · " + ssidLog.size() + " known SSIDs", Toast.LENGTH_SHORT).show();
        }));
        row.addView(mkBtn("SCATTER", "#a855f7", v -> injectJs("Bounce.scatterBeacons()")));
        row.addView(mkBtn("BROADCAST", "#4488FF", v -> injectJs("Bounce.toggleBroadcast()")));
        row.addView(mkBtn("FLEET", "#FF6600", v -> injectJs("Bounce.toggleFleet()")));

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

    private void injectJs(String s) { webView.evaluateJavascript(s, null); }
    private int dp(int px) { return (int)(px * getResources().getDisplayMetrics().density); }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        scanning = false;
        scanHandler.removeCallbacksAndMessages(null);
        try { unregisterReceiver(wifiScanReceiver); } catch (Exception ignored) {}
    }

    public class JsBridge {
        @JavascriptInterface
        public void onReady(String j) {
            runOnUiThread(() -> Toast.makeText(MainActivity.this,
                "Bounce v1.0.3 — Real Wi-Fi Scanner Active", Toast.LENGTH_SHORT).show());
        }
    }
}
