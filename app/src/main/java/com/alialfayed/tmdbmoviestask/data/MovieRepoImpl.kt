package com.alialfayed.tmdbmoviestask.data

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.RemoteMediator
import androidx.paging.map
import com.alialfayed.tmdbmoviestask.data.local.database.AppDatabase
import com.alialfayed.tmdbmoviestask.data.local.deo.MovieDao
import com.alialfayed.tmdbmoviestask.data.local.model.MovieEntity
import com.alialfayed.tmdbmoviestask.data.mapper.toMovie
import com.alialfayed.tmdbmoviestask.data.mapper.toMovieOrNull
import com.alialfayed.tmdbmoviestask.data.remote.api.ApiService
import com.alialfayed.tmdbmoviestask.data.remote.mediator.MoviesRemoteMediator
import com.alialfayed.tmdbmoviestask.domain.MovieRepo
import com.alialfayed.tmdbmoviestask.domain.model.Movie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieRepoImpl @Inject constructor(
    private val movieDao: MovieDao,
    private val pager:Pager<Int , MovieEntity>
) : MovieRepo {

    override fun getPopularMoviesPagingFlow(): Flow<PagingData<Movie>> {
       return pager.flow.map {pagingData -> pagingData.map { it.toMovie() } }
    }


    override suspend fun getMovieDetailsById(id: Int): Movie? {
       return movieDao.getMovieDetailsById(id).toMovieOrNull()
    }


}