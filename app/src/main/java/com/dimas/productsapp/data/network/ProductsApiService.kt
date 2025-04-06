package com.dimas.productsapp.data.network

import com.dimas.productsapp.data.dto.ProductDto
import com.dimas.productsapp.data.dto.ProductListDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductsApiService {

    @GET("products")
    suspend fun getProducts(): Response<ProductListDto>

    @GET("products/{id}")
    suspend fun getProductById(@Path(value = "id") id: Int): Response<ProductDto>
}