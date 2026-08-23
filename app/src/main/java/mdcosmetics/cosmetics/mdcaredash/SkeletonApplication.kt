package mdcosmetics.cosmetics.mdcaredash

// [ANY][import_PrepRepository]
// [COMMON][import_DiModule]
// [REFERRER][import_InstallReferrerManager]
// [APPSFLYER][imports_AppsFlyer]
// [FIREBASE][import_FirebaseMessaging]
// [FIREBASE][imports_coroutines]
// [ANY][import_getKoin]
import android.app.Application
import mdcosmetics.cosmetics.mdcaredash.di.dataModule
import mdcosmetics.cosmetics.mdcaredash.di.dispatcherModule
import mdcosmetics.cosmetics.mdcaredash.di.viewModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class GWBVBApplication : Application() {
    // [FIREBASE][appScope]

    override fun onCreate() {
        super.onCreate()

        val appModules = dataModule + viewModule + dispatcherModule /*[COMMON][diModule]*/

        startKoin {
            androidLogger()
            androidContext(this@GWBVBApplication)
            modules(appModules)
        }

        // [ANY][repository]

        // [APPSFLYER][devKey]

        // [APPSFLYER][appsFlyerSettings]

        // [REFERRER][referrerManagerSettings]

        // [APPSFLYER][appsFlyerId]

        // [FIREBASE][FirebaseMessaging]
    }
}
