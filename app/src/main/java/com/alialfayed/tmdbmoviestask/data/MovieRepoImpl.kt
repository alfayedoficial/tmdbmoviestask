package com.alialfayed.tmdbmoviestask.data

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.alialfayed.tmdbmoviestask.data.local.database.AppDatabase
import com.alialfayed.tmdbmoviestask.data.mapper.toMovie
import com.alialfayed.tmdbmoviestask.data.remote.api.ApiService
import com.alialfayed.tmdbmoviestask.data.remote.mediator.MoviesRemoteMediator
import com.alialfayed.tmdbmoviestask.domain.MovieRepo
import com.alialfayed.tmdbmoviestask.domain.model.Movie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MovieRepoImpl @Inject constructor(
    private val apiService: ApiService,
    private val appDatabase: AppDatabase
) : MovieRepo {

    @OptIn(ExperimentalPagingApi::class)
    override fun getPopularMoviesPagingFlow(): Flow<PagingData<Movie>> {
       return Pager(
           config = PagingConfig(pageSize = 20),
           remoteMediator = MoviesRemoteMediator(apiService, appDatabase),
           pagingSourceFactory = { appDatabase.movieDao().pagingSource() }
       ).flow.map {pagingData -> pagingData.map { it.toMovie() } }
    }


}