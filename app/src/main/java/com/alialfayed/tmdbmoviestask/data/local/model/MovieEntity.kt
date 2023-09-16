package com.alialfayed.tmdbmoviestask.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class MovieEntity(
	@PrimaryKey(autoGenerate = true)
    var primaryKey: Int = 0,
	var id: Int ?= null,
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
	val voteCount: Int? = null,
	val page: Int = 0,
	)
