package mdcosmetics.cosmetics.mdcaredash.ui.composable.screen.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import mdcosmetics.cosmetics.mdcaredash.ui.viewmodel.GWBVBOnboardingVM
import org.koin.androidx.compose.koinViewModel

private data class Page(val title: String, val description: String, val image: String)

private val pages =
    listOf(
        Page(
            "Care that feels personal",
            "Explore considered skincare and beauty essentials for simple, rewarding daily rituals.",
            "https://images.unsplash.com/photo-1612817288484-6f916006741a?w=1200"),
        Page(
            "Curated for every routine",
            "Filter by skincare, body, hair, makeup and wellness to find your next favourite.",
            "https://images.unsplash.com/photo-1598440947619-2c35fc9aa908?w=1200"),
        Page(
            "Reserve, then collect",
            "Build your basket, reserve in seconds and collect from our store within 24 hours.",
            "https://images.unsplash.com/photo-1571781926291-c477ebfd024b?w=1200"))

@Composable
fun OnboardingScreen(
    modifier: Modifier = Modifier,
    viewModel: GWBVBOnboardingVM = koinViewModel(),
    onNavigateToHomeScreen: () -> Unit
) {
  val saved by viewModel.onboardingSetState.collectAsStateWithLifecycle()
  val pager = rememberPagerState { pages.size }
  LaunchedEffect(saved) { if (saved) onNavigateToHomeScreen() }
  Column(modifier.fillMaxSize().background(MaterialTheme.colorScheme.background)) {
    HorizontalPager(state = pager, modifier = Modifier.weight(1f)) { index ->
      val page = pages[index]
      Column {
        AsyncImage(
            model = page.image,
            contentDescription = null,
            modifier = Modifier.fillMaxWidth().weight(.65f),
            contentScale = ContentScale.Crop)
        Column(
            modifier = Modifier.fillMaxWidth().weight(.35f).padding(24.dp),
            verticalArrangement = Arrangement.Center) {
              Text(page.title, style = MaterialTheme.typography.headlineMedium)
              Spacer(Modifier.height(12.dp))
              Text(page.description, color = MaterialTheme.colorScheme.onSurfaceVariant)
            }
      }
    }
    Row(
        Modifier.fillMaxWidth().padding(horizontal = 24.dp, vertical = 20.dp),
        verticalAlignment = Alignment.CenterVertically) {
          Row(Modifier.weight(1f), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            pages.indices.forEach {
              Box(
                  Modifier.size(if (it == pager.currentPage) 10.dp else 7.dp)
                      .clip(CircleShape)
                      .background(
                          if (it == pager.currentPage) MaterialTheme.colorScheme.primary
                          else MaterialTheme.colorScheme.outline))
            }
          }
          Button(
              onClick = { if (pager.currentPage == pages.lastIndex) viewModel.setOnboarded() },
              enabled = pager.currentPage == pages.lastIndex) {
                Text(
                    if (pager.currentPage == pages.lastIndex) "Get Started"
                    else "Swipe to continue")
              }
        }
  }
}
