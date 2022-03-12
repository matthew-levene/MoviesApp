package com.ml.moviesapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ml.moviesapp.data.MovieData
import com.ml.moviesapp.repository.MoviesRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MoviesViewModel(
    private val moviesRepository: MoviesRepository
) : ViewModel() {

    private val _moviesEvent = MutableLiveData<List<MovieData>>()
    val movieEvent: LiveData<List<MovieData>> get() = _moviesEvent

    init {
        viewModelScope.launch {
            getMovies()
        }
    }

    private suspend fun getMovies() {
        moviesRepository.getMovieResponseFromNetwork()
    }

    suspend fun getMoviesFromDb() {
        moviesRepository.getMoviesFromDb().collect {
            _moviesEvent.value = it
        }
    }

    suspend fun filterMovies(searchTerm: String) {
        moviesRepository.getMoviesFromDb().collect {
            _moviesEvent.value = it.filter { mvData ->
                mvData.genre.contains(searchTerm, ignoreCase = true) ||
                        mvData.title.contains(searchTerm, ignoreCase = true)
            }
        }
    }
}
