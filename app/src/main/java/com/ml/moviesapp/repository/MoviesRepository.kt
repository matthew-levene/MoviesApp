package com.ml.moviesapp.repository

import com.ml.moviesapp.db.MoviesDao
import com.ml.moviesapp.db.MoviesEntity
import com.ml.moviesapp.network.MovieApiService
import com.ml.moviesapp.util.toMovieDataList
import com.ml.moviesapp.util.toMovieEntity
import kotlinx.coroutines.flow.flowOf

class MoviesRepository(
    private val movieApiService: MovieApiService,
    private val moviesDao: MoviesDao
) : Repository {
    override suspend fun getMovieResponseFromNetwork() {
        storeMovieResponseToDb(movieApiService.getMoviesResponse().toMovieEntity())
    }

    private suspend fun storeMovieResponseToDb(moviesEntity: MoviesEntity) {
        moviesDao.insertMovieEntity(moviesEntity)
    }

    suspend fun getMoviesFromDb() = flowOf(
        moviesDao.getMovieEntity().toMovieDataList()
    )
}