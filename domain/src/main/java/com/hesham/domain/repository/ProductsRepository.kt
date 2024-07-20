package com.hesham.domain.repository

import com.hesham.domain.entity.ProductItemDTO

interface ProductsRepository {
suspend fun getProducts() : List<ProductItemDTO>
}

interface ProductsOnlineDataSource{
    suspend fun fetchAllProducts() : List<ProductItemDTO>
}