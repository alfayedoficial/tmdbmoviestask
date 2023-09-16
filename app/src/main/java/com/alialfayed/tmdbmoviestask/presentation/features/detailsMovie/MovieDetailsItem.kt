package com.alialfayed.tmdbmoviestask.presentation.features.detailsMovie

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import com.alialfayed.tmdbmoviestask.domain.model.Movie
import com.alialfayed.tmdbmoviestask.presentation.features.homeScreen.RatingStar
import com.alialfayed.tmdbmoviestask.theme.TMDbMoviesTaskTheme
import com.alialfayed.tmdbmoviestask.utils.getImageUrl

@Composable
fun MovieDetailsItem(movie: Movie , modifier: Modifier = Modifier) {

    Column(
        modifier = modifier.padding(10.dp)
        .verticalScroll(rememberScrollState())

    ) {

        Box(
            modifier = Modifier
                .wrapContentSize()
                .height(280.dp)
                .align(Alignment.CenterHorizontally)
        ) {

            SubcomposeAsyncImage(
                loading = {
                    CircularProgressIndicator()
                },
                model = getImageUrl(movie.posterPath ?: ""),
                contentDescription = movie.overview,
                modifier = Modifier
                    .wrapContentSize()
                    .clip(shape = RoundedCornerShape(9.dp)),
                contentScale = ContentScale.Fit
            )

            Box(
                modifier = Modifier
                    .wrapContentSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black.copy(alpha = 0.1f),
                                Color.Black.copy(alpha = 0.6f),
                                Color.Black.copy(alpha = 0.9f),
                            ),
                            startY = 0f,
                            endY = Float.POSITIVE_INFINITY
                        )
                    )
            )
        }

        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = movie.title?:"",
            color = Color.DarkGray,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 30.sp
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = movie.voteAverage.toString(),
            color = Color.Gray,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(5.dp))

        Text(
            text = "Release Date: ${movie.releaseDate}",
            modifier = Modifier.padding(top = 4.dp),
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal
            )
        )
        // Rate
        RatingStar(movie.voteAverage ?: 0f , Color.Black)

        Spacer(modifier = Modifier.height(5.dp))

        Column {
            if (movie.overview != null) {
                Text(text = movie.overview)
            }
        }
    }


}

@Preview
@Composable
fun ItemPreview() {
    TMDbMoviesTaskTheme {
        MovieDetailsItem(
            movie = Movie(
                id = 1,
                title = "Barbie (2023)",
                releaseDate = "2023-07-19",
                overview= "Barbie and Ken are having the time of their lives in the colorful and seemingly perfect world of Barbie Land. However, when they get a chance to go to the real world, they soon discover the joys and perils of living among humans.",
                posterPath = "https://www.themoviedb.org/t/p/w1280/iuFNMS8U5cb6xfzi51Dbkovj7vM.jpg" ,
                voteAverage = 8f
            ),
            modifier = Modifier.fillMaxWidth()
        )
    }
}