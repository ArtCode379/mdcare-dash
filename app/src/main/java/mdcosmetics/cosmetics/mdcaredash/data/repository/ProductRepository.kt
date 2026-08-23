package mdcosmetics.cosmetics.mdcaredash.data.repository

import mdcosmetics.cosmetics.mdcaredash.data.model.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class ProductRepository {
    private val products: List<Product> = listOf(

    )

    fun observeById(id: Int): Flow<Product?> {
        val item = products.find { it.id == id }
        return flowOf(item)
    }

    fun getById(id: Int): Product? {
        return products.find { it.id == id }
    }

    fun observeAll(): Flow<List<Product>> {
        return flowOf(products)
    }
}