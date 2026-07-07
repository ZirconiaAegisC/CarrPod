package com.carrpod.marmalade

import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import android.widget.LinearLayout
import android.view.Gravity
import android.graphics.Color
import android.graphics.Typeface

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            setBackgroundColor(Color.parseColor("#0A0A0F"))
        }

        val logo = TextView(this).apply {
            text = "CARRPOD"
            textSize = 48f
            setTextColor(Color.parseColor("#FF6600"))
            typeface = Typeface.DEFAULT_BOLD
            gravity = Gravity.CENTER
            setPadding(0, 0, 0, 16)
        }

        val subtitle = TextView(this).apply {
            text = "Safe Pod Engineering Company"
            textSize = 12f
            setTextColor(Color.parseColor("#8888A0"))
            gravity = Gravity.CENTER
            setPadding(0, 0, 0, 64)
        }

        val appName = TextView(this).apply {
            text = "Marmalade"
            textSize = 32f
            setTextColor(Color.parseColor("#E8E8F0"))
            typeface = Typeface.DEFAULT_BOLD
            gravity = Gravity.CENTER
            setPadding(0, 0, 0, 8)
        }

        val version = TextView(this).apply {
            text = "Stage 1 — v1.0.0"
            textSize = 12f
            setTextColor(Color.parseColor("#FF6600"))
            gravity = Gravity.CENTER
        }

        layout.addView(logo)
        layout.addView(subtitle)
        layout.addView(appName)
        layout.addView(version)
        setContentView(layout)
    }
}
