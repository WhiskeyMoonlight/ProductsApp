package com.dimas.productsapp.di

import com.dimas.productsapp.data.network.ProductsApiService
import com.dimas.productsapp.data.network.RemoteDataSource
import com.dimas.productsapp.data.network.RemoteProductDataSource
import com.dimas.productsapp.data.repository.ProductRepositoryImpl
import com.dimas.productsapp.domain.ProductRepository
import com.dimas.productsapp.domain.ProductUseCases
import com.dimas.productsapp.domain.use_cases.GetProductsUseCase
import com.dimas.productsapp.presentation.product_list.ProductListViewModel
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit

private const val BASE_URL = "https://dummyjson.com"

val appModule = module {
    single<ProductsApiService> { provideApiService(get()) }

    single {
        val networkJson = Json { ignoreUnknownKeys = true }
        val mediaType = "application/json".toMediaType()
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(networkJson.asConverterFactory(mediaType))
            .build()
    }

    singleOf(::RemoteProductDataSource) bind RemoteDataSource::class
    singleOf(::ProductRepositoryImpl) bind ProductRepository::class

    singleOf(::ProductUseCases)

    // UseCases
    singleOf(::GetProductsUseCase)

    viewModelOf(::ProductListViewModel)
}

private fun provideApiService(retrofit: Retrofit): ProductsApiService {
    return retrofit.create(ProductsApiService::class.java)
}