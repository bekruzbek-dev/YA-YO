package uz.yalife.app.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColors = lightColorScheme(
    primary = Color(0xFF2E7D4F),
    onPrimary = Color.White,
    primaryContainer = Color(0xFFCFE9D6),
    background = Color(0xFFFBF6E9),
    surface = Color(0xFFFFFBF0),
    surfaceVariant = Color(0xFFF1EBD8),
    onBackground = Color(0xFF1C1B16),
    onSurface = Color(0xFF1C1B16)
)

private val DarkColors = darkColorScheme(
    primary = Color(0xFF8FD3A4),
    onPrimary = Color(0xFF00391C),
    primaryContainer = Color(0xFF1B5E3A),
    background = Color(0xFF14160F),
    surface = Color(0xFF1B1D15),
    surfaceVariant = Color(0xFF2A2C22),
    onBackground = Color(0xFFE6E2D3),
    onSurface = Color(0xFFE6E2D3)
)

@Composable
fun YaYoTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColors else LightColors,
        content = content
    )
}
