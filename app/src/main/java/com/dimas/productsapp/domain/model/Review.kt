package com.dimas.productsapp.domain.model

data class Review(
    val rating: Int,

    val comment: String,

    val date: String,

    val name: String,

    val email: String
)
