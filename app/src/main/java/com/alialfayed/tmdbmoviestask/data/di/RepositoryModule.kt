package com.alialfayed.tmdbmoviestask.data.di

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.RemoteMediator
import com.alialfayed.tmdbmoviestask.data.MovieRepoImpl
import com.alialfayed.tmdbmoviestask.data.local.database.AppDatabase
import com.alialfayed.tmdbmoviestask.data.local.deo.MovieDao
import com.alialfayed.tmdbmoviestask.data.local.model.MovieEntity
import com.alialfayed.tmdbmoviestask.data.remote.api.ApiService
import com.alialfayed.tmdbmoviestask.data.remote.mediator.MoviesRemoteMediator
import com.alialfayed.tmdbmoviestask.domain.MovieRepo
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by ( Eng Ali Al Fayed)
 * Class do : Hilt RepositoryModule @Inject
 * Date 15/9/2023 - 9:23 PM
 */



@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule{

    @Singleton
    @Binds
    fun bindMovieRepo(movieRepoImpl: MovieRepoImpl): MovieRepo

}

@OptIn(ExperimentalPagingApi::class)
@Module
@InstallIn(SingletonComponent::class)
object MediatorModule{

    @Singleton
    @Provides
    fun provideMediator(appDatabase: AppDatabase, apiService: ApiService): RemoteMediator<Int, MovieEntity>{
        return MoviesRemoteMediator(apiService, appDatabase)
    }

    @Singleton
    @Provides
    fun providePagingConfig() = PagingConfig(pageSize = 20)

    @Singleton
    @Provides
    fun providePager(pagingConfig : PagingConfig , moviesRemoteMediator : RemoteMediator<Int, MovieEntity> , movieDao:MovieDao) = Pager(
        config = pagingConfig,
        remoteMediator = moviesRemoteMediator ,
        pagingSourceFactory = { movieDao.pagingSource() }
    )
}