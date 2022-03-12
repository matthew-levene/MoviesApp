package com.ml.moviesapp.di

import com.ml.moviesapp.repository.MoviesRepository
import org.koin.dsl.module

val repositoryModule = module {
    single {
        MoviesRepository(get(), get())
    }
}