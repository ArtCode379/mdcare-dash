package mdcosmetics.cosmetics.mdcaredash.ui.composable.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import mdcosmetics.cosmetics.mdcaredash.R
import mdcosmetics.cosmetics.mdcaredash.data.model.Product
import mdcosmetics.cosmetics.mdcaredash.ui.composable.shared.GWBVBContentWrapper
import mdcosmetics.cosmetics.mdcaredash.ui.composable.shared.GWBVBEmptyView
import mdcosmetics.cosmetics.mdcaredash.ui.state.DataUiState
import mdcosmetics.cosmetics.mdcaredash.ui.viewmodel.ProductViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: ProductViewModel = koinViewModel(),
    onNavigateToProductDetails: (productId: Int) -> Unit,
) {
    val productsState by viewModel.productsState.collectAsState()

    HomeContent(
        productsState = productsState,
        modifier = modifier,
        onNavigateToProductDetails = onNavigateToProductDetails,
        onAddProductToCart = viewModel::addToCart,
    )
}

@Composable
private fun HomeContent(
    productsState: DataUiState<List<Product>>,
    modifier: Modifier = Modifier,
    onNavigateToProductDetails: (productId: Int) -> Unit,
    onAddProductToCart: (productId: Int) -> Unit,
) {
    Column(modifier = modifier) {

        GWBVBContentWrapper(
            dataState = productsState,

            dataPopulated = {
                val data = (productsState as DataUiState.Populated).data
            },

            dataEmpty = {
                GWBVBEmptyView(
                    primaryText = stringResource(R.string.gwbvb_products_state_empty_primary_text),
                    modifier = Modifier.fillMaxSize(),
                )
            },
        )
    }
}