package com.opp.cashingapi.data.repositoryimpl

import android.util.Log
import com.opp.cashingapi.data.api.ProductsApi
import com.opp.cashingapi.data.dto.toProduct
import com.opp.cashingapi.domain.ProductRepository
import com.opp.cashingapi.domain.entity.Product
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(private val api: ProductsApi) : ProductRepository {
    override suspend fun fetchProducts(): List<Product> =
        api.getProducts().products.map {
           it.toProduct()
        }
    init {
        Log.d("HILT_DEBUG", "ProductRepositoryImpl injected")
    }
}