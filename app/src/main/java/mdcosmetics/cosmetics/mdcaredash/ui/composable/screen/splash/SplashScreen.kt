package mdcosmetics.cosmetics.mdcaredash.ui.composable.screen.splash

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Spa
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.coroutines.delay
import mdcosmetics.cosmetics.mdcaredash.ui.theme.Rose
import mdcosmetics.cosmetics.mdcaredash.ui.theme.Teal
import mdcosmetics.cosmetics.mdcaredash.ui.viewmodel.GWBVBSplashVM
import org.koin.androidx.compose.koinViewModel

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    viewModel: GWBVBSplashVM = koinViewModel(),
    onNavigateToHomeScreen: () -> Unit,
    onNavigateToOnboarding: () -> Unit
) {
  val onboarded by viewModel.onboardedState.collectAsStateWithLifecycle()
  var visible by remember { mutableStateOf(false) }
  val scale by animateFloatAsState(if (visible) 1f else .8f, tween(800), label = "logo")
  LaunchedEffect(Unit) {
    visible = true
    delay(1500)
    if (onboarded) onNavigateToHomeScreen() else onNavigateToOnboarding()
  }
  Box(
      modifier = modifier.fillMaxSize().background(Brush.linearGradient(listOf(Rose, Teal))),
      contentAlignment = Alignment.Center) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(18.dp)) {
              Box(
                  modifier =
                      Modifier.size(112.dp)
                          .scale(scale)
                          .background(Color.White, MaterialTheme.shapes.extraLarge),
                  contentAlignment = Alignment.Center) {
                    Icon(Icons.Rounded.Spa, null, tint = Rose, modifier = Modifier.size(64.dp))
                  }
              Text(
                  "MDCare Dash",
                  color = Color.White,
                  style = MaterialTheme.typography.headlineLarge,
                  fontWeight = FontWeight.SemiBold)
              Text(
                  "BEAUTY, CURATED",
                  color = Color.White.copy(alpha = .82f),
                  style = MaterialTheme.typography.labelLarge)
            }
      }
}
