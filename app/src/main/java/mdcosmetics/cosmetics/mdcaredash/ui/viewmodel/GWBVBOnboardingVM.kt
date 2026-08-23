package mdcosmetics.cosmetics.mdcaredash.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import mdcosmetics.cosmetics.mdcaredash.data.repository.GWBVBOnboardingRepo

class GWBVBOnboardingVM(
    private val onboardingRepository: GWBVBOnboardingRepo,
) : ViewModel() {
  private val _onboardingSetState = MutableStateFlow(false)
  val onboardingSetState: StateFlow<Boolean>
    get() = _onboardingSetState.asStateFlow()

  fun setOnboarded() {
    viewModelScope.launch {
      onboardingRepository.setOnboardingState(true)
      _onboardingSetState.update { true }
    }
  }
}
