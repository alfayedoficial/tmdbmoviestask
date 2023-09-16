package com.alialfayed.tmdbmoviestask.presentation.features.homeScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.CombinedLoadStates
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.alialfayed.tmdbmoviestask.domain.model.Movie
import com.alialfayed.tmdbmoviestask.utils.kuToast

@Composable
fun HomeScreen(
    onDetailsClicked: (Int) -> Unit,
    viewModel: MoviesViewModel
) {
    val context = LocalContext.current
    val popularMovies = viewModel.popularMovies.collectAsLazyPagingItems()
    val loadState: CombinedLoadStates = popularMovies.loadState

    LaunchedEffect(key1 = loadState) {
        if(loadState.refresh is LoadState.Error) {
            context.kuToast("Error: " + (popularMovies.loadState.refresh as LoadState.Error).error.message)
        }
    }


    Box(modifier = Modifier.fillMaxSize()) {

        if (loadState.refresh is LoadState.Loading){
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }else{
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(count = popularMovies.itemCount) { index ->
                    val movie = popularMovies[index]
                    if(movie != null) {
                        MovieItem(
                            movie = movie,
                            modifier = Modifier.fillMaxWidth(),
                            onClick = onDetailsClicked
                        )
                    }
                }
                item {
                    if(popularMovies.loadState.append is LoadState.Loading) {
                        CircularProgressIndicator()
                    }
                }
            }
        }


    }

}