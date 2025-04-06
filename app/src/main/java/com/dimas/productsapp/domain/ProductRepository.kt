package com.dimas.productsapp.domain

import com.dimas.productsapp.domain.error.DataError
import com.dimas.productsapp.domain.model.Product

interface ProductRepository {
    suspend fun getProducts(): Result<List<Product>, DataError.Remote>

    suspend fun getProductDescription(id: Int): Result<Product, DataError>
}