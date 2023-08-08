package com.example.moviesearch

data class Movie (
    val title: String,
    val length: Int,
    val genre: String,
    val rating: Int,
    val reviews: Int,
    val age: Int,
    val like: Boolean,
    val image: String
)