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
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.carrpod.marmalade.ui.MessagesActivity;

public class MainActivity extends Activity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

        FrameLayout header = new FrameLayout(this);
        FrameLayout.LayoutParams hdParams = new FrameLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        );
        hdParams.gravity = Gravity.TOP | Gravity.CENTER_HORIZONTAL;
        hdParams.topMargin = dp(24);
        header.setLayoutParams(hdParams);
        header.setBackgroundColor(Color.parseColor("#CC0A0A0F"));

        LinearLayout inner = new LinearLayout(this);
        inner.setOrientation(LinearLayout.VERTICAL);
        inner.setGravity(Gravity.CENTER);
        inner.setPadding(dp(16), dp(12), dp(16), dp(12));

        TextView logo = new TextView(this);
        logo.setText("CARRPOD");
        logo.setTextSize(28f);
        logo.setTextColor(Color.parseColor("#FF6600"));
        logo.setTypeface(Typeface.DEFAULT_BOLD);
        logo.setGravity(Gravity.CENTER);

        TextView tagline = new TextView(this);
        tagline.setText("Marmalade Stage 3  \u2022  Tardigradia 2.0");
        tagline.setTextSize(12f);
        tagline.setTextColor(Color.parseColor("#E8E8F0"));
        tagline.setGravity(Gravity.CENTER);
        tagline.setPadding(0, dp(4), 0, 0);

        inner.addView(logo);
        inner.addView(tagline);
        header.addView(inner);

        LinearLayout buttonBar = new LinearLayout(this);
        buttonBar.setOrientation(LinearLayout.HORIZONTAL);
        buttonBar.setPadding(dp(16), 0, dp(16), dp(24));
        FrameLayout.LayoutParams barParams = new FrameLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        );
        barParams.gravity = Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL;
        buttonBar.setLayoutParams(barParams);

        Button msgButton = new Button(this);
        msgButton.setText("Messages");
        msgButton.setTextSize(13f);
        msgButton.setTextColor(Color.parseColor("#FF6600"));
        msgButton.setBackgroundColor(Color.parseColor("#1A1A2E"));
        msgButton.setPadding(dp(16), dp(8), dp(16), dp(8));
        msgButton.setLayoutParams(new LinearLayout.LayoutParams(
            0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f
        ));
        msgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MessagesActivity.class);
                startActivity(intent);
            }
        });

        Button btButton = new Button(this);
        btButton.setText("Bluetooth");
        btButton.setTextSize(13f);
        btButton.setTextColor(Color.parseColor("#8888A0"));
        btButton.setBackgroundColor(Color.parseColor("#1A1A2E"));
        btButton.setPadding(dp(16), dp(8), dp(16), dp(8));
        btButton.setLayoutParams(new LinearLayout.LayoutParams(
            0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f
        ));
        btButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BtDiagnosticActivity.class);
                startActivity(intent);
            }
        });

        buttonBar.addView(msgButton);
        buttonBar.addView(btButton);

        root.addView(webView);
        root.addView(header);
        root.addView(buttonBar);

        return root;
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
