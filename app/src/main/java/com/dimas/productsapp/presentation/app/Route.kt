package com.dimas.productsapp.presentation.app

import kotlinx.serialization.Serializable

sealed interface Route {

    @Serializable
    data object ProductGraph : Route

    @Serializable
    data object ProductList : Route

    @Serializable
    data class ProductDetails(val id: Int) : Route
}