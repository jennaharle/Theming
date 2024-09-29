package com.example.theming.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext


private val DarkColorScheme = darkColorScheme(
    primary = CustomPrimaryColor,
    secondary = Color(0XFF03DAC5)
)

private val LightColorScheme = lightColorScheme(
    primary = CustomPrimaryColor,
    secondary = Color(0XFF03DAC5)

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun ThemingTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val context = LocalContext.current
    val color = if (darkTheme) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            dynamicDarkColorScheme(context)
        } else {
            DarkColorScheme
        }
    } else {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            dynamicLightColorScheme(context)
        } else {
            LightColorScheme
        }
    }
    MaterialTheme(
        colorScheme = color,
        typography = CustomTypography,
        //shapes = Shapes,
        content = content
    )
}

