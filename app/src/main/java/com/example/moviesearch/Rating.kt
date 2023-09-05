package com.example.moviesearch

import kotlinx.serialization.Serializable

@Serializable
data class Rating(
    val Source: String,
    val Value: String
)
