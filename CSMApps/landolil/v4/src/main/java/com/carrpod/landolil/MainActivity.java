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
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

public class MainActivity extends Activity implements SensorEventListener {

    private WebView webView;
    private GpuMonitor gpuMonitor;
    private DiagnosticPanel diagnosticPanel;
    private LinearLayout headerOverlay;
    private Button cleanViewBtn, htmlToggleBtn, followBtn, motionBtn;
    private SeekBar iconMixSlider, proxSlider;
    private TextView iconMixVal, proxVal;
    private boolean cleanViewMode = false, htmlOverlaysVisible = true, hudPanelsVisible = true;
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
            public void onPageFinished(WebView v, String u) {
                v.postDelayed(new Runnable() { public void run() {
                    gpuMonitor.injectQualityScript(webView);
                    gpuMonitor.injectFpsMonitor(webView);
                    gpuMonitor.injectAdaptiveQuality(webView);
                }}, 2500);
            }
        });
        wv.addJavascriptInterface(new JsBridge(), "LandOLil");
        wv.loadUrl("file:///android_asset/tardigradia.html");
        return wv;
    }

    private LinearLayout buildHeaderOverlay() {
        LinearLayout h = new LinearLayout(this);
        h.setOrientation(LinearLayout.VERTICAL); h.setGravity(Gravity.CENTER);
        h.setPadding(dp(20), dp(14), dp(20), dp(14));
        h.setBackgroundColor(Color.argb(headerAlpha, 10, 10, 15));
        FrameLayout.LayoutParams hp = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        hp.gravity = Gravity.TOP | Gravity.CENTER_HORIZONTAL; hp.topMargin = dp(24); h.setLayoutParams(hp);

        TextView logo = new TextView(this);
        logo.setText("Land 'O Lil"); logo.setTextSize(28f); logo.setTextColor(Color.parseColor("#FF6600"));
        logo.setTypeface(Typeface.DEFAULT_BOLD); logo.setGravity(Gravity.CENTER);

        TextView tag = new TextView(this);
        tag.setText("Tardigradia v4.0  \u2022  Proximity + Motion + Follow");
        tag.setTextSize(11f); tag.setTextColor(Color.parseColor("#E8E8F0")); tag.setGravity(Gravity.CENTER);

        LinearLayout br = new LinearLayout(this);
        br.setOrientation(LinearLayout.HORIZONTAL); br.setGravity(Gravity.CENTER);
        Button dim = makeTinyBtn("\u2212", new View.OnClickListener() { public void onClick(View v) { headerAlpha=Math.max(40,headerAlpha-30); h.setBackgroundColor(Color.argb(headerAlpha,10,10,15)); } });
        TextView bl = new TextView(this); bl.setText("Bright"); bl.setTextSize(9f); bl.setTextColor(Color.parseColor("#8888A0"));
        Button bri = makeTinyBtn("+", new View.OnClickListener() { public void onClick(View v) { headerAlpha=Math.min(255,headerAlpha+30); h.setBackgroundColor(Color.argb(headerAlpha,10,10,15)); } });
        br.addView(dim); br.addView(bl); br.addView(bri);
        h.addView(logo); h.addView(tag); h.addView(br);
        return h;
    }

    private FrameLayout buildControlBar() {
        FrameLayout bar = new FrameLayout(this);
        bar.setBackgroundColor(Color.parseColor("#E50A0A0F"));
        FrameLayout.LayoutParams bp = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        bp.gravity = Gravity.BOTTOM; bar.setLayoutParams(bp);

        LinearLayout col = new LinearLayout(this);
        col.setOrientation(LinearLayout.VERTICAL);
        col.setPadding(dp(8), dp(4), dp(8), dp(4));

        // Row 1: Icon Mix slider
        LinearLayout row1 = new LinearLayout(this);
        row1.setOrientation(LinearLayout.HORIZONTAL); row1.setGravity(Gravity.CENTER_VERTICAL);
        TextView iLabel = new TextView(this); iLabel.setText("Icons:"); iLabel.setTextSize(10f); iLabel.setTextColor(Color.parseColor("#8888A0")); iLabel.setPadding(0,0,dp(4),0);
        iconMixSlider = new SeekBar(this);
        iconMixSlider.setMax(100); iconMixSlider.setProgress(50);
        iconMixSlider.setLayoutParams(new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f));
        iconMixSlider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar sb, int v, boolean u) { injectJs("sim.setIconMix("+v+")"); iconMixVal.setText(v+"%"); }
            public void onStartTrackingTouch(SeekBar sb) {}
            public void onStopTrackingTouch(SeekBar sb) {}
        });
        iconMixVal = new TextView(this); iconMixVal.setText("50%"); iconMixVal.setTextSize(10f); iconMixVal.setTextColor(Color.parseColor("#FF6600")); iconMixVal.setPadding(dp(4),0,dp(8),0);
        row1.addView(iLabel); row1.addView(iconMixSlider); row1.addView(iconMixVal);
        col.addView(row1);

        // Row 2: Proximity Sharpen slider
        LinearLayout row2 = new LinearLayout(this);
        row2.setOrientation(LinearLayout.HORIZONTAL); row2.setGravity(Gravity.CENTER_VERTICAL);
        TextView pLabel = new TextView(this); pLabel.setText("Sharp:"); pLabel.setTextSize(10f); pLabel.setTextColor(Color.parseColor("#8888A0")); pLabel.setPadding(0,0,dp(4),0);
        proxSlider = new SeekBar(this);
        proxSlider.setMax(100); proxSlider.setProgress(50);
        proxSlider.setLayoutParams(new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f));
        proxSlider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar sb, int v, boolean u) { injectJs("sim.setProximity("+v+")"); proxVal.setText(String.format("%.2f",v/100f)); }
            public void onStartTrackingTouch(SeekBar sb) {}
            public void onStopTrackingTouch(SeekBar sb) {}
        });
        proxVal = new TextView(this); proxVal.setText("0.50"); proxVal.setTextSize(10f); proxVal.setTextColor(Color.parseColor("#FF6600")); proxVal.setPadding(dp(4),0,dp(8),0);
        row2.addView(pLabel); row2.addView(proxSlider); row2.addView(proxVal);
        col.addView(row2);

        // Row 3: Action buttons
        LinearLayout row3 = new LinearLayout(this);
        row3.setOrientation(LinearLayout.HORIZONTAL); row3.setGravity(Gravity.CENTER);
        row3.setPadding(0, dp(4), 0, dp(2));

        followBtn = makeActionBtn("🎯 Follow", "#10b981", new View.OnClickListener() {
            public void onClick(View v) {
                followActive = !followActive;
                followBtn.setText(followActive ? "🎯 Following" : "🎯 Follow");
                followBtn.setTextColor(Color.parseColor(followActive ? "#10b981" : "#10b981"));
                injectJs("CameraFollow.toggle()");
            }
        });
        row3.addView(followBtn);

        motionBtn = makeActionBtn("📳 Motion", "#f97316", new View.OnClickListener() {
            public void onClick(View v) {
                motionActive = !motionActive;
                motionBtn.setText(motionActive ? "📳 Motion ON" : "📳 Motion");
                motionBtn.setTextColor(Color.parseColor(motionActive ? "#f97316" : "#f97316"));
                injectJs("MotionMode.toggle()");
                if (motionActive) startSensors(); else stopSensors();
            }
        });
        row3.addView(motionBtn);

        cleanViewBtn = makeActionBtn("Clean", "#FF6600", new View.OnClickListener() {
            public void onClick(View v) {
                cleanViewMode = !cleanViewMode;
                cleanViewBtn.setText(cleanViewMode ? "Clean ON" : "Clean");
                cleanViewBtn.setTextColor(Color.parseColor(cleanViewMode ? "#FF4466" : "#FF6600"));
                headerOverlay.setVisibility(cleanViewMode ? View.GONE : View.VISIBLE);
            }
        });
        row3.addView(cleanViewBtn);

        htmlToggleBtn = makeActionBtn("HTML", "#8888A0", new View.OnClickListener() {
            public void onClick(View v) {
                htmlOverlaysVisible = !htmlOverlaysVisible;
                htmlToggleBtn.setText(htmlOverlaysVisible ? "HTML ON" : "HTML OFF");
                htmlToggleBtn.setTextColor(Color.parseColor(htmlOverlaysVisible ? "#8888A0" : "#FF4466"));
                injectJs("(function(){var e=document.querySelectorAll('div[id^=\"hud-\"],h1,span,p,button,header');e.forEach(function(el){el.style.display='"+(htmlOverlaysVisible?"":"none")+"'});})()");
            }
        });
        row3.addView(htmlToggleBtn);

        col.addView(row3);
        bar.addView(col);
        return bar;
    }

    private Button makeTinyBtn(String label, View.OnClickListener l) {
        Button b = new Button(this); b.setText(label); b.setTextSize(14f);
        b.setTextColor(Color.parseColor("#FF6600")); b.setBackgroundColor(Color.parseColor("#1A1A2E"));
        b.setMinWidth(dp(36)); b.setMinHeight(dp(26)); b.setPadding(dp(10),dp(1),dp(10),dp(1)); b.setOnClickListener(l); return b;
    }

    private Button makeActionBtn(String label, String color, View.OnClickListener l) {
        Button b = new Button(this);
        b.setText(label); b.setTextSize(10f); b.setTextColor(Color.parseColor(color));
        b.setBackgroundColor(Color.parseColor("#1A1A2E"));
        b.setPadding(dp(6), dp(6), dp(6), dp(6));
        b.setLayoutParams(new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f));
        b.setOnClickListener(l);
        return b;
    }

    private Button buildFloatingDiagnosticButton() {
        Button btn = new Button(this);
        btn.setText("\u2699"); btn.setTextSize(18f); btn.setTextColor(Color.parseColor("#FF6600"));
        btn.setBackgroundColor(Color.parseColor("#E51A1A2E"));
        btn.setPadding(dp(8),dp(4),dp(8),dp(4)); btn.setMinWidth(dp(44)); btn.setMinHeight(dp(44));
        FrameLayout.LayoutParams fp = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        fp.gravity = Gravity.TOP | Gravity.END; fp.topMargin = dp(80); fp.rightMargin = dp(8); btn.setLayoutParams(fp);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) { diagnosticPanel.toggle(); if(diagnosticPanel.isOpen())diagnosticPanel.refreshStats(); }
        });
        return btn;
    }

    // ═══════════════════════════════════════════════
    // MOTION SENSORS
    private void startSensors() {
        if (accelerometer != null) sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_GAME);
        if (gyroscope != null) sensorManager.registerListener(this, gyroscope, SensorManager.SENSOR_DELAY_GAME);
    }

    private void stopSensors() {
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float[] v = event.values;
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            injectJs("MotionMode.updateMotion("+v[0]+","+v[1]+","+v[2]+", MotionMode.gx,MotionMode.gy,MotionMode.gz)");
        } else if (event.sensor.getType() == Sensor.TYPE_GYROSCOPE) {
            injectJs("MotionMode.updateMotion(MotionMode.ax,MotionMode.ay,MotionMode.az, "+v[0]+","+v[1]+","+v[2]+")");
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {}

    // ═══════════════════════════════════════════════
    private void injectJs(String s) { webView.evaluateJavascript(s, null); }

    private void startPollLoop() {
        pollHandler = new Handler(Looper.getMainLooper());
        pollRunnable = new Runnable() { public void run() {
            gpuMonitor.queryWebGlInfo(webView, new GpuMonitor.WebGlCallback() {
                public void onResult(String json) {
                    if (diagnosticPanel.isOpen()) {
                        GpuMonitor.Stats s = gpuMonitor.collectStats();
                        diagnosticPanel.refreshStats();
                        diagnosticPanel.updateWebGlInfo(extractJs(json,"gpu"), extractJs(json,"vendor"), "", parseIntSafe(extractJs(json,"fps")));
                    }
                }
            });
            pollHandler.postDelayed(this, 3000);
        }};
        pollHandler.postDelayed(pollRunnable, 3000);
    }

    private String extractJs(String json, String key) {
        if (json==null||json.isEmpty()) return "";
        String s = "\""+key+"\":\""; int st=json.indexOf(s);
        if(st<0){s="\""+key+"\":";st=json.indexOf(s);if(st<0)return"";st+=s.length();int en=json.indexOf(",",st);if(en<0)en=json.indexOf("}",st);return en>0?json.substring(st,en).trim():"";}
        st+=s.length();int en=json.indexOf("\"",st);return en>0?json.substring(st,en):"";
    }
    private int parseIntSafe(String s){try{return Integer.parseInt(s);}catch(Exception e){return 0;}}

    @Override
    public void onBackPressed() {
        if(diagnosticPanel.isOpen()){diagnosticPanel.toggle();return;}
        if(webView.canGoBack())webView.goBack();else super.onBackPressed();
    }
    @Override protected void onDestroy() {
        super.onDestroy(); stopSensors();
        if(pollHandler!=null&&pollRunnable!=null)pollHandler.removeCallbacks(pollRunnable);
    }
    private int dp(int px){return(int)(px*getResources().getDisplayMetrics().density);}

    public class JsBridge {
        @JavascriptInterface public void onSimReady(String j){runOnUiThread(new Runnable(){public void run(){Toast.makeText(MainActivity.this,"V4 Proximity+Motion+Follow ready",Toast.LENGTH_SHORT).show();}});}
        @JavascriptInterface public void onHudToggled(String j){runOnUiThread(new Runnable(){public void run(){try{JSONObject o=new JSONObject(j);hudPanelsVisible=!o.optBoolean("hidden",false);}catch(Exception e){}}});}
        @JavascriptInterface public void onMotionToggled(String j){runOnUiThread(new Runnable(){public void run(){try{JSONObject o=new JSONObject(j);motionActive=o.optBoolean("active",false);if(motionActive)startSensors();else stopSensors();}catch(Exception e){}}});}
        @JavascriptInterface public void onMotionUpdate(String j){/* accelerometer values echoed back from JS - no action needed */ }
        @JavascriptInterface public void onFpsUpdate(int fps){runOnUiThread(new Runnable(){public void run(){if(diagnosticPanel.isOpen())diagnosticPanel.refreshStats();}});}
    }
}
