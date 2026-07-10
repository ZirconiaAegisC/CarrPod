package com.carrpod.marmalade;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.carrpod.marmalade.ui.MessagesActivity;

public class MainActivity extends Activity {

    private WebView webView;
    private TextView headerBg;
    private TextView logoText;
    private TextView taglineText;
    private int headerAlpha = 210;

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

        FrameLayout root = buildLayout();
        setContentView(root);
    }

    private FrameLayout buildLayout() {
        FrameLayout root = new FrameLayout(this);
        root.setBackgroundColor(Color.parseColor("#0A0A0F"));
        root.setLayoutParams(new ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        ));

        webView = new WebView(this);
        FrameLayout.LayoutParams wvParams = new FrameLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        );
        webView.setLayoutParams(wvParams);

        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setAllowFileAccess(true);
        settings.setMediaPlaybackRequiresUserGesture(false);
        settings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        settings.setSupportZoom(false);
        settings.setBuiltInZoomControls(false);
        settings.setCacheMode(WebSettings.LOAD_DEFAULT);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            settings.setAllowFileAccessFromFileURLs(true);
            settings.setAllowUniversalAccessFromFileURLs(true);
        }
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://fun.carrpod.net");

        FrameLayout header = buildHeader();

        LinearLayout buttonBar = buildButtonBar();

        root.addView(webView);
        root.addView(header);
        root.addView(buttonBar);

        return root;
    }

    private FrameLayout buildHeader() {
        FrameLayout header = new FrameLayout(this);
        FrameLayout.LayoutParams hdParams = new FrameLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        );
        hdParams.gravity = Gravity.TOP | Gravity.CENTER_HORIZONTAL;
        hdParams.topMargin = dp(24);
        header.setLayoutParams(hdParams);

        LinearLayout container = new LinearLayout(this);
        container.setOrientation(LinearLayout.VERTICAL);
        container.setGravity(Gravity.CENTER);
        container.setPadding(dp(16), dp(12), dp(16), dp(12));
        container.setBackgroundColor(Color.argb(headerAlpha, 10, 10, 15));

        logoText = new TextView(this);
        logoText.setText("CARRPOD");
        logoText.setTextSize(28f);
        logoText.setTextColor(Color.parseColor("#FF6600"));
        logoText.setTypeface(Typeface.DEFAULT_BOLD);
        logoText.setGravity(Gravity.CENTER);

        taglineText = new TextView(this);
        taglineText.setText("Marmalade Stage 3b  \u2022  Tardigradia 2.0");
        taglineText.setTextSize(12f);
        taglineText.setTextColor(Color.parseColor("#E8E8F0"));
        taglineText.setGravity(Gravity.CENTER);
        taglineText.setPadding(0, dp(4), 0, dp(6));

        // ─── BRIGHTNESS CONTROLS ───────────────────────
        LinearLayout brightnessRow = new LinearLayout(this);
        brightnessRow.setOrientation(LinearLayout.HORIZONTAL);
        brightnessRow.setGravity(Gravity.CENTER);

        Button dimBtn = new Button(this);
        dimBtn.setText("\u2212");
        dimBtn.setTextSize(16f);
        dimBtn.setTextColor(Color.parseColor("#FF6600"));
        dimBtn.setBackgroundColor(Color.parseColor("#1A1A2E"));
        dimBtn.setPadding(dp(12), dp(2), dp(12), dp(2));
        dimBtn.setMinWidth(dp(40));
        dimBtn.setMinHeight(dp(30));
        dimBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                headerAlpha = Math.max(40, headerAlpha - 30);
                updateHeaderOpacity();
            }
        });

        TextView brightLabel = new TextView(this);
        brightLabel.setText(" Overlay ");
        brightLabel.setTextSize(10f);
        brightLabel.setTextColor(Color.parseColor("#8888A0"));
        brightLabel.setPadding(dp(6), 0, dp(6), 0);

        Button brightBtn = new Button(this);
        brightBtn.setText("+");
        brightBtn.setTextSize(16f);
        brightBtn.setTextColor(Color.parseColor("#FF6600"));
        brightBtn.setBackgroundColor(Color.parseColor("#1A1A2E"));
        brightBtn.setPadding(dp(12), dp(2), dp(12), dp(2));
        brightBtn.setMinWidth(dp(40));
        brightBtn.setMinHeight(dp(30));
        brightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                headerAlpha = Math.min(255, headerAlpha + 30);
                updateHeaderOpacity();
            }
        });

        brightnessRow.addView(dimBtn);
        brightnessRow.addView(brightLabel);
        brightnessRow.addView(brightBtn);

        container.addView(logoText);
        container.addView(taglineText);
        container.addView(brightnessRow);

        headerBg = new TextView(this);
        header.addView(container);

        return header;
    }

    private void updateHeaderOpacity() {
        logoText.setAlpha(headerAlpha / 255f);
        taglineText.setAlpha(headerAlpha / 255f);

        View container = (View) logoText.getParent();
        if (container instanceof LinearLayout) {
            ((LinearLayout) container).setBackgroundColor(Color.argb(headerAlpha, 10, 10, 15));
        }

        String level;
        if (headerAlpha >= 220) level = "FULL";
        else if (headerAlpha >= 140) level = "HIGH";
        else if (headerAlpha >= 70) level = "MED";
        else level = "LOW";
        Toast.makeText(this, "Overlay: " + level + " (" + headerAlpha + ")", Toast.LENGTH_SHORT).show();
    }

    private LinearLayout buildButtonBar() {
        LinearLayout buttonBar = new LinearLayout(this);
        buttonBar.setOrientation(LinearLayout.HORIZONTAL);
        buttonBar.setPadding(0, 0, 0, 0);
        buttonBar.setBackgroundColor(Color.parseColor("#E50A0A0F"));

        FrameLayout.LayoutParams barParams = new FrameLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        );
        barParams.gravity = Gravity.BOTTOM;
        buttonBar.setLayoutParams(barParams);

        Button msgButton = makeBarButton("Messages", "#FF6600");
        msgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MessagesActivity.class);
                startActivity(intent);
            }
        });

        Button btButton = makeBarButton("Bluetooth", "#8888A0");
        btButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BtDiagnosticActivity.class);
                startActivity(intent);
            }
        });

        buttonBar.addView(msgButton);
        buttonBar.addView(btButton);

        return buttonBar;
    }

    private Button makeBarButton(String label, String color) {
        Button btn = new Button(this);
        btn.setText(label);
        btn.setTextSize(13f);
        btn.setTextColor(Color.parseColor(color));
        btn.setBackgroundColor(Color.parseColor("#0A0A0F"));
        btn.setPadding(dp(20), dp(10), dp(20), dp(10));
        btn.setLayoutParams(new LinearLayout.LayoutParams(
            0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f
        ));
        return btn;
    }

    @Override
    public void onBackPressed() {
        if (webView != null && webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }

    private int dp(int px) {
        return (int)(px * getResources().getDisplayMetrics().density);
    }
}
