package com.alialfayed.tmdbmoviestask.presentation.features.homeScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.alialfayed.tmdbmoviestask.domain.MovieRepo
import com.alialfayed.tmdbmoviestask.domain.model.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val movieRepo: MovieRepo,
) : ViewModel() {

    val selectedMovieDetailsState: StateFlow<Movie?>
        get() = _selectedMovieDetailsState
    private val _selectedMovieDetailsState = MutableStateFlow<Movie?>(null)


    fun selectMovieDetails(id: Int) {
        viewModelScope.launch {
            _selectedMovieDetailsState.value = movieRepo.getMovieDetailsById(id)
        }
    }

    val popularMovies = movieRepo.getPopularMoviesPagingFlow().cachedIn(viewModelScope)

}