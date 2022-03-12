package com.ml.moviesapp.work

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.ml.moviesapp.repository.MoviesRepository
import org.koin.core.component.KoinComponent
import org.koin.java.KoinJavaComponent.inject

class MoviesWorker(context: Context, parameters: WorkerParameters)
    : CoroutineWorker(context, parameters), KoinComponent {

    private val moviesRepository: MoviesRepository by inject(MoviesRepository::class.java)

    override suspend fun doWork(): Result =
        try {
            moviesRepository.getMovieResponseFromNetwork()
            Result.success()
        } catch(ex: Throwable) {
            Result.failure()
        }
}