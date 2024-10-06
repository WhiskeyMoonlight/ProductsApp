package com.dimas.compose.composeproductsapp.di

import com.dimas.compose.composeproductsapp.data.ProductsRepository
import com.dimas.compose.composeproductsapp.data.ProductsRepositoryImpl
import com.dimas.compose.composeproductsapp.network.ProductsApiService
import com.dimas.compose.composeproductsapp.ui.viewmodels.ProductsViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private fun provideApiService(retrofit: Retrofit): ProductsApiService {
    return retrofit.create(ProductsApiService::class.java)
}

val appModule = module {
    // provide converterFactory
    single { GsonConverterFactory.create() } bind Converter.Factory::class

    // provide retrofit
    single {
        val baseUrl = "https://dummyjson.com"
        Retrofit.Builder()
            .addConverterFactory(get())
            .baseUrl(baseUrl)
            .build()
    }

    // provide ProductsApiService
    single<ProductsApiService> { provideApiService(get()) }

    singleOf(::ProductsRepositoryImpl) bind ProductsRepository::class
    viewModelOf(::ProductsViewModel)
}


