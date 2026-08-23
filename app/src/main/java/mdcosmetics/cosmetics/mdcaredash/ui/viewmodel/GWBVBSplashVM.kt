package mdcosmetics.cosmetics.mdcaredash.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import mdcosmetics.cosmetics.mdcaredash.data.repository.GWBVBOnboardingRepo

class GWBVBSplashVM(
    private val onboardingRepository: GWBVBOnboardingRepo,
) : ViewModel() {
  val onboardedState: StateFlow<Boolean> =
      onboardingRepository
          .observeOnboardingState()
          .map { it == true }
          .stateIn(scope = viewModelScope, started = SharingStarted.Eagerly, initialValue = false)
}
