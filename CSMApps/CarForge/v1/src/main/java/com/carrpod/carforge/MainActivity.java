package com.carrpod.carforge;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
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

public class MainActivity extends Activity {

    private WebView webView;
    private LinearLayout headerOverlay;
    private boolean cleanViewMode = false, panelsTucked = false;
    private Button cleanBtn, tuckBtn;

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
        wv.addJavascriptInterface(new JsBridge(), "CarForge");
        wv.loadUrl("file:///android_asset/carforge.html");
        return wv;
    }

    private LinearLayout buildHeader() {
        LinearLayout h = new LinearLayout(this);
        h.setOrientation(LinearLayout.VERTICAL);
        h.setGravity(Gravity.CENTER);
        h.setPadding(dp(18), dp(12), dp(18), dp(12));
        h.setBackgroundColor(Color.argb(200, 10, 10, 15));
        FrameLayout.LayoutParams hp = new FrameLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        hp.gravity = Gravity.TOP | Gravity.CENTER_HORIZONTAL;
        hp.topMargin = dp(22);
        h.setLayoutParams(hp);

        TextView logo = new TextView(this);
        logo.setText("CARFORGE");
        logo.setTextSize(28f);
        logo.setTextColor(Color.parseColor("#FF6600"));
        logo.setTypeface(Typeface.DEFAULT_BOLD);
        logo.setGravity(Gravity.CENTER);

        TextView tag = new TextView(this);
        tag.setText("3D Alphabet Engine v1.0  \u2022  Collision Physics  \u2022  CarrPod");
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

        row.addView(mkBtn("FLY", "#f97316", v -> injectJs("Engine.startFly()")));
        row.addView(mkBtn("BURST", "#f97316", v -> injectJs("Engine.burstAll()")));
        row.addView(mkBtn("CONVERGE", "#10b981", v -> injectJs("Engine.convergeAll()")));
        row.addView(mkBtn("SCATTER", "#a855f7", v -> injectJs("Engine.scatterAll()")));

        tuckBtn = mkBtn("TUCK", "#10b981", v -> {
            panelsTucked = !panelsTucked;
            if (panelsTucked) {
                injectJs("UI.tuckedAll=true;UI.leftTucked=true;UI.rightTucked=true;document.getElementById('hud-left').style.transform='translateX(calc(-100% + 32px))';document.getElementById('hud-right').style.transform='translateX(calc(100% - 32px))'");
                tuckBtn.setText("UNTUCK");
                tuckBtn.setTextColor(Color.parseColor("#FFCC00"));
            } else {
                injectJs("UI.tuckedAll=false;UI.leftTucked=false;UI.rightTucked=false;document.getElementById('hud-left').style.transform='translateX(0)';document.getElementById('hud-right').style.transform='translateX(0)'");
                tuckBtn.setText("TUCK");
                tuckBtn.setTextColor(Color.parseColor("#10b981"));
            }
        });
        row.addView(tuckBtn);

        cleanBtn = mkBtn("CLEAN", "#FF6600", v -> {
            cleanViewMode = !cleanViewMode;
            cleanBtn.setText(cleanViewMode ? "CLEAN ON" : "CLEAN");
            cleanBtn.setTextColor(Color.parseColor(cleanViewMode ? "#FF4466" : "#FF6600"));
            headerOverlay.setVisibility(cleanViewMode ? View.GONE : View.VISIBLE);
        });
        row.addView(cleanBtn);

        bar.addView(row);
        return bar;
    }

    private Button mkBtn(String t, String color, View.OnClickListener l) {
        Button b = new Button(this);
        b.setText(t);
        b.setTextSize(10f);
        b.setTextColor(Color.parseColor(color));
        b.setBackgroundColor(Color.parseColor("#1A1A2E"));
        b.setPadding(dp(8), dp(8), dp(8), dp(8));
        b.setLayoutParams(new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f));
        b.setOnClickListener(l);
        return b;
    }

    private void injectJs(String s) { webView.evaluateJavascript(s, null); }
    private int dp(int px) { return (int)(px * getResources().getDisplayMetrics().density); }
    @Override public void onBackPressed() { super.onBackPressed(); }

    public class JsBridge {
        @JavascriptInterface
        public void onReady(String j) {
            runOnUiThread(() -> Toast.makeText(MainActivity.this,
                "CarForge v1.0 \u2014 3D Alphabet Engine", Toast.LENGTH_SHORT).show());
        }
    }
}
