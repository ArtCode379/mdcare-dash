package mdcosmetics.cosmetics.mdcaredash.ui.composable.screen.home

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import mdcosmetics.cosmetics.mdcaredash.data.model.*
import mdcosmetics.cosmetics.mdcaredash.ui.state.DataUiState
import mdcosmetics.cosmetics.mdcaredash.ui.viewmodel.ProductViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: ProductViewModel = koinViewModel(),
    onNavigateToProductDetails: (productId: Int) -> Unit
) {
  val state by viewModel.productsState.collectAsStateWithLifecycle()
  var selected by remember { mutableStateOf<ProductCategory?>(null) }
  val products = (state as? DataUiState.Populated)?.data.orEmpty()
  val shown = if (selected == null) products else products.filter { it.category == selected }
  LazyColumn(modifier.fillMaxSize().background(MaterialTheme.colorScheme.background)) {
    item {
      Row(Modifier.fillMaxWidth().padding(20.dp), verticalAlignment = Alignment.CenterVertically) {
        Column(Modifier.weight(1f)) {
          Text("MDCare Dash", style = MaterialTheme.typography.headlineMedium)
          Text("Your daily beauty edit", color = MaterialTheme.colorScheme.onSurfaceVariant)
        }
        IconButton(onClick = { selected = null }) {
          Icon(Icons.Rounded.Search, "Show all products")
        }
      }
    }
    products.firstOrNull()?.let { featured ->
      item {
        Box(
            Modifier.padding(horizontal = 16.dp)
                .fillMaxWidth()
                .height(230.dp)
                .clip(RoundedCornerShape(28.dp))
                .clickable { onNavigateToProductDetails(featured.id) }) {
              AsyncImage(
                  featured.imageUrl,
                  featured.title,
                  Modifier.fillMaxSize(),
                  contentScale = ContentScale.Crop)
              Box(
                  Modifier.fillMaxSize()
                      .background(
                          androidx.compose.ui.graphics.Brush.verticalGradient(
                              listOf(
                                  androidx.compose.ui.graphics.Color.Transparent,
                                  androidx.compose.ui.graphics.Color.Black.copy(.68f)))))
              Column(Modifier.align(Alignment.BottomStart).padding(20.dp)) {
                Text(
                    "THE RADIANCE EDIT",
                    color = androidx.compose.ui.graphics.Color.White,
                    style = MaterialTheme.typography.labelLarge)
                Text(
                    featured.title,
                    color = androidx.compose.ui.graphics.Color.White,
                    style = MaterialTheme.typography.headlineMedium)
                Text(
                    "£%.2f".format(featured.price),
                    color = androidx.compose.ui.graphics.Color.White,
                    fontWeight = FontWeight.Bold)
              }
            }
      }
    }
    item {
      LazyRow(
          contentPadding = PaddingValues(16.dp),
          horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            item { FilterChip(selected == null, { selected = null }, { Text("All") }) }
            items(ProductCategory.entries) { category ->
              FilterChip(
                  selected == category,
                  { selected = category },
                  { Text(stringResource(category.titleRes)) })
            }
          }
    }
    item {
      Text(
          "Curated essentials",
          Modifier.padding(horizontal = 20.dp, vertical = 8.dp),
          style = MaterialTheme.typography.titleLarge)
    }
    items(shown.chunked(2)) { row ->
      Row(
          Modifier.fillMaxWidth().padding(horizontal = 12.dp),
          horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            row.forEachIndexed { index, product ->
              ProductCard(product, index % 2 == 1, Modifier.weight(1f), onNavigateToProductDetails)
            }
            if (row.size == 1) Spacer(Modifier.weight(1f))
          }
    }
    item { Spacer(Modifier.height(24.dp)) }
  }
}

@Composable
private fun ProductCard(
    product: Product,
    tall: Boolean,
    modifier: Modifier,
    onClick: (Int) -> Unit
) {
  Column(modifier.padding(vertical = 8.dp).clickable { onClick(product.id) }) {
    AsyncImage(
        product.imageUrl,
        product.title,
        Modifier.fillMaxWidth()
            .height(if (tall) 220.dp else 170.dp)
            .clip(RoundedCornerShape(20.dp)),
        contentScale = ContentScale.Crop)
    Text(
        product.title,
        Modifier.padding(top = 10.dp),
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        style = MaterialTheme.typography.titleMedium)
    Text(
        "£%.2f".format(product.price),
        color = MaterialTheme.colorScheme.primary,
        fontWeight = FontWeight.Bold)
  }
}
