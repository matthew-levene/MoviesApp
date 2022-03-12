package com.ml.moviesapp.network

import retrofit2.http.GET

interface MovieApiService {
    @GET("/api/movies")
    suspend fun getMoviesResponse() : MoviesResponse
}