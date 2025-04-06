package com.dimas.productsapp.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductDto(
    @SerialName("id")
    val id: Int,

    @SerialName("title")
    val title: String,

    @SerialName("description")
    val desc: String,

    @SerialName("category")
    val category: String,

    @SerialName("price")
    val price: Double,

    @SerialName("discountPercentage")
    val discountPercentage: Double,

    @SerialName("rating")
    val rating: Double,

    @SerialName("stock")
    val stock: Int,

    @SerialName("tags")
    val tags: List<String>,

    @SerialName("dimensions")
    val dimensions: DimensionsDto,

    /*
        @SerialName("warrantyInformation")
        val warranty: String,

        @SerialName("shippingInformation")
        val shipping: String,

        @SerialName("availabilityStatus")
        val availability: String,
    */

    @SerialName("reviews")
    val reviews: List<ReviewDto>,

    /*
        @SerialName("returnPolicy")
        val returnPolicy: String,

        @SerialName("minimumOrderQuantity")
        val minQuantity: Int,
    */

    @SerialName("images")
    val images: List<String>,

    @SerialName("thumbnail")
    val thumbnail: String
)