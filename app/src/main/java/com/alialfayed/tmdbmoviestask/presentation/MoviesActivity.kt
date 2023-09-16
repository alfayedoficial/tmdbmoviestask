package com.alialfayed.tmdbmoviestask.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import coil.Coil
import coil.ImageLoader
import coil.request.CachePolicy
import com.alialfayed.tmdbmoviestask.presentation.features.homeScreen.HomeScreen
import com.alialfayed.tmdbmoviestask.theme.TMDbMoviesTaskTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val imageLoader = ImageLoader.Builder(this)
            .memoryCachePolicy(CachePolicy.ENABLED)
            .diskCachePolicy(CachePolicy.ENABLED)
            .build()

        Coil.setImageLoader(imageLoader) // S

        setContent {
            TMDbMoviesTaskTheme {
                // A surface container using the 'background' color from the theme
                TMDApp()
            }
        }
    }
}
