package mdcosmetics.cosmetics.mdcaredash.di

import mdcosmetics.cosmetics.mdcaredash.data.repository.CartRepository
import mdcosmetics.cosmetics.mdcaredash.data.repository.GWBVBOnboardingRepo
import mdcosmetics.cosmetics.mdcaredash.data.repository.OrderRepository
import mdcosmetics.cosmetics.mdcaredash.data.repository.ProductRepository

import org.koin.core.qualifier.named
import org.koin.dsl.module

val dataModule = module {
    includes(databaseModule, dataStoreModule)

    single {
        GWBVBOnboardingRepo(
            gwbvbOnboardingStoreManager = get(),
            coroutineDispatcher = get(named("IO"))
        )
    }

    single { ProductRepository() }

    single {
        CartRepository(
            cartItemDao = get(),
            coroutineDispatcher = get(named("IO"))
        )
    }

    single {
        OrderRepository(
            orderDao = get(),
            coroutineDispatcher = get(named("IO"))
        )
    }
}