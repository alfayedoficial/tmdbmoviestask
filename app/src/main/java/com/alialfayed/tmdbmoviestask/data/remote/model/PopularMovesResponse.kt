package com.alialfayed.tmdbmoviestask.data.remote.model

import com.squareup.moshi.Json

data class PopularMovesResponse(

    @Json(name = "page")
    val page: Int? = null,

    @Json(name = "total_pages")
    val totalPages: Int? = null,

    @Json(name = "results")
    val movies: MoviesList = arrayListOf(),

    @Json(name = "total_results")
    val totalResults: Int? = null
)

data class MovieDto(

    @Json(name = "id")
    val id: Int ,

    @Json(name = "overview")
    val overview: String? = null,

    @Json(name = "original_language")
    val originalLanguage: String? = null,

    @Json(name = "original_title")
    val originalTitle: String? = null,

    @Json(name = "video")
    val video: Boolean? = null,

    @Json(name = "title")
    val title: String? = null,

    @Json(name = "poster_path")
    val posterPath: String? = null,

    @Json(name = "backdrop_path")
    val backdropPath: String? = null,

    @Json(name = "release_date")
    val releaseDate: String? = null,

    @Json(name = "popularity")
    val popularity: Double? = null,

    @Json(name = "vote_average")
    val voteAverage: Float? = null,

    @Json(name = "adult")
    val adult: Boolean? = null,

    @Json(name = "vote_count")
    val voteCount: Int? = null
)

typealias MoviesList = MutableList<MovieDto>
