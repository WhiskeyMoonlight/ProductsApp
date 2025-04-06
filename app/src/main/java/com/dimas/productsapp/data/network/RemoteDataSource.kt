package com.dimas.productsapp.data.network

import com.dimas.productsapp.data.dto.ProductDto
import com.dimas.productsapp.data.dto.ProductListDto
import com.dimas.productsapp.domain.Result
import com.dimas.productsapp.domain.error.DataError

interface RemoteDataSource {
    suspend fun getProducts(): Result<ProductListDto, DataError.Remote>

    suspend fun getProductDescription(id: Int): Result<ProductDto, DataError.Remote>
}