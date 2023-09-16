package com.alialfayed.tmdbmoviestask.presentation.features.detailsMovie

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import com.alialfayed.tmdbmoviestask.presentation.features.homeScreen.MoviesViewModel
import com.alialfayed.tmdbmoviestask.utils.kuToast

@Composable
fun DetailsMovieScreen(
    viewModel: MoviesViewModel,
) {

    val selectedMovie by viewModel.selectedMovieDetailsState.collectAsState()


    selectedMovie?.let {
        MovieDetailsItem(movie = it)
    }

}

