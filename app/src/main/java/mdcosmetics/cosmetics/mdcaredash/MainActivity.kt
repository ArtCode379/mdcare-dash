package mdcosmetics.cosmetics.mdcaredash

// [FIREBASE|APPSFLYER][import_Intent]
// [FIREBASE][import_URI]
// [FIREBASE][imports_workmanager_settings]
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import mdcosmetics.cosmetics.mdcaredash.ui.composable.approot.AppRoot
import mdcosmetics.cosmetics.mdcaredash.ui.theme.ProductAppGWBVBTheme

// [FIREBASE][import_VisitRequestWorker]

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent { ProductAppGWBVBTheme { AppRoot() } }

    // [FIREBASE][onCreate_handleNotificationIntent]
  }

  // [FIREBASE|APPSFLYER][onNewIntent]

  // [FIREBASE][handleNotificationIntent]

  // [FIREBASE][scheduleClickTracking]

  // [FIREBASE][openExternalBrowser]
}
