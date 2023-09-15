package com.alialfayed.tmdbmoviestask.data.di

import com.alialfayed.tmdbmoviestask.data.MovieRepoImpl
import com.alialfayed.tmdbmoviestask.domain.MovieRepo
import dagger.Binds
import dagger.Module
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