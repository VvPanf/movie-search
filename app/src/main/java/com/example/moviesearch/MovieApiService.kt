package com.example.moviesearch

import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {
    @GET("/")
    suspend fun getFilmById(@Query("i") id: String): MovieResponse
}