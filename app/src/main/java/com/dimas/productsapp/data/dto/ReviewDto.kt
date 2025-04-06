package com.dimas.productsapp.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ReviewDto(
    @SerialName("rating")
    val rating: Int,

    @SerialName("comment")
    val comment: String,

    @SerialName("date")
    val date: String,

    @SerialName("reviewerName")
    val name: String,

    @SerialName("reviewerEmail")
    val email: String
)
