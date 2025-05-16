package com.opp.cashingapi.data.api

import com.opp.cashingapi.data.dto.ProductsDTO
import com.opp.cashingapi.domain.entity.Product
import retrofit2.http.GET

interface ProductsApi {

    @GET("products")
    suspend fun getProducts(): ProductsDTO
}