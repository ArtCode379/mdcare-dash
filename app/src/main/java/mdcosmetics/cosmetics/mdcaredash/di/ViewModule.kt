package mdcosmetics.cosmetics.mdcaredash.di

import mdcosmetics.cosmetics.mdcaredash.ui.viewmodel.AppViewModel
import mdcosmetics.cosmetics.mdcaredash.ui.viewmodel.CartViewModel
import mdcosmetics.cosmetics.mdcaredash.ui.viewmodel.CheckoutViewModel
import mdcosmetics.cosmetics.mdcaredash.ui.viewmodel.GWBVBOnboardingVM
import mdcosmetics.cosmetics.mdcaredash.ui.viewmodel.GWBVBSplashVM
import mdcosmetics.cosmetics.mdcaredash.ui.viewmodel.OrderViewModel
import mdcosmetics.cosmetics.mdcaredash.ui.viewmodel.ProductDetailsViewModel
import mdcosmetics.cosmetics.mdcaredash.ui.viewmodel.ProductViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModule = module {
  viewModel { AppViewModel(cartRepository = get()) }

  viewModel { GWBVBSplashVM(onboardingRepository = get()) }

  viewModel { GWBVBOnboardingVM(onboardingRepository = get()) }

  viewModel {
    ProductViewModel(
        productRepository = get(),
        cartRepository = get(),
    )
  }

  viewModel {
    ProductDetailsViewModel(
        productRepository = get(),
        cartRepository = get(),
    )
  }

  viewModel {
    CheckoutViewModel(
        cartRepository = get(),
        productRepository = get(),
        orderRepository = get(),
    )
  }

  viewModel {
    CartViewModel(
        cartRepository = get(),
        productRepository = get(),
    )
  }

  viewModel {
    OrderViewModel(
        orderRepository = get(),
    )
  }
}
