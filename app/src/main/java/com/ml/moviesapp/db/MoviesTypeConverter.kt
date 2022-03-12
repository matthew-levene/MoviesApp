package com.ml.moviesapp.db

import androidx.room.TypeConverter
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

object MoviesTypeConverter {

    @TypeConverter
    fun movieEntityToString(entity: MoviesEntity) =
        Json.encodeToString(entity)


    @TypeConverter
    fun movieEntityFromString(entity: String) : MoviesEntity =
        Json.decodeFromString(entity)

    @TypeConverter
    fun movieEntityDataToString(entity: List<MoviesEntityData>) =
        Json.encodeToString(entity)


    @TypeConverter
    fun movieEntityDataFromString(entity: String) : List<MoviesEntityData> =
        Json.decodeFromString(entity)

}