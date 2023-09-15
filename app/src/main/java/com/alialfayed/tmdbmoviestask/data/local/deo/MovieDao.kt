package com.alialfayed.tmdbmoviestask.data.local.deo

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.alialfayed.tmdbmoviestask.data.local.model.MovieEntity

@Dao
interface MovieDao {

    @Upsert
    suspend fun upsertAll(movies: List<MovieEntity>)

    @Query("SELECT * FROM MovieEntity")
    fun pagingSource():PagingSource<Int , MovieEntity>

    @Query("DELETE  FROM MovieEntity")
    suspend fun clearAll()
}