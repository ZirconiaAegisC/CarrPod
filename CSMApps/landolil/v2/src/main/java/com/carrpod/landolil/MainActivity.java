package com.carrpod.landolil;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
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

public class MainActivity extends Activity {

    private WebView webView;
    private GpuMonitor gpuMonitor;
    private DiagnosticPanel diagnosticPanel;
    private LinearLayout headerOverlay;
    private Button cleanViewBtn;
    private Button htmlToggleBtn;
    private boolean cleanViewMode = false;
    private boolean htmlOverlaysVisible = true;
    private boolean hudPanelsVisible = true;
    private int headerAlpha = 210;
    private Handler pollHandler;
    private Runnable pollRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            getWindow().setDecorFitsSystemWindows(false);
        } else {
            getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            );
        }

        gpuMonitor = new GpuMonitor(this);

        FrameLayout root = new FrameLayout(this);
        root.setBackgroundColor(Color.parseColor("#0A0A0F"));

        webView = buildWebView();
        root.addView(webView);

        headerOverlay = buildHeaderOverlay();
        root.addView(headerOverlay);

        FrameLayout controlBar = buildControlBar();
        root.addView(controlBar);

        diagnosticPanel = new DiagnosticPanel(this, root);
        root.addView(diagnosticPanel.getPanel());

        Button diagBtn = buildFloatingDiagnosticButton();
        root.addView(diagBtn);

        setContentView(root);

        startPollLoop();
    }

    private WebView buildWebView() {
        WebView wv = new WebView(this);
        wv.setLayoutParams(new FrameLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        ));

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
        s.setCacheMode(WebSettings.LOAD_DEFAULT);

        wv.setWebChromeClient(new WebChromeClient());
        wv.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                injectNativeControls();
            }
        });

        wv.addJavascriptInterface(new JsBridge(), "LandOLil");

        wv.loadUrl("file:///android_asset/tardigradia.html");
        return wv;
    }

    private LinearLayout buildHeaderOverlay() {
        LinearLayout header = new LinearLayout(this);
        header.setOrientation(LinearLayout.VERTICAL);
        header.setGravity(Gravity.CENTER);
        header.setPadding(dp(20), dp(14), dp(20), dp(14));
        header.setBackgroundColor(Color.argb(headerAlpha, 10, 10, 15));

        FrameLayout.LayoutParams hp = new FrameLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        );
        hp.gravity = Gravity.TOP | Gravity.CENTER_HORIZONTAL;
        hp.topMargin = dp(24);
        header.setLayoutParams(hp);

        TextView logo = new TextView(this);
        logo.setText("Land 'O Lil");
        logo.setTextSize(28f);
        logo.setTextColor(Color.parseColor("#FF6600"));
        logo.setTypeface(Typeface.DEFAULT_BOLD);
        logo.setGravity(Gravity.CENTER);

        TextView tagline = new TextView(this);
        tagline.setText("Tardigradia App Family  \u2022  v2.0.0  \u2022  Local Bundle");
        tagline.setTextSize(11f);
        tagline.setTextColor(Color.parseColor("#E8E8F0"));
        tagline.setGravity(Gravity.CENTER);
        tagline.setPadding(0, dp(4), 0, dp(4));

        LinearLayout brightRow = new LinearLayout(this);
        brightRow.setOrientation(LinearLayout.HORIZONTAL);
        brightRow.setGravity(Gravity.CENTER);

        Button dimBtn = new Button(this);
        dimBtn.setText("\u2212");
        dimBtn.setTextSize(14f);
        dimBtn.setTextColor(Color.parseColor("#FF6600"));
        dimBtn.setBackgroundColor(Color.parseColor("#1A1A2E"));
        dimBtn.setPadding(dp(10), dp(1), dp(10), dp(1));
        dimBtn.setMinWidth(dp(36)); dimBtn.setMinHeight(dp(26));
        dimBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                headerAlpha = Math.max(40, headerAlpha - 30);
                header.setBackgroundColor(Color.argb(headerAlpha, 10, 10, 15));
            }
        });

        TextView brightLabel = new TextView(this);
        brightLabel.setText(" Overlay ");
        brightLabel.setTextSize(9f);
        brightLabel.setTextColor(Color.parseColor("#8888A0"));
        brightLabel.setPadding(dp(4), 0, dp(4), 0);

        Button brightBtn = new Button(this);
        brightBtn.setText("+");
        brightBtn.setTextSize(14f);
        brightBtn.setTextColor(Color.parseColor("#FF6600"));
        brightBtn.setBackgroundColor(Color.parseColor("#1A1A2E"));
        brightBtn.setPadding(dp(10), dp(1), dp(10), dp(1));
        brightBtn.setMinWidth(dp(36)); brightBtn.setMinHeight(dp(26));
        brightBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                headerAlpha = Math.min(255, headerAlpha + 30);
                header.setBackgroundColor(Color.argb(headerAlpha, 10, 10, 15));
            }
        });

        brightRow.addView(dimBtn);
        brightRow.addView(brightLabel);
        brightRow.addView(brightBtn);

        header.addView(logo);
        header.addView(tagline);
        header.addView(brightRow);

        return header;
    }

    private FrameLayout buildControlBar() {
        FrameLayout bar = new FrameLayout(this);
        bar.setBackgroundColor(Color.parseColor("#E50A0A0F"));
        FrameLayout.LayoutParams bp = new FrameLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        bp.gravity = Gravity.BOTTOM;
        bar.setLayoutParams(bp);

        LinearLayout inner = new LinearLayout(this);
        inner.setOrientation(LinearLayout.HORIZONTAL);
        inner.setPadding(0, dp(8), 0, dp(8));
        inner.setGravity(Gravity.CENTER);

        cleanViewBtn = new Button(this);
        cleanViewBtn.setText("Clean View: OFF");
        cleanViewBtn.setTextSize(11f);
        cleanViewBtn.setTextColor(Color.parseColor("#FF6600"));
        cleanViewBtn.setBackgroundColor(Color.parseColor("#1A1A2E"));
        cleanViewBtn.setPadding(dp(10), dp(6), dp(10), dp(6));
        cleanViewBtn.setLayoutParams(new LinearLayout.LayoutParams(
            0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f));
        cleanViewBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) { toggleCleanView(); }
        });
        inner.addView(cleanViewBtn);

        htmlToggleBtn = new Button(this);
        htmlToggleBtn.setText("HTML: ON");
        htmlToggleBtn.setTextSize(11f);
        htmlToggleBtn.setTextColor(Color.parseColor("#8888A0"));
        htmlToggleBtn.setBackgroundColor(Color.parseColor("#1A1A2E"));
        htmlToggleBtn.setPadding(dp(10), dp(6), dp(10), dp(6));
        htmlToggleBtn.setLayoutParams(new LinearLayout.LayoutParams(
            0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f));
        htmlToggleBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) { toggleHtmlOverlays(); }
        });
        inner.addView(htmlToggleBtn);

        Button hudBtn = new Button(this);
        hudBtn.setText("HUD: ON");
        hudBtn.setTextSize(11f);
        hudBtn.setTextColor(Color.parseColor("#8888A0"));
        hudBtn.setBackgroundColor(Color.parseColor("#1A1A2E"));
        hudBtn.setPadding(dp(10), dp(6), dp(10), dp(6));
        hudBtn.setLayoutParams(new LinearLayout.LayoutParams(
            0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f));
        hudBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                hudPanelsVisible = !hudPanelsVisible;
                Button b = (Button) v;
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
        btn.setText("\u2699");
        btn.setTextSize(18f);
        btn.setTextColor(Color.parseColor("#FF6600"));
        btn.setBackgroundColor(Color.parseColor("#E51A1A2E"));
        btn.setPadding(dp(8), dp(4), dp(8), dp(4));
        btn.setMinWidth(dp(44)); btn.setMinHeight(dp(44));
        FrameLayout.LayoutParams fp = new FrameLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        fp.gravity = Gravity.TOP | Gravity.END;
        fp.topMargin = dp(80); fp.rightMargin = dp(8);
        btn.setLayoutParams(fp);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                diagnosticPanel.toggle();
                if (diagnosticPanel.isOpen()) diagnosticPanel.refreshStats();
            }
        });
        return btn;
    }

    private void toggleCleanView() {
        cleanViewMode = !cleanViewMode;
        cleanViewBtn.setText("Clean View: " + (cleanViewMode ? "ON" : "OFF"));
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

    private void injectNativeControls() {
        webView.postDelayed(new Runnable() {
            public void run() {
                gpuMonitor.injectQualityScript(webView);
                gpuMonitor.injectFpsMonitor(webView);
                gpuMonitor.injectAdaptiveQuality(webView);
            }
        }, 2500);
    }

    private void injectJs(String script) {
        webView.evaluateJavascript(script, null);
    }

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
                            diagnosticPanel.updateWebGlInfo(
                                extractJsonValue(json, "gpu"),
                                extractJsonValue(json, "vendor"),
                                "", parseIntSafe(extractJsonValue(json, "fps")));
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
        String search = "\"" + key + "\":\"";
        int start = json.indexOf(search);
        if (start < 0) {
            search = "\"" + key + "\":";
            start = json.indexOf(search);
            if (start < 0) return "";
            start += search.length();
            int end = json.indexOf(",", start);
            if (end < 0) end = json.indexOf("}", start);
            return end > 0 ? json.substring(start, end).trim() : "";
        }
        start += search.length();
        int end = json.indexOf("\"", start);
        return end > 0 ? json.substring(start, end) : "";
    }

    private int parseIntSafe(String s) {
        try { return Integer.parseInt(s); } catch (Exception e) { return 0; }
    }

    @Override
    public void onBackPressed() {
        if (diagnosticPanel.isOpen()) { diagnosticPanel.toggle(); return; }
        if (webView.canGoBack()) { webView.goBack(); }
        else { super.onBackPressed(); }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (pollHandler != null && pollRunnable != null)
            pollHandler.removeCallbacks(pollRunnable);
    }

    private int dp(int px) {
        return (int)(px * getResources().getDisplayMetrics().density);
    }

    // ═══════════════════════════════════════════════════
    // JAVASCRIPT BRIDGE — Called from tardigradia.html
    // ═══════════════════════════════════════════════════
    public class JsBridge {
        @JavascriptInterface
        public void onSimReady(String json) {
            runOnUiThread(new Runnable() {
                public void run() {
                    Toast.makeText(MainActivity.this,
                        "Tardigradia engine online — local bundle, zero CDN",
                        Toast.LENGTH_SHORT).show();
                }
            });
        }

        @JavascriptInterface
        public void onHudToggled(String json) {
            runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        JSONObject obj = new JSONObject(json);
                        boolean hidden = obj.optBoolean("hidden", false);
                        hudPanelsVisible = !hidden;
                    } catch (Exception e) {}
                }
            });
        }

        @JavascriptInterface
        public void onFpsUpdate(final int fps) {
            runOnUiThread(new Runnable() {
                public void run() {
                    if (diagnosticPanel.isOpen()) diagnosticPanel.refreshStats();
                }
            });
        }
    }
}
