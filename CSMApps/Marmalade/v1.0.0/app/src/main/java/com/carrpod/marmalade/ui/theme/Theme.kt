package com.carrpod.marmalade.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val MarmaladeOrange = Color(0xFFFF6600)
val MarmaladeOrangeDark = Color(0xFFCC5200)
val MarmaladeNight = Color(0xFF0A0A0F)
val MarmaladeSurface = Color(0xFF1A1A2E)
val MarmaladeSurfaceLight = Color(0xFF252540)
val MarmaladeText = Color(0xFFE8E8F0)
val MarmaladeTextDim = Color(0xFF8888A0)
val MarmaladeGreen = Color(0xFF00FF88)
val MarmaladeRed = Color(0xFFFF4466)

private val DarkColorScheme = darkColorScheme(
    primary = MarmaladeOrange,
    onPrimary = Color.White,
    secondary = MarmaladeOrangeDark,
    background = MarmaladeNight,
    surface = MarmaladeSurface,
    surfaceVariant = MarmaladeSurfaceLight,
    onBackground = MarmaladeText,
    onSurface = MarmaladeText,
    onSurfaceVariant = MarmaladeTextDim,
    error = MarmaladeRed,
    primaryContainer = MarmaladeOrangeDark,
)

@Composable
fun MarmaladeTheme(
    darkTheme: Boolean = true,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = DarkColorScheme,
        typography = MarmaladeTypography,
        content = content
    )
}
