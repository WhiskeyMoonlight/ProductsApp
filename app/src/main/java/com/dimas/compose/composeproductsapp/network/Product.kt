package com.dimas.compose.composeproductsapp.network

import com.google.gson.annotations.SerializedName

data class ProductsResponse(
    @SerializedName("products")
    val data: List<Product>
)

data class Product(
    @SerializedName("id")
    val id: Int,

    @SerializedName("title")
    val title: String,

    @SerializedName("description")
    val desc: String,

    @SerializedName("category")
    val category: String,

    @SerializedName("price")
    val price: Double,

    @SerializedName("discountPercentage")
    val discountPercentage: Double,

    @SerializedName("rating")
    val rating: Double,

    @SerializedName("stock")
    val stock: Int,

    @SerializedName("tags")
    val tags: List<String>,

    @SerializedName("brand")
    val brand: String,

    @SerializedName("sku")
    val sku: String,

    @SerializedName("weight")
    val weight: Int,

    @SerializedName("dimensions")
    val dimensions: Dimensions,

    /*
        @SerializedName("warrantyInformation")
        val warranty: String,

        @SerializedName("shippingInformation")
        val shipping: String,

        @SerializedName("availabilityStatus")
        val availability: String,
    */
    @SerializedName("reviews")
    val reviews: List<Review>,

    /*
        @SerializedName("returnPolicy")
        val returnPolicy: String,

        @SerializedName("minimumOrderQuantity")
        val minQuantity: Int,

        @SerializedName("images")
    */
    val images: List<String>,

    @SerializedName("thumbnail")
    val thumbnail: String
)

data class Dimensions(
    @SerializedName("width")
    val width: Double,

    @SerializedName("height")
    val height: Double,

    @SerializedName("depth")
    val depth: Double
)

data class Review(
    @SerializedName("rating")
    val rating: Int,

    @SerializedName("comment")
    val comment: String,

    @SerializedName("date")
    val date: String,

    @SerializedName("reviewerName")
    val name: String,

    @SerializedName("reviewerEmail")
    val email: String
)
