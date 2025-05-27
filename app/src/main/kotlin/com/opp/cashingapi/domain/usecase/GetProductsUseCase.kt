package com.opp.cashingapi.domain.usecase

import android.util.Log
import com.opp.cashingapi.domain.ProductRepository
import com.opp.cashingapi.domain.entity.Product
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(private val productRepository: ProductRepository){
    suspend operator fun invoke(): List<Product> =
        productRepository.fetchProducts()

    init {
        Log.d("HILT_DEBUG", "GetProductsUseCase injected")
    }

}