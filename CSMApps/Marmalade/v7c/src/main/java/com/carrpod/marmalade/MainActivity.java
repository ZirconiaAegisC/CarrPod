package com.carrpod.marmalade;

import android.app.Activity;
import android.content.Context;
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
    private LinearLayout headerOverlay;
    private Button cleanViewBtn, clearUiBtn;
    private boolean cleanViewMode = false, panelsCleared = false;

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

        headerOverlay = buildHeaderOverlay();
        root.addView(headerOverlay);

        FrameLayout controlBar = buildControlBar();
        root.addView(controlBar);

        setContentView(root);
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
        s.setCacheMode(WebSettings.LOAD_DEFAULT);
        wv.setWebChromeClient(new WebChromeClient());
        wv.setWebViewClient(new WebViewClient() {
            public void onPageFinished(WebView v, String u) {
                v.postDelayed(new Runnable() {
                    public void run() {
                        v.evaluateJavascript(
                            "androidBridge('onReady',{loaded:true})", null);
                    }
                }, 2000);
            }
        });
        wv.addJavascriptInterface(new JsBridge(), "Marmalade");
        wv.loadUrl("file:///android_asset/marmalade.html");
        return wv;
    }

    private LinearLayout buildHeaderOverlay() {
        LinearLayout h = new LinearLayout(this);
        h.setOrientation(LinearLayout.VERTICAL);
        h.setGravity(Gravity.CENTER);
        h.setPadding(dp(20), dp(14), dp(20), dp(14));
        h.setBackgroundColor(Color.argb(210, 10, 10, 15));
        FrameLayout.LayoutParams hp = new FrameLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        hp.gravity = Gravity.TOP | Gravity.CENTER_HORIZONTAL;
        hp.topMargin = dp(24);
        h.setLayoutParams(hp);

        TextView logo = new TextView(this);
        logo.setText("MARMALADE");
        logo.setTextSize(28f);
        logo.setTextColor(Color.parseColor("#FF6600"));
        logo.setTypeface(Typeface.DEFAULT_BOLD);
        logo.setGravity(Gravity.CENTER);

        TextView tag = new TextView(this);
        tag.setText("Monistic Engine v7c \u2022 3D Alphabet Engine \u2022 CarrPod");
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

        row.addView(barBtn("FLY", "#f97316", new View.OnClickListener() {
            public void onClick(View v) { injectJs("Engine.startFly()"); }
        }));
        row.addView(barBtn("BURST", "#f97316", new View.OnClickListener() {
            public void onClick(View v) { injectJs("Engine.burstAll()"); }
        }));
        row.addView(barBtn("CONVERGE", "#10b981", new View.OnClickListener() {
            public void onClick(View v) { injectJs("Engine.convergeAll()"); }
        }));
        row.addView(barBtn("SCATTER", "#a855f7", new View.OnClickListener() {
            public void onClick(View v) { injectJs("Engine.scatterAll()"); }
        }));

        clearUiBtn = barBtn("CLEAR UI", "#10b981", new View.OnClickListener() {
            public void onClick(View v) {
                panelsCleared = !panelsCleared;
                if (panelsCleared) {
                    injectJs("UI.clearAll()");
                    clearUiBtn.setText("RESET UI");
                    clearUiBtn.setTextColor(Color.parseColor("#FFCC00"));
                    Toast.makeText(MainActivity.this, "Panels moved off screen — drag or tap RESET", Toast.LENGTH_SHORT).show();
                } else {
                    injectJs("UI.resetPanels()");
                    clearUiBtn.setText("CLEAR UI");
                    clearUiBtn.setTextColor(Color.parseColor("#10b981"));
                }
            }
        });
        row.addView(clearUiBtn);

        cleanViewBtn = barBtn("Clean", "#FF6600", new View.OnClickListener() {
            public void onClick(View v) {
                cleanViewMode = !cleanViewMode;
                cleanViewBtn.setText(cleanViewMode ? "Clean ON" : "Clean");
                cleanViewBtn.setTextColor(Color.parseColor(cleanViewMode ? "#FF4466" : "#FF6600"));
                headerOverlay.setVisibility(cleanViewMode ? View.GONE : View.VISIBLE);
            }
        });
        row.addView(cleanViewBtn);

        bar.addView(row);
        return bar;
    }

    private Button barBtn(String t, String color, View.OnClickListener l) {
        Button b = new Button(this);
        b.setText(t);
        b.setTextSize(10f);
        b.setTextColor(Color.parseColor(color));
        b.setBackgroundColor(Color.parseColor("#1A1A2E"));
        b.setPadding(dp(8), dp(8), dp(8), dp(8));
        b.setLayoutParams(new LinearLayout.LayoutParams(
            0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f));
        b.setOnClickListener(l);
        return b;
    }

    private void injectJs(String s) {
        webView.evaluateJavascript(s, null);
    }

    private int dp(int px) {
        return (int)(px * getResources().getDisplayMetrics().density);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public class JsBridge {
        @JavascriptInterface
        public void onReady(String j) {
            runOnUiThread(new Runnable() {
                public void run() {
                    Toast.makeText(MainActivity.this,
                        "Marmalade v7c \u2014 3D Alphabet Engine", Toast.LENGTH_SHORT).show();
                }
            });
        }

        @JavascriptInterface
        public void onSimReady(String j) {
            runOnUiThread(new Runnable() {
                public void run() {
                    Toast.makeText(MainActivity.this,
                        "Marmalade v7c \u2014 Engine Loaded", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
