package com.dimas.productsapp.presentation.product_list

import com.dimas.productsapp.domain.model.Product

sealed interface ProductListAction {
    data class OnProductClick(val product: Product) : ProductListAction
    data object OnTitleClick : ProductListAction
    data object OnRetryClick : ProductListAction
}