package com.alialfayed.tmdbmoviestask.data.di

import android.content.Context
import androidx.room.Room
import com.alialfayed.tmdbmoviestask.utils.DATABASE_NAME
import com.alialfayed.tmdbmoviestask.data.local.database.AppDatabase
import com.alialfayed.tmdbmoviestask.data.local.deo.MovieDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }


    @Singleton
    @Provides
    fun provideMovieDao(appDatabase: AppDatabase) =appDatabase.movieDao()


}
