package com.dimas.productsapp.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductListDto(
    @SerialName("products")
    val data: List<ProductDto>
)

