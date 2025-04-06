package com.dimas.productsapp.domain.model

data class Product(
    val id: Int,

    val title: String,

    val desc: String,

    val category: String,

    val price: Double,

    val discountPercentage: Double,

    val rating: Double,

    val stock: Int,

    val tags: List<String>,

    val dimensions: Dimensions,

    val reviews: List<Review>,

    val images: List<String>,

    val thumbnail: String
)

