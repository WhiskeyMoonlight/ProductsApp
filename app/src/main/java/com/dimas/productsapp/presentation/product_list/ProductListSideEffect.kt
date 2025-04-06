package com.dimas.productsapp.presentation.product_list

import com.dimas.productsapp.domain.model.Product

sealed interface ProductListSideEffect {
    data class OnProductClick(val product: Product) : ProductListSideEffect
    data object OnTitleClick : ProductListSideEffect
}