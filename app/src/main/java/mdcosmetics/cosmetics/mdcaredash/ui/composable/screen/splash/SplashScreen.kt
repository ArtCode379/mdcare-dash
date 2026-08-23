package mdcosmetics.cosmetics.mdcaredash.ui.composable.screen.splash

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import mdcosmetics.cosmetics.mdcaredash.ui.viewmodel.GWBVBSplashVM
import org.koin.androidx.compose.koinViewModel

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    viewModel: GWBVBSplashVM = koinViewModel(),
    onNavigateToHomeScreen: () -> Unit,
    onNavigateToOnboarding: () -> Unit,
) {
    val onboardedState by viewModel.onboardedState.collectAsStateWithLifecycle()

    LaunchedEffect(onboardedState) {
        if (onboardedState) {
            onNavigateToHomeScreen()
        } else {
            onNavigateToOnboarding()
        }
    }
}