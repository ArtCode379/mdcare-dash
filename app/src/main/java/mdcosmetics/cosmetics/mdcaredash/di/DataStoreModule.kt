package mdcosmetics.cosmetics.mdcaredash.di

import mdcosmetics.cosmetics.mdcaredash.data.datastore.GWBVBOnboardingPrefs
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataStoreModule = module {
    single { GWBVBOnboardingPrefs(androidContext()) }
}