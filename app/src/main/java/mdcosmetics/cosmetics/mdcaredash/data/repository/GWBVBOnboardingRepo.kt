package mdcosmetics.cosmetics.mdcaredash.data.repository

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import mdcosmetics.cosmetics.mdcaredash.data.datastore.GWBVBOnboardingPrefs

class GWBVBOnboardingRepo(
    private val gwbvbOnboardingStoreManager: GWBVBOnboardingPrefs,
    private val coroutineDispatcher: CoroutineDispatcher,
) {

  fun observeOnboardingState(): Flow<Boolean?> {
    return gwbvbOnboardingStoreManager.onboardedStateFlow
  }

  suspend fun setOnboardingState(state: Boolean) {
    withContext(coroutineDispatcher) { gwbvbOnboardingStoreManager.setOnboardedState(state) }
  }
}
