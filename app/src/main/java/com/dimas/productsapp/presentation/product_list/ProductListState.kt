package com.dimas.productsapp.presentation.product_list

import androidx.compose.runtime.Immutable
import com.dimas.productsapp.domain.model.Product
import com.dimas.productsapp.presentation.utils.UiText

@Immutable
data class ProductListState(
    val products: List<Product> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: UiText? = null
)
