package com.dimas.productsapp.data.mappers

import com.dimas.productsapp.data.dto.DimensionsDto
import com.dimas.productsapp.data.dto.ProductDto
import com.dimas.productsapp.data.dto.ProductListDto
import com.dimas.productsapp.data.dto.ReviewDto
import com.dimas.productsapp.domain.model.Dimensions
import com.dimas.productsapp.domain.model.Product
import com.dimas.productsapp.domain.model.Review

fun DimensionsDto.toDimensions(): Dimensions {
    return Dimensions(
        width = this.width,
        height = this.height,
        depth = this.depth
    )
}

fun ReviewDto.toReview(): Review {
    return Review(
        rating = this.rating,
        comment = this.comment,
        date = this.date,
        name = this.name,
        email = this.email
    )
}

fun ProductDto.toProduct(): Product {
    return Product(
        id = this.id,
        title = this.title,
        desc = this.desc,
        category = this.category,
        price = this.price,
        discountPercentage = this.discountPercentage,
        rating = this.rating,
        stock = this.stock,
        tags = this.tags,
        dimensions = this.dimensions.toDimensions(),
        reviews = this.reviews.map { it.toReview() },
        images = this.images,
        thumbnail = this.thumbnail
    )
}

fun ProductListDto.toProductList(): List<Product> = this.data.map { it.toProduct() }
