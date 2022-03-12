package com.ml.moviesapp.di

import androidx.room.Room
import com.ml.moviesapp.db.MoviesDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(androidContext(), MoviesDatabase::class.java, "moviedb")
            .fallbackToDestructiveMigration()
            .build()
            .getMoviesDao()
    }
}