package com.hesham.data.dataSources

import com.hesham.data.api.ProductListService
import com.hesham.domain.entity.ProductItemDTO
import com.hesham.domain.repository.ProductsOnlineDataSource

class ProductsOnlineDataSourceImpl(private val service: ProductListService) :
    ProductsOnlineDataSource {
    override suspend fun fetchAllProducts(): List<ProductItemDTO> {
        return try {
            service.getAllProductsOfCategory().products.map {
                it?.toDTO() ?: ProductItemDTO()
            }
        } catch (e: Exception) {

            throw e
        }
    }
}