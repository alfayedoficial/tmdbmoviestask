package com.alialfayed.tmdbmoviestask.utils

const val API_KEY ="5de469b433b2d6ba5797f59c4f347f53"
const val ACCESS_TOKEN = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI1ZGU0NjliNDMzYjJkNmJhNTc5N2Y1OWM0ZjM0N2Y1MyIsInN1YiI6IjY1MDQxNDkzNmEyMjI3MDBmZDIyMWVhZSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.o0L-arYfMIS_0OVqTrRYRvVqxBzCOZNx9CCSDSWB8mg"
const val DATABASE_NAME = "TMDB_MOVIES_TASK"
const val REQUEST_TIME = 3L
const val BASE_URL = "https://api.themoviedb.org"
const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/original"
const val DEFAULT_FIRST_PAGE = 1

enum class NetworkLinks(val type: String) {
    /**-----------------------   GET   ---------------------*/
    GetPopularMovies("/3/movie/popular")
}

fun getApiLink(endPoint: String) = BASE_URL.plus(endPoint)
fun getImageUrl(imageUrl: String) = IMAGE_BASE_URL.plus(imageUrl)
