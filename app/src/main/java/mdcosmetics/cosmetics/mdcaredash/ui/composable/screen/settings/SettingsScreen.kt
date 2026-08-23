package mdcosmetics.cosmetics.mdcaredash.ui.composable.screen.settings

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun SettingsScreen(modifier: Modifier = Modifier) {
  val context = LocalContext.current
  Column(modifier.fillMaxSize().padding(20.dp), verticalArrangement = Arrangement.spacedBy(18.dp)) {
    Text("About", style = MaterialTheme.typography.headlineMedium)
    SettingsRow(Icons.Rounded.Storefront, "Company", "MD COSMETICS LTD")
    SettingsRow(Icons.Rounded.Info, "App version", "1.0")
    HorizontalDivider()
    Text("Support", style = MaterialTheme.typography.titleLarge)
    Button(
        onClick = {
          context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://mdcosmetics.casa")))
        },
        modifier = Modifier.fillMaxWidth()) {
          Icon(Icons.Rounded.SupportAgent, null)
          Spacer(Modifier.width(8.dp))
          Text("Customer Support")
        }
    Text(
        "Visit our website for product information, collection help and customer care.",
        color = MaterialTheme.colorScheme.onSurfaceVariant)
  }
}

@Composable
private fun SettingsRow(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    title: String,
    value: String
) {
  Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(14.dp)) {
    Icon(icon, null, tint = MaterialTheme.colorScheme.primary)
    Column {
      Text(title, style = MaterialTheme.typography.labelLarge)
      Text(value, color = MaterialTheme.colorScheme.onSurfaceVariant)
    }
  }
}
