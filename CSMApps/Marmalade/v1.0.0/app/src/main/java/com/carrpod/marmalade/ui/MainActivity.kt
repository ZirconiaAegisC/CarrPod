package com.carrpod.marmalade.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.carrpod.marmalade.hub.MessageHubService
import com.carrpod.marmalade.ui.screens.MarmaladeApp
import com.carrpod.marmalade.ui.theme.MarmaladeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        MessageHubService.start(this)
        setContent {
            MarmaladeTheme {
                MarmaladeApp()
            }
        }
    }
}
