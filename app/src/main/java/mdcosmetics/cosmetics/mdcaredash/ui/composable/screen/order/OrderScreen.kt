package mdcosmetics.cosmetics.mdcaredash.ui.composable.screen.order

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import mdcosmetics.cosmetics.mdcaredash.R
import mdcosmetics.cosmetics.mdcaredash.data.entity.OrderEntity
import mdcosmetics.cosmetics.mdcaredash.ui.composable.shared.GWBVBContentWrapper
import mdcosmetics.cosmetics.mdcaredash.ui.composable.shared.GWBVBEmptyView
import mdcosmetics.cosmetics.mdcaredash.ui.state.DataUiState
import mdcosmetics.cosmetics.mdcaredash.ui.viewmodel.OrderViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun OrdersScreen(
    modifier: Modifier = Modifier,
    viewModel: OrderViewModel = koinViewModel(),
) {
    val ordersState by viewModel.ordersState.collectAsState()

    OrdersContent(
        ordersState = ordersState,
        modifier = modifier,
    )
}

@Composable
private fun OrdersContent(
    ordersState: DataUiState<List<OrderEntity>>,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {

        GWBVBContentWrapper(
            dataState = ordersState,

            dataPopulated = {
                val data = (ordersState as DataUiState.Populated).data

            },

            dataEmpty = {
                GWBVBEmptyView(
                    primaryText = stringResource(R.string.gwbvb_orders_state_empty_primary_text),
                    modifier = Modifier.fillMaxSize(),
                )
            },
        )
    }
}