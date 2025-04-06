package com.dimas.productsapp.domain

import com.dimas.productsapp.domain.use_cases.GetProductsUseCase

data class ProductUseCases(
    val getProductsUseCase: GetProductsUseCase
)
