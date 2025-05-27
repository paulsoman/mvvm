package com.opp.cashingapi.presentation

import com.opp.cashingapi.domain.entity.Product

sealed class ProductUiState {
    object Loading : ProductUiState()
    data class Success(val products: List<Product>) : ProductUiState()
    data class Error(val message: String) : ProductUiState()

}