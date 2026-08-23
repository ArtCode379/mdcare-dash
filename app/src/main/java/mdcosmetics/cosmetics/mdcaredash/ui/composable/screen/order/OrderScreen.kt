package mdcosmetics.cosmetics.mdcaredash.ui.composable.screen.order

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ReceiptLong
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import mdcosmetics.cosmetics.mdcaredash.data.entity.OrderEntity
import mdcosmetics.cosmetics.mdcaredash.ui.state.DataUiState
import mdcosmetics.cosmetics.mdcaredash.ui.theme.Success
import mdcosmetics.cosmetics.mdcaredash.ui.viewmodel.OrderViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun OrdersScreen(modifier: Modifier = Modifier, viewModel: OrderViewModel = koinViewModel()) {
  val state by viewModel.ordersState.collectAsStateWithLifecycle()
  val orders = (state as? DataUiState.Populated)?.data.orEmpty().sortedByDescending { it.timestamp }
  if (orders.isEmpty()) {
    Column(
        modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
          Icon(
              Icons.Rounded.ReceiptLong,
              null,
              Modifier.size(64.dp),
              tint = MaterialTheme.colorScheme.primary)
          Text("No orders yet", style = MaterialTheme.typography.titleLarge)
        }
  } else {
    LazyColumn(
        modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)) {
          items(orders, key = { it.orderNumber }) { OrderCard(it) }
        }
  }
}

@Composable
private fun OrderCard(order: OrderEntity) {
  ElevatedCard(Modifier.fillMaxWidth()) {
    Column(Modifier.padding(18.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
      Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        Text("Order #${order.orderNumber}", fontWeight = FontWeight.Bold)
        Text("Reserved", color = Success, fontWeight = FontWeight.Bold)
      }
      Text(
          order.timestamp.toLocalDate().toString(),
          color = MaterialTheme.colorScheme.onSurfaceVariant)
      Text(order.description, maxLines = 2)
      Text(
          "£%.2f".format(order.price),
          color = MaterialTheme.colorScheme.primary,
          fontWeight = FontWeight.Bold)
      Text("Ready for collection within 24 hours", style = MaterialTheme.typography.bodyMedium)
    }
  }
}
