package com.dimas.compose.composeproductsapp.network

import retrofit2.http.GET
import retrofit2.http.Path

interface ProductsApiService {

    @GET("products")
    suspend fun getProducts(): ProductsResponse

    @GET("products/{id}")
    suspend fun getProductById(@Path(value = "id") id: Int): Product
}