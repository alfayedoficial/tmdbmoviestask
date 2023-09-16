package com.alialfayed.tmdbmoviestask.data

import android.content.Context
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingConfig
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.runner.AndroidJUnit4
import com.alialfayed.tmdbmoviestask.data.local.database.AppDatabase
import com.alialfayed.tmdbmoviestask.data.local.deo.MovieDao
import com.alialfayed.tmdbmoviestask.data.local.model.MovieEntity
import com.alialfayed.tmdbmoviestask.data.remote.api.ApiService
import com.alialfayed.tmdbmoviestask.data.remote.mediator.MoviesRemoteMediator
import com.alialfayed.tmdbmoviestask.data.remote.model.MovieDto
import com.alialfayed.tmdbmoviestask.data.remote.model.PopularMovesResponse
import com.google.common.truth.Truth.assertThat
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
@OptIn(ExperimentalPagingApi::class)
class MoviesRemoteMediatorTest {

    @MockK
    lateinit var apiService: ApiService
    lateinit var movieDao: MovieDao
    lateinit var sut: MoviesRemoteMediator //system under test
    private val fakeMovie = MovieDto(
        id = 323,
        overview = "Test OverView",
        original_language  = null,
        original_title = null,
        video = null,
        title = "Title",
        popularity = null,
        adult = null,
    )
    private val list = listOf(
        fakeMovie,
        fakeMovie,
        fakeMovie,
        fakeMovie,
        fakeMovie
    )


    @Before
    fun setup() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val appDatabase = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
        movieDao = appDatabase.movieDao()
        MockKAnnotations.init(this)
        sut = MoviesRemoteMediator(apiService, appDatabase)
    }


    @Test
    fun `refresh Load Returns SuccessResult When More Data Is Present`()= runTest {
        //give
        coEvery {
            apiService.getPopularMoviesApi(any() , any())
        }returns PopularMovesResponse(page = null, total_pages = null, results =list.toMutableList(), total_results = null)

        val pagingState = PagingState<Int, MovieEntity>(
            listOf(),
            null,
            PagingConfig(10),
            10
        )

        val result = sut.load(LoadType.REFRESH, pagingState)
        assertThat(result).isInstanceOf(RemoteMediator.MediatorResult.Success::class.java)
        assertThat((result as RemoteMediator.MediatorResult.Success).endOfPaginationReached).isFalse()
    }

    @Test
    fun `refresh Load Returns Error Result When Error Occurs`() = runTest {
        coEvery {
            apiService.getPopularMoviesApi(any() , any())
        } throws IOException()

        val pagingState = PagingState<Int, MovieEntity>(
            listOf(),
            null,
            PagingConfig(10),
            10
        )

        val result = sut.load(LoadType.REFRESH, pagingState)
        assertThat(result).isInstanceOf(RemoteMediator.MediatorResult.Error::class.java)

    }
}