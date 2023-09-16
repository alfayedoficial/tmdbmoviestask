package com.alialfayed.tmdbmoviestask.data.remote.model

import com.squareup.moshi.Json

data class PopularMovesResponse(

    @Json(name = "page")
    val page: Int? = null,
    val total_pages: Int? = null,
    val results: MoviesList = arrayListOf(),
    val total_results: Int? = null
)

data class MovieDto(
    val id: Int,
    val overview: String? = null,
    val original_language: String? = null,
    val original_title: String? = null,
    val video: Boolean? = null,
    val title: String? = null,
    val poster_path: String? = null,
    val backdrop_path: String? = null,
    val release_date: String? = null,
    val popularity: Double? = null,
    val vote_average: Float? = null,
    val adult: Boolean? = null,
    val vote_count: Int? = null
)

typealias MoviesList = MutableList<MovieDto>
