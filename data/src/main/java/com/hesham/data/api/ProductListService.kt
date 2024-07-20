package com.hesham.data.api


import com.hesham.data.model.ProductResponse
import retrofit2.http.GET

interface ProductListService {

    @GET("/products")
    suspend fun getAllProductsOfCategory(): ProductResponse
}