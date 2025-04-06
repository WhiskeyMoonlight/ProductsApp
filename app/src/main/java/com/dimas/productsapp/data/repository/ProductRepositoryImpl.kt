package com.dimas.productsapp.data.repository

import com.dimas.productsapp.data.mappers.toProduct
import com.dimas.productsapp.data.mappers.toProductList
import com.dimas.productsapp.data.network.RemoteDataSource
import com.dimas.productsapp.domain.model.Product
import com.dimas.productsapp.domain.ProductRepository
import com.dimas.productsapp.domain.Result
import com.dimas.productsapp.domain.error.DataError
import com.dimas.productsapp.domain.map

class ProductRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
) : ProductRepository {
    override suspend fun getProducts(): Result<List<Product>, DataError.Remote> {
        return remoteDataSource.getProducts().map { it.toProductList() }
    }

    override suspend fun getProductDescription(id: Int): Result<Product, DataError> {
        return remoteDataSource.getProductDescription(id).map { it.toProduct() }
    }
}