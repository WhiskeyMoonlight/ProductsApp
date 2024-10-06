package com.dimas.compose.composeproductsapp.data

import com.dimas.compose.composeproductsapp.network.Product
import com.dimas.compose.composeproductsapp.network.ProductsApiService


interface ProductsRepository {
    suspend fun getProducts(): List<Product>

    suspend fun getProductById(id: Int): Product
}

class ProductsRepositoryImpl(
    private val apiService: ProductsApiService
) : ProductsRepository {

    override suspend fun getProducts(): List<Product> {
        return apiService.getProducts().data
    }

    override suspend fun getProductById(id: Int): Product {
        return apiService.getProductById(id)
    }
}