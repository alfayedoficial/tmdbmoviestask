package com.alialfayed.tmdbmoviestask.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.alialfayed.tmdbmoviestask.data.local.deo.MovieDao
import com.alialfayed.tmdbmoviestask.data.local.model.MovieEntity

@Database(
    version = 22,
    entities = [
        MovieEntity::class
    ],
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao

}
