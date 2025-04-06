package com.dimas.productsapp.domain.use_cases

import com.dimas.productsapp.domain.ProductRepository
import com.dimas.productsapp.domain.Result
import com.dimas.productsapp.domain.error.DataError
import com.dimas.productsapp.domain.model.Product

class GetProductsUseCase(
    private val repository: ProductRepository
) : suspend () -> Result<List<Product>, DataError.Remote> {
    override suspend fun invoke(): Result<List<Product>, DataError.Remote> {
        return repository.getProducts()
    }
}
