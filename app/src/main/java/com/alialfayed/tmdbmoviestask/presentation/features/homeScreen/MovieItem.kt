package com.alialfayed.tmdbmoviestask.presentation.features.homeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator

import androidx.compose.material3.Icon

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush.Companion.verticalGradient
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage
import com.alialfayed.tmdbmoviestask.domain.model.Movie
import com.alialfayed.tmdbmoviestask.theme.TMDbMoviesTaskTheme
import com.alialfayed.tmdbmoviestask.utils.getImageUrl


@Composable
fun MovieItem(
    movie: Movie,
    modifier: Modifier = Modifier,
    onClick: (Int) -> Unit) {
    Card(
        shape = RoundedCornerShape(9.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = modifier
            .padding(horizontal = 10.dp, vertical = 5.dp)
    ) {

        Box(modifier = Modifier.clickable { onClick(movie.id!!) }) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(280.dp)
            ) {
                SubcomposeAsyncImage(
                    loading = {
                        CircularProgressIndicator()
                    },
                    model = getImageUrl(movie.posterPath ?: ""),
                    contentDescription = movie.overview,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(shape = RoundedCornerShape(9.dp)),
                    contentScale = ContentScale.FillWidth
                )

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            brush = verticalGradient(
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

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .align(Alignment.BottomStart)
                    .padding(16.dp)
            ) {
                Column {
                    // Movie Title
                    Text(
                        text = movie.title.toString(),
                        modifier = Modifier.fillMaxWidth(),
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    // Release Date
                    Text(
                        text = "Release Date: ${movie.releaseDate}",
                        modifier = Modifier.padding(top = 4.dp),
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Normal
                        )
                    )
                    // Rate
                    RatingStar(movie.voteAverage ?: 0f)
                }
            }
        }
    }
}
@Composable
fun RatingStar(rating: Float , colorTxt:Color = Color.White ) {
    val starColor = Color(0xFFDAA520)

    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            imageVector = Icons.Default.Star,
            contentDescription = null,
            tint = starColor,
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = rating.toString(),
            modifier = Modifier.padding(start = 8.dp),
            style = TextStyle( color = colorTxt,fontSize = 16.sp)
        )
    }
}

@Preview
@Composable
fun ItemPreview() {
    TMDbMoviesTaskTheme {
        MovieItem(
            movie = Movie(
                id = 1,
                title = "Barbie (2023)",
                releaseDate = "2023-07-19",
                overview= "Barbie and Ken are having the time of their lives in the colorful and seemingly perfect world of Barbie Land. However, when they get a chance to go to the real world, they soon discover the joys and perils of living among humans.",
                posterPath = "https://www.themoviedb.org/t/p/w1280/iuFNMS8U5cb6xfzi51Dbkovj7vM.jpg" ,
                voteAverage = 8f
            ),
            modifier = Modifier.fillMaxWidth() ,
            onClick = {

            }
        )
    }
}