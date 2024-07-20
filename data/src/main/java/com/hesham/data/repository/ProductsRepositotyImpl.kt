package com.hesham.data.repository

import com.hesham.domain.entity.ProductItemDTO
import com.hesham.domain.repository.NetworkHandler
import com.hesham.domain.repository.ProductsOnlineDataSource
import com.hesham.domain.repository.ProductsRepository
import javax.inject.Inject

class ProductsRepositotyImpl @Inject constructor(
    private val onlineDateSource: ProductsOnlineDataSource,
    private val networkHandler: NetworkHandler
) : ProductsRepository {
    override suspend fun getProducts(): List<ProductItemDTO> {
        if (networkHandler.isOnline()) {
            val productsList = onlineDateSource.fetchAllProducts()
            return productsList
        } else {
            return listOf()
        }
    }
}