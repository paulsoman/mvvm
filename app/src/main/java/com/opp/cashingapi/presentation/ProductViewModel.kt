package com.opp.cashingapi.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.opp.cashingapi.domain.usecase.GetProductsUseCase
import com.opp.cashingapi.presentation.ProductUiState.Loading
import com.opp.cashingapi.utils.orDefault
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(private val getProductsUseCase: GetProductsUseCase) :
    ViewModel() {
    private val _uiState: MutableStateFlow<ProductUiState> = MutableStateFlow(Loading)
    val uiState: StateFlow<ProductUiState> = _uiState

    init {
        Log.d("HILT_DEBUG", "ProductViewModel injected")
        viewModelScope.launch {
            _uiState.value = Loading
            try {
                val result = getProductsUseCase()
                _uiState.value = ProductUiState.Success(result)

            } catch (exception: Exception) {
                _uiState.value =
                    ProductUiState.Error(exception.message.orDefault("Error in loading products"))

            }
        }

    }
}