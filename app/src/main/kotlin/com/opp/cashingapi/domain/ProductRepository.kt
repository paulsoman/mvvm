package com.opp.cashingapi.domain

import com.opp.cashingapi.domain.entity.Product

interface ProductRepository {
    suspend fun fetchProducts(): List<Product>
}