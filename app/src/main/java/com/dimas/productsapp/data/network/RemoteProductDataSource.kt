package com.dimas.productsapp.data.network

import com.dimas.productsapp.data.dto.ProductDto
import com.dimas.productsapp.data.dto.ProductListDto
import com.dimas.productsapp.domain.Result
import com.dimas.productsapp.domain.error.DataError

class RemoteProductDataSource(
    private val apiService: ProductsApiService
) : RemoteDataSource {
    override suspend fun getProducts(): Result<ProductListDto, DataError.Remote> {
        return safeCall<ProductListDto> {
            apiService.getProducts()
        }
    }

    override suspend fun getProductDescription(id: Int): Result<ProductDto, DataError.Remote> {
        return safeCall<ProductDto> {
            apiService.getProductById(id)
        }
    }
}