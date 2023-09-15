package com.alialfayed.tmdbmoviestask.data.remote.mediator

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.alialfayed.tmdbmoviestask.data.local.database.AppDatabase
import com.alialfayed.tmdbmoviestask.data.local.deo.MovieDao
import com.alialfayed.tmdbmoviestask.data.local.model.MovieEntity
import com.alialfayed.tmdbmoviestask.data.mapper.toMovieEntity
import com.alialfayed.tmdbmoviestask.data.remote.api.ApiService
import com.alialfayed.tmdbmoviestask.utils.DEFAULT_FIRST_PAGE
import com.alialfayed.tmdbmoviestask.utils.NetworkLinks
import com.alialfayed.tmdbmoviestask.utils.getApiLink
import retrofit2.HttpException
import java.io.IOException

@OptIn(ExperimentalPagingApi::class)
class MoviesRemoteMediator(
    private val apiService: ApiService,
    private val appDatabase: AppDatabase
) : RemoteMediator<Int, MovieEntity>(){


    override suspend fun load(loadType: LoadType, state: PagingState<Int, MovieEntity>): MediatorResult {
        return try {
            val loadKey = when(loadType){
                LoadType.REFRESH -> DEFAULT_FIRST_PAGE
                LoadType.PREPEND -> return MediatorResult.Success(
                    endOfPaginationReached = true
                )
                LoadType.APPEND -> {
                    val lastItem = state.lastItemOrNull()
                    if (lastItem == null){
                        DEFAULT_FIRST_PAGE
                    }else{
                        (lastItem.id / state.config.pageSize) + DEFAULT_FIRST_PAGE
                    }
                }
            }

            val popularMovesResponse = apiService.getPopularMoviesApi(getApiLink(NetworkLinks.GetPopularMovies.type) , page = loadKey)

            appDatabase.withTransaction {

                if ( loadType == LoadType.REFRESH){
                    appDatabase.movieDao().clearAll()
                }

                val movieEntities = popularMovesResponse.movies.map { it.toMovieEntity() }
                appDatabase.movieDao().upsertAll(movieEntities)
            }

            MediatorResult.Success(endOfPaginationReached = popularMovesResponse.movies.isEmpty())
        }catch (e:IOException){
            MediatorResult.Error(e)
        }catch (e:HttpException){
            MediatorResult.Error(e)
        }
    }
}