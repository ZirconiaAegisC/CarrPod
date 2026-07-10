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
import android.webkit.ValueCallback;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private WebView webView;
    private GpuMonitor gpuMonitor;
    private DiagnosticPanel diagnosticPanel;
    private LinearLayout headerOverlay;
    private Button cleanViewBtn;
    private Button diagnosticBtn;
    private boolean cleanViewMode = false;
    private boolean overlaysVisible = true;
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
        root.setLayoutParams(new ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        ));

        webView = buildWebView();
        root.addView(webView);

        headerOverlay = buildHeaderOverlay();
        root.addView(headerOverlay);

        FrameLayout controlBar = buildControlBar();
        root.addView(controlBar);

        diagnosticPanel = new DiagnosticPanel(this, root);
        root.addView(diagnosticPanel.getPanel());

        diagnosticBtn = buildFloatingDiagnosticButton();
        root.addView(diagnosticBtn);

        setContentView(root);

        injectGpuScripts();
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
        s.setMediaPlaybackRequiresUserGesture(false);
        s.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        s.setSupportZoom(false);
        s.setBuiltInZoomControls(false);
        s.setCacheMode(WebSettings.LOAD_DEFAULT);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            s.setAllowFileAccessFromFileURLs(true);
            s.setAllowUniversalAccessFromFileURLs(true);
        }

        wv.setWebChromeClient(new WebChromeClient());
        wv.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                injectGpuScripts();
            }
        });

        wv.addJavascriptInterface(new JsBridge(), "LandOLil");

        wv.loadUrl("https://fun.carrpod.net");
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
        tagline.setText("Tardigradia App Family  \u2022  v1.0.0");
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
        dimBtn.setMinWidth(dp(36));
        dimBtn.setMinHeight(dp(26));
        dimBtn.setOnClickListener(new View.OnClickListener() {
            @Override
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
        brightBtn.setMinWidth(dp(36));
        brightBtn.setMinHeight(dp(26));
        brightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
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
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        );
        bp.gravity = Gravity.BOTTOM;
        bar.setLayoutParams(bp);

        LinearLayout inner = new LinearLayout(this);
        inner.setOrientation(LinearLayout.HORIZONTAL);
        inner.setPadding(0, dp(8), 0, dp(8));
        inner.setGravity(Gravity.CENTER);

        Button fpsLabel = new Button(this);
        fpsLabel.setText("FPS: --");
        fpsLabel.setTextSize(10f);
        fpsLabel.setTextColor(Color.parseColor("#44AAFF"));
        fpsLabel.setBackgroundColor(Color.parseColor("#0A0A0F"));
        fpsLabel.setPadding(dp(10), dp(4), dp(10), dp(4));
        fpsLabel.setEnabled(false);
        inner.addView(fpsLabel);

        cleanViewBtn = new Button(this);
        cleanViewBtn.setText("Clean View: OFF");
        cleanViewBtn.setTextSize(11f);
        cleanViewBtn.setTextColor(Color.parseColor("#FF6600"));
        cleanViewBtn.setBackgroundColor(Color.parseColor("#1A1A2E"));
        cleanViewBtn.setPadding(dp(12), dp(6), dp(12), dp(6));
        cleanViewBtn.setLayoutParams(new LinearLayout.LayoutParams(
            0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f
        ));
        cleanViewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleCleanView();
            }
        });
        inner.addView(cleanViewBtn);

        Button hideOverlayBtn = new Button(this);
        hideOverlayBtn.setText("HTML: ON");
        hideOverlayBtn.setTextSize(11f);
        hideOverlayBtn.setTextColor(Color.parseColor("#8888A0"));
        hideOverlayBtn.setBackgroundColor(Color.parseColor("#1A1A2E"));
        hideOverlayBtn.setPadding(dp(12), dp(6), dp(12), dp(6));
        hideOverlayBtn.setLayoutParams(new LinearLayout.LayoutParams(
            0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f
        ));
        hideOverlayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleHtmlOverlays(hideOverlayBtn);
            }
        });
        inner.addView(hideOverlayBtn);

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
        btn.setMinWidth(dp(44));
        btn.setMinHeight(dp(44));

        FrameLayout.LayoutParams fp = new FrameLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        );
        fp.gravity = Gravity.TOP | Gravity.END;
        fp.topMargin = dp(80);
        fp.rightMargin = dp(8);
        btn.setLayoutParams(fp);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diagnosticPanel.toggle();
                if (diagnosticPanel.isOpen()) {
                    diagnosticPanel.refreshStats();
                    queryWebGlPoll();
                }
            }
        });

        return btn;
    }

    private void toggleCleanView() {
        cleanViewMode = !cleanViewMode;
        cleanViewBtn.setText("Clean View: " + (cleanViewMode ? "ON" : "OFF"));

        if (cleanViewMode) {
            headerOverlay.setVisibility(View.GONE);
        } else {
            headerOverlay.setVisibility(View.VISIBLE);
        }

        Toast.makeText(this,
            "Clean View " + (cleanViewMode ? "ON — 3D only" : "OFF — overlays restored"),
            Toast.LENGTH_SHORT).show();
    }

    private void toggleHtmlOverlays(final Button btn) {
        overlaysVisible = !overlaysVisible;
        btn.setText("HTML: " + (overlaysVisible ? "ON" : "OFF"));
        btn.setTextColor(Color.parseColor(overlaysVisible ? "#8888A0" : "#FF4466"));

        String script =
            "(function(){" +
            "  var els=document.querySelectorAll('div,h1,h2,h3,h4,span,p,a,button,header,nav,footer,label');" +
            "  els.forEach(function(el){" +
            "    el.style.display='" + (overlaysVisible ? "" : "none") + "';" +
            "  });" +
            "})();";
        webView.evaluateJavascript(script, null);

        Toast.makeText(this,
            "HTML Overlays " + (overlaysVisible ? "VISIBLE" : "HIDDEN — 3D only"),
            Toast.LENGTH_SHORT).show();
    }

    private void injectGpuScripts() {
        webView.postDelayed(new Runnable() {
            @Override
            public void run() {
                gpuMonitor.injectQualityScript(webView);
                gpuMonitor.injectFpsMonitor(webView);
                gpuMonitor.injectAdaptiveQuality(webView);
                gpuMonitor.injectOverlayToggle(webView);
            }
        }, 2000);
    }

    private void startPollLoop() {
        pollHandler = new Handler(Looper.getMainLooper());
        pollRunnable = new Runnable() {
            @Override
            public void run() {
                queryWebGlPoll();
                pollHandler.postDelayed(this, 3000);
            }
        };
        pollHandler.postDelayed(pollRunnable, 3000);
    }

    private void queryWebGlPoll() {
        gpuMonitor.queryWebGlInfo(webView, new GpuMonitor.WebGlCallback() {
            @Override
            public void onResult(String json) {
                updateUiFromWebGl(json);
            }
        });
    }

    private void updateUiFromWebGl(String json) {
        if (diagnosticPanel.isOpen()) {
            GpuMonitor.Stats s = gpuMonitor.collectStats();
            diagnosticPanel.refreshStats();

            String gpu = extractJsonValue(json, "gpu");
            String vendor = extractJsonValue(json, "vendor");
            int fps = parseIntSafe(extractJsonValue(json, "fps"));
            diagnosticPanel.updateWebGlInfo(gpu, vendor, "", fps);
        }
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
            if (end < 0) return "";
            return json.substring(start, end).trim();
        }
        start += search.length();
        int end = json.indexOf("\"", start);
        if (end < 0) return "";
        return json.substring(start, end);
    }

    private int parseIntSafe(String s) {
        try { return Integer.parseInt(s); }
        catch (Exception e) { return 0; }
    }

    @Override
    public void onBackPressed() {
        if (diagnosticPanel.isOpen()) {
            diagnosticPanel.toggle();
            return;
        }
        if (webView != null && webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (pollHandler != null && pollRunnable != null) {
            pollHandler.removeCallbacks(pollRunnable);
        }
    }

    private int dp(int px) {
        return (int)(px * getResources().getDisplayMetrics().density);
    }

    public class JsBridge {
        @JavascriptInterface
        public void onFpsUpdate(int fps) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (diagnosticPanel.isOpen()) {
                        diagnosticPanel.refreshStats();
                    }
                }
            });
        }

        @JavascriptInterface
        public void onQualityChanged(String tier) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(MainActivity.this,
                        "Quality: " + tier.toUpperCase(),
                        Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
