package com.hesham.domain.entity

data class Product(
    val limit: Int,
    val products: List<ProductItemDTO>,
    val skip: Int,
    val total: Int
)