package mdcosmetics.cosmetics.mdcaredash.data.datastore

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private const val GWBVB_PREFS_NAME = "gwbvb_prefs"

val Context.gwbvbOnboardingStore by preferencesDataStore(name = GWBVB_PREFS_NAME)

class GWBVBOnboardingPrefs(
    private val context: Context
) {
    val onboardedStateFlow: Flow<Boolean?> = context.gwbvbOnboardingStore.data.map { prefs ->
        prefs[ONBOARDED_STATE_KEY]
    }

    suspend fun setOnboardedState(state: Boolean) {
        context.gwbvbOnboardingStore.edit { prefs ->
            prefs[ONBOARDED_STATE_KEY] = state
        }
    }

    companion object {
        private val ONBOARDED_STATE_KEY = booleanPreferencesKey("onboardedState")
    }
}