package mdcosmetics.cosmetics.mdcaredash.ui.composable.screen.cart

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import mdcosmetics.cosmetics.mdcaredash.ui.state.*
import mdcosmetics.cosmetics.mdcaredash.ui.viewmodel.CartViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun CartScreen(
    modifier: Modifier = Modifier,
    viewModel: CartViewModel = koinViewModel(),
    onNavigateToCheckoutScreen: () -> Unit
) {
  val state by viewModel.cartItemsState.collectAsStateWithLifecycle()
  val total by viewModel.totalPrice.collectAsStateWithLifecycle()
  val items = (state as? DataUiState.Populated)?.data.orEmpty()
  if (items.isEmpty()) {
    Column(
        modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
          Icon(
              Icons.Rounded.ShoppingBag,
              null,
              Modifier.size(72.dp),
              tint = MaterialTheme.colorScheme.primary)
          Text("Your beauty bag is empty", style = MaterialTheme.typography.titleLarge)
          Text("Start Shopping", color = MaterialTheme.colorScheme.primary)
        }
    return
  }
  Column(modifier.fillMaxSize()) {
    LazyColumn(
        Modifier.weight(1f),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)) {
          items(items, key = { it.productId }) { item ->
            ElevatedCard {
              Row(Modifier.padding(12.dp), verticalAlignment = Alignment.CenterVertically) {
                AsyncImage(
                    item.productImageUrl,
                    item.productTitle,
                    Modifier.size(76.dp),
                    contentScale = ContentScale.Crop)
                Column(Modifier.weight(1f).padding(horizontal = 12.dp)) {
                  Text(item.productTitle, style = MaterialTheme.typography.titleMedium)
                  Text("£%.2f".format(item.productPrice), color = MaterialTheme.colorScheme.primary)
                  Row(verticalAlignment = Alignment.CenterVertically) {
                    IconButton(
                        onClick = {
                          if (item.quantity == 1) viewModel.deleteFromCart(item.productId)
                          else viewModel.decrementItemInCart(item.productId)
                        }) {
                          Icon(Icons.Rounded.Remove, "Decrease quantity")
                        }
                    Text(item.quantity.toString(), fontWeight = FontWeight.Bold)
                    IconButton(onClick = { viewModel.incrementProductInCart(item.productId) }) {
                      Icon(Icons.Rounded.Add, "Increase quantity")
                    }
                  }
                }
                IconButton(onClick = { viewModel.deleteFromCart(item.productId) }) {
                  Icon(Icons.Rounded.DeleteOutline, "Remove item")
                }
              }
            }
          }
        }
    Surface(shadowElevation = 8.dp) {
      Column(Modifier.padding(20.dp)) {
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
          Text("Total", style = MaterialTheme.typography.titleLarge)
          Text(
              "£%.2f".format(total),
              style = MaterialTheme.typography.titleLarge,
              color = MaterialTheme.colorScheme.primary)
        }
        Button(
            onClick = onNavigateToCheckoutScreen,
            Modifier.fillMaxWidth().padding(top = 14.dp).height(52.dp)) {
              Text("Proceed to Checkout")
            }
      }
    }
  }
}
