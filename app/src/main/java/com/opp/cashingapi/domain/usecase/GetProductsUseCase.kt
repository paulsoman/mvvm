package com.opp.cashingapi.domain.usecase

import com.opp.cashingapi.domain.ProductRepository
import com.opp.cashingapi.domain.entity.Product
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(private val productRepository: ProductRepository){
    suspend fun invoke(): List<Product> =
        productRepository.fetchProducts()

}