package com.alialfayed.tmdbmoviestask.data.mapper

import com.alialfayed.tmdbmoviestask.data.local.model.MovieEntity
import com.alialfayed.tmdbmoviestask.data.remote.model.MovieDto
import com.alialfayed.tmdbmoviestask.domain.model.Movie

fun MovieDto.toMovieEntity(): MovieEntity {
    return MovieEntity(
        id = id,
        overview = overview,
        originalLanguage = originalLanguage,
        originalTitle = originalTitle,
        video = video,
        title = title,
        posterPath = posterPath,
        backdropPath = backdropPath,
        releaseDate = releaseDate,
        popularity = popularity,
        voteAverage = voteAverage,
        adult = adult,
        voteCount = voteCount
    )
}

fun MovieEntity.toMovie(): Movie {
    return Movie(
        id = id,
        overview = overview,
        originalLanguage = originalLanguage,
        originalTitle = originalTitle,
        video = video,
        title = title,
        posterPath = posterPath,
        backdropPath = backdropPath,
        releaseDate = releaseDate,
        popularity = popularity,
        voteAverage = voteAverage,
        adult = adult,
        voteCount = voteCount
    )
}