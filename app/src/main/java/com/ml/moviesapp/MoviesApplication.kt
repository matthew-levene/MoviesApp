package com.ml.moviesapp

import android.app.Application
import com.ml.moviesapp.di.databaseModule
import com.ml.moviesapp.di.networkModule
import com.ml.moviesapp.di.repositoryModule
import com.ml.moviesapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MoviesApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@MoviesApplication)
            modules(listOf(databaseModule, networkModule, repositoryModule, viewModelModule))
        }
    }
}