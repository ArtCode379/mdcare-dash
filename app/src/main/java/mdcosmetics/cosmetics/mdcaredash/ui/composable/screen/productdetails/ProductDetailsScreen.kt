package mdcosmetics.cosmetics.mdcaredash.ui.composable.screen.productdetails

import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import kotlinx.coroutines.delay
import mdcosmetics.cosmetics.mdcaredash.data.model.Product
import mdcosmetics.cosmetics.mdcaredash.ui.state.DataUiState
import mdcosmetics.cosmetics.mdcaredash.ui.viewmodel.ProductDetailsViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ProductDetailsScreen(
    productId: Int,
    modifier: Modifier = Modifier,
    viewModel: ProductDetailsViewModel = koinViewModel()
) {
  val state by viewModel.productDetailsState.collectAsState()
  var cartAdded by remember { mutableStateOf(false) }
  LaunchedEffect(productId) { viewModel.observeProductDetails(productId) }
  LaunchedEffect(cartAdded) {
    if (cartAdded) {
      delay(2000)
      cartAdded = false
    }
  }
  Box(modifier.fillMaxSize()) {
    (state as? DataUiState.Populated)?.data?.let { product ->
      ProductDetail(product) {
        viewModel.addProductToCart()
        cartAdded = true
      }
    }
    AnimatedVisibility(
        cartAdded,
        modifier = Modifier.align(Alignment.BottomCenter),
        enter = slideInVertically { it },
        exit = fadeOut()) {
          Row(
              Modifier.fillMaxWidth().height(56.dp).padding(horizontal = 16.dp),
              verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Rounded.CheckCircle, null, tint = MaterialTheme.colorScheme.primary)
                Spacer(Modifier.width(10.dp))
                Text("Added to cart", fontWeight = FontWeight.Medium)
              }
        }
  }
}

@Composable
private fun ProductDetail(product: Product, onAdd: () -> Unit) {
  Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState())) {
    AsyncImage(
        product.imageUrl,
        product.title,
        Modifier.fillMaxWidth().height(360.dp),
        contentScale = ContentScale.Crop)
    Column(Modifier.padding(22.dp)) {
      AssistChip(
          onClick = onAdd,
          label = { Text(product.category.name.lowercase().replaceFirstChar { it.uppercase() }) })
      Text(product.title, style = MaterialTheme.typography.headlineMedium)
      Text(
          "£%.2f".format(product.price),
          color = MaterialTheme.colorScheme.primary,
          style = MaterialTheme.typography.titleLarge)
      Spacer(Modifier.height(18.dp))
      Text(
          product.description,
          color = MaterialTheme.colorScheme.onSurfaceVariant,
          style = MaterialTheme.typography.bodyLarge)
      Spacer(Modifier.height(28.dp))
      Button(
          onClick = onAdd,
          modifier = Modifier.fillMaxWidth().height(54.dp),
          shape = RoundedCornerShape(18.dp)) {
            Text("Add to Cart")
          }
      Spacer(Modifier.height(70.dp))
    }
  }
}
