package com.carrpod.landolil;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
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

import org.json.JSONObject;

public class MainActivity extends Activity implements SensorEventListener {

    private WebView webView;
    private GpuMonitor gpuMonitor;
    private DiagnosticPanel diagnosticPanel;
    private LinearLayout headerOverlay;
    private Button cleanViewBtn, htmlToggleBtn, iconsToggleBtn, followBtn, motionBtn;
    private boolean cleanViewMode = false;
    private boolean htmlOverlaysVisible = true;
    private boolean hudPanelsVisible = true;
    private boolean iconModeActive = false;
    private boolean followActive = false, motionActive = false;
    private int headerAlpha = 210;
    private Handler pollHandler;
    private Runnable pollRunnable;
    private SensorManager sensorManager;
    private Sensor accelerometer, gyroscope;

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

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        gyroscope = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

        gpuMonitor = new GpuMonitor(this);
        FrameLayout root = new FrameLayout(this);
        root.setBackgroundColor(Color.parseColor("#0A0A0F"));

        webView = buildWebView(); root.addView(webView);
        headerOverlay = buildHeaderOverlay(); root.addView(headerOverlay);
        FrameLayout controlBar = buildControlBar(); root.addView(controlBar);
        diagnosticPanel = new DiagnosticPanel(this, root); root.addView(diagnosticPanel.getPanel());
        root.addView(buildFloatingDiagnosticButton());

