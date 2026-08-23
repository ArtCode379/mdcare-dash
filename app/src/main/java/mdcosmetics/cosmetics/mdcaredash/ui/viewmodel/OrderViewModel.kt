package mdcosmetics.cosmetics.mdcaredash.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import mdcosmetics.cosmetics.mdcaredash.data.entity.OrderEntity
import mdcosmetics.cosmetics.mdcaredash.data.repository.OrderRepository
import mdcosmetics.cosmetics.mdcaredash.ui.state.DataUiState

class OrderViewModel(
    private val orderRepository: OrderRepository,
) : ViewModel() {
  private val _ordersState = MutableStateFlow<DataUiState<List<OrderEntity>>>(DataUiState.Initial)
  val ordersState: StateFlow<DataUiState<List<OrderEntity>>>
    get() = _ordersState.asStateFlow()

  init {
    observeOrders()
  }

  private fun observeOrders() {
    viewModelScope.launch {
      orderRepository.observeAll().collect { orders ->
        _ordersState.update { DataUiState.from(orders) }
      }
    }
  }

  fun deleteOrder(orderNumber: String) {
    viewModelScope.launch { orderRepository.deleteByNumber(orderNumber) }
  }
}
