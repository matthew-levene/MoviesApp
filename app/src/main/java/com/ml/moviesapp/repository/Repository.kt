package com.ml.moviesapp.repository

import com.ml.moviesapp.data.MovieData
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun getMovieResponseFromNetwork()
}