        setContentView(root);
        startPollLoop();
    }

    private WebView buildWebView() {
        WebView wv = new WebView(this);
        wv.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        WebSettings s = wv.getSettings();
        s.setJavaScriptEnabled(true); s.setDomStorageEnabled(true); s.setAllowFileAccess(true);
        s.setAllowFileAccessFromFileURLs(true); s.setAllowUniversalAccessFromFileURLs(true);
        s.setMediaPlaybackRequiresUserGesture(false);
        s.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        s.setSupportZoom(false); s.setBuiltInZoomControls(false); s.setCacheMode(WebSettings.LOAD_DEFAULT);
        wv.setWebChromeClient(new WebChromeClient());
        wv.setWebViewClient(new WebViewClient() {
            public void onPageFinished(WebView view, String url) {
                view.postDelayed(new Runnable() {
                    public void run() {
                        gpuMonitor.injectQualityScript(webView);
                        gpuMonitor.injectFpsMonitor(webView);
                        gpuMonitor.injectAdaptiveQuality(webView);
                    }
                }, 2500);
            }
        });
        wv.addJavascriptInterface(new JsBridge(), "LandOLil");
        wv.loadUrl("file:///android_asset/tardigradia.html");
        return wv;
    }

    private LinearLayout buildHeaderOverlay() {
        LinearLayout header = new LinearLayout(this);
        header.setOrientation(LinearLayout.VERTICAL); header.setGravity(Gravity.CENTER);
        header.setPadding(dp(20), dp(14), dp(20), dp(14));
        header.setBackgroundColor(Color.argb(headerAlpha, 10, 10, 15));
        FrameLayout.LayoutParams hp = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        hp.gravity = Gravity.TOP | Gravity.CENTER_HORIZONTAL; hp.topMargin = dp(24);
        header.setLayoutParams(hp);

        TextView logo = new TextView(this);
        logo.setText("Land 'O Lil"); logo.setTextSize(28f); logo.setTextColor(Color.parseColor("#FF6600"));
        logo.setTypeface(Typeface.DEFAULT_BOLD); logo.setGravity(Gravity.CENTER);

        TextView tagline = new TextView(this);
        tagline.setText("Tardigradia App Family  \u2022  v3.0.0  \u2022  Microbe Icons");
        tagline.setTextSize(11f); tagline.setTextColor(Color.parseColor("#E8E8F0"));
        tagline.setGravity(Gravity.CENTER); tagline.setPadding(0, dp(4), 0, dp(4));

        LinearLayout brightRow = new LinearLayout(this);
        brightRow.setOrientation(LinearLayout.HORIZONTAL); brightRow.setGravity(Gravity.CENTER);
        Button dimBtn = new Button(this);
        dimBtn.setText("\u2212"); dimBtn.setTextSize(14f); dimBtn.setTextColor(Color.parseColor("#FF6600"));
        dimBtn.setBackgroundColor(Color.parseColor("#1A1A2E")); dimBtn.setMinWidth(dp(36)); dimBtn.setMinHeight(dp(26));
        dimBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) { headerAlpha = Math.max(40, headerAlpha - 30); header.setBackgroundColor(Color.argb(headerAlpha, 10, 10, 15)); }
        });
        TextView brightLabel = new TextView(this);
        brightLabel.setText(" Overlay "); brightLabel.setTextSize(9f); brightLabel.setTextColor(Color.parseColor("#8888A0"));
        Button brightBtn = new Button(this);
        brightBtn.setText("+"); brightBtn.setTextSize(14f); brightBtn.setTextColor(Color.parseColor("#FF6600"));
        brightBtn.setBackgroundColor(Color.parseColor("#1A1A2E")); brightBtn.setMinWidth(dp(36)); brightBtn.setMinHeight(dp(26));
        brightBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) { headerAlpha = Math.min(255, headerAlpha + 30); header.setBackgroundColor(Color.argb(headerAlpha, 10, 10, 15)); }
        });
        brightRow.addView(dimBtn); brightRow.addView(brightLabel); brightRow.addView(brightBtn);
        header.addView(logo); header.addView(tagline); header.addView(brightRow);
        return header;
    }

    private FrameLayout buildControlBar() {
        FrameLayout bar = new FrameLayout(this);
        bar.setBackgroundColor(Color.parseColor("#E50A0A0F"));
        FrameLayout.LayoutParams bp = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        bp.gravity = Gravity.BOTTOM; bar.setLayoutParams(bp);
        LinearLayout inner = new LinearLayout(this);
        inner.setOrientation(LinearLayout.HORIZONTAL); inner.setPadding(0, dp(8), 0, dp(8)); inner.setGravity(Gravity.CENTER);

        iconsToggleBtn = new Button(this);
        iconsToggleBtn.setText("Icons: OFF"); iconsToggleBtn.setTextSize(10f);
        iconsToggleBtn.setTextColor(Color.parseColor("#f97316"));
        iconsToggleBtn.setBackgroundColor(Color.parseColor("#1A1A2E"));
        iconsToggleBtn.setPadding(dp(8), dp(6), dp(8), dp(6));
        iconsToggleBtn.setLayoutParams(new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f));
        iconsToggleBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) { toggleIconMode(); }
        });
        inner.addView(iconsToggleBtn);

        followBtn = new Button(this);
        followBtn.setText("\uD83C\uDFAF Follow"); followBtn.setTextSize(10f);
        followBtn.setTextColor(Color.parseColor("#10b981"));
        followBtn.setBackgroundColor(Color.parseColor("#1A1A2E"));
        followBtn.setPadding(dp(8), dp(6), dp(8), dp(6));
        followBtn.setLayoutParams(new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f));
        followBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                followActive = !followActive;
                followBtn.setText(followActive ? "\uD83C\uDFAF ON" : "\uD83C\uDFAF Follow");
                injectJs("CameraFollow.toggle()");
            }
        });
        inner.addView(followBtn);

        motionBtn = new Button(this);
        motionBtn.setText("\uD83D\uDCF3 Motion"); motionBtn.setTextSize(10f);
        motionBtn.setTextColor(Color.parseColor("#f97316"));
        motionBtn.setBackgroundColor(Color.parseColor("#1A1A2E"));
        motionBtn.setPadding(dp(8), dp(6), dp(8), dp(6));
        motionBtn.setLayoutParams(new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f));
        motionBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                motionActive = !motionActive;
                motionBtn.setText(motionActive ? "\uD83D\uDCF3 ON" : "\uD83D\uDCF3 Motion");
                injectJs("MotionMode.toggle()");
                if (motionActive) startSensors(); else stopSensors();
            }
        });
        inner.addView(motionBtn);

        cleanViewBtn = new Button(this);
        cleanViewBtn.setText("Clean: OFF"); cleanViewBtn.setTextSize(10f);
        cleanViewBtn.setTextColor(Color.parseColor("#FF6600"));
        cleanViewBtn.setBackgroundColor(Color.parseColor("#1A1A2E"));
        cleanViewBtn.setPadding(dp(8), dp(6), dp(8), dp(6));
        cleanViewBtn.setLayoutParams(new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f));
        cleanViewBtn.setOnClickListener(new View.OnClickListener() { public void onClick(View v) { toggleCleanView(); } });
        inner.addView(cleanViewBtn);

        htmlToggleBtn = new Button(this);
        htmlToggleBtn.setText("HTML: ON"); htmlToggleBtn.setTextSize(10f);
        htmlToggleBtn.setTextColor(Color.parseColor("#8888A0"));
        htmlToggleBtn.setBackgroundColor(Color.parseColor("#1A1A2E"));
        htmlToggleBtn.setPadding(dp(8), dp(6), dp(8), dp(6));
        htmlToggleBtn.setLayoutParams(new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f));
        htmlToggleBtn.setOnClickListener(new View.OnClickListener() { public void onClick(View v) { toggleHtmlOverlays(); } });
        inner.addView(htmlToggleBtn);

        Button hudBtn = new Button(this);
        hudBtn.setText("HUD: ON"); hudBtn.setTextSize(10f);
        hudBtn.setTextColor(Color.parseColor("#8888A0"));
        hudBtn.setBackgroundColor(Color.parseColor("#1A1A2E"));
        hudBtn.setPadding(dp(8), dp(6), dp(8), dp(6));
        hudBtn.setLayoutParams(new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f));
        hudBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                hudPanelsVisible = !hudPanelsVisible; Button b = (Button) v;
                b.setText("HUD: " + (hudPanelsVisible ? "ON" : "OFF"));
                b.setTextColor(Color.parseColor(hudPanelsVisible ? "#8888A0" : "#FF4466"));
                injectJs("(function(){var els=['hud-left','hud-right'];els.forEach(function(id){var e=document.getElementById(id);e.classList." + (hudPanelsVisible ? "remove" : "add") + "('hidden-hud');});var btn=document.getElementById('btn-toggle-hud');if(btn)btn.textContent='" + (hudPanelsVisible ? "☰ Hide Panels" : "☰ Show Panels") + "';UI.hidden=" + !hudPanelsVisible + ";})()");
            }
        });
        inner.addView(hudBtn);

        bar.addView(inner);
        return bar;
    }

    private Button buildFloatingDiagnosticButton() {
        Button btn = new Button(this);
        btn.setText("\u2699"); btn.setTextSize(18f); btn.setTextColor(Color.parseColor("#FF6600"));
        btn.setBackgroundColor(Color.parseColor("#E51A1A2E"));
        btn.setPadding(dp(8), dp(4), dp(8), dp(4)); btn.setMinWidth(dp(44)); btn.setMinHeight(dp(44));
        FrameLayout.LayoutParams fp = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        fp.gravity = Gravity.TOP | Gravity.END; fp.topMargin = dp(80); fp.rightMargin = dp(8);
        btn.setLayoutParams(fp);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) { diagnosticPanel.toggle(); if (diagnosticPanel.isOpen()) diagnosticPanel.refreshStats(); }
        });
        return btn;
    }

    private void toggleIconMode() {
        iconModeActive = !iconModeActive;
        iconsToggleBtn.setText("Icons: " + (iconModeActive ? "ON" : "OFF"));
        iconsToggleBtn.setTextColor(Color.parseColor(iconModeActive ? "#10b981" : "#f97316"));
        injectJs("sim.toggleIconMode()");
        Toast.makeText(this, iconModeActive ? "Microbe icons ACTIVE" : "Dots mode restored", Toast.LENGTH_SHORT).show();
    }

    private void toggleCleanView() {
        cleanViewMode = !cleanViewMode;
        cleanViewBtn.setText("Clean: " + (cleanViewMode ? "ON" : "OFF"));
        cleanViewBtn.setTextColor(Color.parseColor(cleanViewMode ? "#FF4466" : "#FF6600"));
        headerOverlay.setVisibility(cleanViewMode ? View.GONE : View.VISIBLE);
        Toast.makeText(this, "Clean View " + (cleanViewMode ? "ON" : "OFF"), Toast.LENGTH_SHORT).show();
    }

    private void toggleHtmlOverlays() {
        htmlOverlaysVisible = !htmlOverlaysVisible;
        htmlToggleBtn.setText("HTML: " + (htmlOverlaysVisible ? "ON" : "OFF"));
        htmlToggleBtn.setTextColor(Color.parseColor(htmlOverlaysVisible ? "#8888A0" : "#FF4466"));
        injectJs("(function(){var els=document.querySelectorAll('div[id^=\"hud-\"],h1,h2,h3,h4,span,p,a,button,header,nav,footer,label');els.forEach(function(el){el.style.display='" + (htmlOverlaysVisible ? "" : "none") + "';});})()");
        Toast.makeText(this, "HTML Overlays " + (htmlOverlaysVisible ? "VISIBLE" : "HIDDEN"), Toast.LENGTH_SHORT).show();
    }

    private void startSensors() {
        if (accelerometer != null) sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_GAME);
        if (gyroscope != null) sensorManager.registerListener(this, gyroscope, SensorManager.SENSOR_DELAY_GAME);
    }
    private void stopSensors() { sensorManager.unregisterListener(this); }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float[] v = event.values;
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER)
            injectJs("MotionMode.updateMotion("+v[0]+","+v[1]+","+v[2]+",MotionMode.gx,MotionMode.gy,MotionMode.gz)");
        else if (event.sensor.getType() == Sensor.TYPE_GYROSCOPE)
            injectJs("MotionMode.updateMotion(MotionMode.ax,MotionMode.ay,MotionMode.az,"+v[0]+","+v[1]+","+v[2]+")");
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {}

    private void injectJs(String s) { webView.evaluateJavascript(s, null); }

    private void startPollLoop() {
        pollHandler = new Handler(Looper.getMainLooper());
        pollRunnable = new Runnable() {
            public void run() {
                gpuMonitor.queryWebGlInfo(webView, new GpuMonitor.WebGlCallback() {
                    @Override
                    public void onResult(String json) {
                        if (diagnosticPanel.isOpen()) {
                            GpuMonitor.Stats s = gpuMonitor.collectStats();
                            diagnosticPanel.refreshStats();
                            diagnosticPanel.updateWebGlInfo(extractJsonValue(json, "gpu"), extractJsonValue(json, "vendor"), "", parseIntSafe(extractJsonValue(json, "fps")));
                        }
                    }
                });
                pollHandler.postDelayed(this, 3000);
            }
        };
        pollHandler.postDelayed(pollRunnable, 3000);
    }

    private String extractJsonValue(String json, String key) {
        if (json == null || json.isEmpty()) return "";
        String s = "\"" + key + "\":\""; int st = json.indexOf(s);
        if (st < 0) { s = "\"" + key + "\":"; st = json.indexOf(s); if (st < 0) return ""; st += s.length(); int en = json.indexOf(",", st); if (en < 0) en = json.indexOf("}", st); return en > 0 ? json.substring(st, en).trim() : ""; }
        st += s.length(); int en = json.indexOf("\"", st); return en > 0 ? json.substring(st, en) : "";
    }
    private int parseIntSafe(String s) { try { return Integer.parseInt(s); } catch (Exception e) { return 0; } }

    @Override
    public void onBackPressed() {
        if (diagnosticPanel.isOpen()) { diagnosticPanel.toggle(); return; }
        if (webView.canGoBack()) webView.goBack(); else super.onBackPressed();
    }
    @Override
    protected void onDestroy() { super.onDestroy(); stopSensors(); if (pollHandler != null && pollRunnable != null) pollHandler.removeCallbacks(pollRunnable); }
    private int dp(int px) { return (int)(px * getResources().getDisplayMetrics().density); }

    public class JsBridge {
        @JavascriptInterface public void onSimReady(String json) { runOnUiThread(new Runnable() { public void run() { Toast.makeText(MainActivity.this, "landolil v6b — Follow + Motion ready", Toast.LENGTH_SHORT).show(); } }); }
        @JavascriptInterface public void onHudToggled(String json) { runOnUiThread(new Runnable() { public void run() { try { JSONObject o = new JSONObject(json); hudPanelsVisible = !o.optBoolean("hidden", false); } catch (Exception e) {} } }); }
        @JavascriptInterface public void onIconModeChanged(String json) { runOnUiThread(new Runnable() { public void run() { try { JSONObject o = new JSONObject(json); String mode = o.optString("mode", "dots"); iconModeActive = "icons".equals(mode); iconsToggleBtn.setText("Icons: " + (iconModeActive ? "ON" : "OFF")); iconsToggleBtn.setTextColor(Color.parseColor(iconModeActive ? "#10b981" : "#f97316")); } catch (Exception e) {} } }); }
        @JavascriptInterface public void onMotionToggled(String json) { runOnUiThread(new Runnable() { public void run() { try { JSONObject o = new JSONObject(json); motionActive = o.optBoolean("active", false); if (motionActive) startSensors(); else stopSensors(); } catch (Exception e) {} } }); }
        @JavascriptInterface public void onFpsUpdate(int fps) { runOnUiThread(new Runnable() { public void run() { if (diagnosticPanel.isOpen()) diagnosticPanel.refreshStats(); } }); }
    }
}
