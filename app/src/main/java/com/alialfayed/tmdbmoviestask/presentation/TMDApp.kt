package com.alialfayed.tmdbmoviestask.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.alialfayed.tmdbmoviestask.R
import com.alialfayed.tmdbmoviestask.presentation.features.detailsMovie.DetailsMovieScreen
import com.alialfayed.tmdbmoviestask.presentation.features.homeScreen.HomeScreen
import com.alialfayed.tmdbmoviestask.presentation.features.homeScreen.MoviesViewModel


/**
 * enum values that represent the screens in the app
 */
enum class TMDScreen(val title: Int) {
    HOME_SCREEN(title = R.string.app_name),
    DETAILS_MOVIE_SCREEN(title = R.string.details),
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TMDApp(
    viewModel: MoviesViewModel = hiltViewModel(),
    navController: NavHostController = rememberNavController()) {
    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen
    val currentScreen = TMDScreen.valueOf(
        backStackEntry?.destination?.route ?: TMDScreen.HOME_SCREEN.name
    )


    Scaffold(
        topBar = {
            TMDAppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        }
    ){ innerPadding ->


        NavHost(
            navController = navController,
            startDestination = TMDScreen.HOME_SCREEN.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = TMDScreen.HOME_SCREEN.name) {
                HomeScreen(
                    viewModel =viewModel ,
                    onDetailsClicked = {
                        viewModel.selectMovieDetails(it)
                        navController.navigate(TMDScreen.DETAILS_MOVIE_SCREEN.name)
                    }
                )
            }

            composable(route = TMDScreen.DETAILS_MOVIE_SCREEN.name) {
                DetailsMovieScreen(
                    viewModel =viewModel ,
                )
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TMDAppBar(
    currentScreen: TMDScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(stringResource(currentScreen.title)) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        }
    )
}
