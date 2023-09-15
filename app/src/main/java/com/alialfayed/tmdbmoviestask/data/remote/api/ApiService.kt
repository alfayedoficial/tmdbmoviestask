package com.alialfayed.tmdbmoviestask.data.remote.api

import com.alialfayed.tmdbmoviestask.data.remote.model.PopularMovesResponse
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface ApiService {

    @GET
    suspend fun getPopularMoviesApi(@Url url: String , @Query("page") page :Int = 1 ): PopularMovesResponse

}