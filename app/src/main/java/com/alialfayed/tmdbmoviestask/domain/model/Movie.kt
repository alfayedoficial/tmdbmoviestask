package com.alialfayed.tmdbmoviestask.domain.model

data class Movie(
    val id: Int?,
    val overview: String? = null,
    val originalLanguage: String? = null,
    val originalTitle: String? = null,
    val video: Boolean? = null,
    val title: String? = null,
    val posterPath: String? = null,
    val backdropPath: String? = null,
    val releaseDate: String? = null,
    val popularity: Double? = null,
    val voteAverage: Float? = null,
    val adult: Boolean? = null,
    val voteCount: Int? = null

)
