package com.dimas.compose.composeproductsapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dimas.compose.composeproductsapp.data.ProductsRepository
import com.dimas.compose.composeproductsapp.network.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface ProductsState {
    data class Success(val products: List<Product>) : ProductsState
    data object Loading : ProductsState
    data object Error : ProductsState
}


class ProductsViewModel(
    private val productsRepository: ProductsRepository
) : ViewModel() {

    private var _productsState = MutableStateFlow<ProductsState>(ProductsState.Loading)

    val productState
        get() = _productsState.asStateFlow()

    init {
        getProducts()
    }

    fun getProducts() {
        _productsState.update { ProductsState.Loading }
        viewModelScope.launch {
            _productsState.value = try {
                ProductsState.Success(productsRepository.getProducts())
            } catch (_: IOException) {
                ProductsState.Error
            }
        }
    }
}