package mdcosmetics.cosmetics.mdcaredash.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val MDCareColors =
    lightColorScheme(
        primary = Rose,
        onPrimary = Porcelain,
        primaryContainer = Blush,
        onPrimaryContainer = RoseDark,
        secondary = Teal,
        onSecondary = Porcelain,
        background = Ivory,
        onBackground = Ink,
        surface = Porcelain,
        onSurface = Ink,
        surfaceVariant = Blush,
        onSurfaceVariant = Muted,
        outline = Border,
        tertiary = Warning)

@Composable
fun ProductAppGWBVBTheme(
    darkTheme: Boolean = false,
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
  MaterialTheme(colorScheme = MDCareColors, typography = AppTypography, content = content)
}
