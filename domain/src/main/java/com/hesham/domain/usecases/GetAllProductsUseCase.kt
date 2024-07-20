package com.hesham.domain.usecases

import com.hesham.domain.entity.ProductItemDTO
import com.hesham.domain.repository.ProductsRepository
import javax.inject.Inject

class GetAllProductsUseCase @Inject constructor(private val productsRepository: ProductsRepository) {

    suspend operator fun invoke(): List<ProductItemDTO> = productsRepository.getProducts()
}