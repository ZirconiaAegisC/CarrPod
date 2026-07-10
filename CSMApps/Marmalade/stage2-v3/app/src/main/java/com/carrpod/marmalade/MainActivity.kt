package com.carrpod.marmalade

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import android.graphics.Typeface
import android.os.Build

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val root = FrameLayout(this).apply {
            setBackgroundColor(Color.parseColor("#0A0A0F"))
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
        }

        val webView = WebView(this).apply {
            layoutParams = FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            settings.apply {
                javaScriptEnabled = true
                domStorageEnabled = true
                allowFileAccess = true
                mediaPlaybackRequiresUserGesture = false
                mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    allowFileAccessFromFileURLs = true
                    allowUniversalAccessFromFileURLs = true
                }
                setSupportZoom(false)
                builtInZoomControls = false
                cacheMode = WebSettings.LOAD_DEFAULT
            }
            webChromeClient = WebChromeClient()
            webViewClient = WebViewClient()
            loadUrl("https://fun.carrpod.net")
        }

        val header = FrameLayout(this).apply {
            layoutParams = FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            ).apply {
                gravity = Gravity.TOP or Gravity.CENTER_HORIZONTAL
                topMargin = dpToPx(24)
            }
            setBackgroundColor(Color.parseColor("#CC0A0A0F"))
            val inner = LinearLayout(context).apply {
                orientation = LinearLayout.VERTICAL
                gravity = Gravity.CENTER
                setPadding(dpToPx(16), dpToPx(12), dpToPx(16), dpToPx(12))
            }
            val logo = TextView(context).apply {
                text = "CARRPOD"
                textSize = 28f
                setTextColor(Color.parseColor("#FF6600"))
                typeface = Typeface.DEFAULT_BOLD
                gravity = Gravity.CENTER
            }
            val tagline = TextView(context).apply {
                text = "Marmalade v3.0 — Gemini"
                textSize = 14f
                setTextColor(Color.parseColor("#E8E8F0"))
                gravity = Gravity.CENTER
                setPadding(0, dpToPx(4), 0, 0)
            }
            inner.addView(logo)
            inner.addView(tagline)
            addView(inner)
        }

        root.addView(webView)
        root.addView(header)
        setContentView(root)
    }

    override fun onBackPressed() {
        val root = findViewById<FrameLayout>(android.R.id.content)
        val webView = (root.getChildAt(0) as? FrameLayout)?.let { frame ->
            (0 until frame.childCount).mapNotNull { frame.getChildAt(it) as? WebView }.firstOrNull()
        }
        if (webView?.canGoBack() == true) webView.goBack() else super.onBackPressed()
    }

    private fun dpToPx(dp: Int): Int = (dp * resources.displayMetrics.density).toInt()
}
