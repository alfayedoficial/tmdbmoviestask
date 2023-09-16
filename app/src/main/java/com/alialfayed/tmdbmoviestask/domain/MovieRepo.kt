package com.alialfayed.tmdbmoviestask.domain

import androidx.paging.PagingData
import com.alialfayed.tmdbmoviestask.data.local.model.MovieEntity
import com.alialfayed.tmdbmoviestask.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepo {

    fun getPopularMoviesPagingFlow(): Flow<PagingData<Movie>>
    suspend fun getMovieDetailsById(id:Int): Movie?

}