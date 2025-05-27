package com.opp.cashingapi.data.dto

data class ProductsDTO(
    val limit: Int,
    val products: List<ProductDTO>,
    val skip: Int,
    val total: Int
)