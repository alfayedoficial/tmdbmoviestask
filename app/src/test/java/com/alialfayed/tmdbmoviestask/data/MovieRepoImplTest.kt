package com.alialfayed.tmdbmoviestask.data

import android.content.Context
import androidx.paging.DifferCallback
import androidx.paging.ExperimentalPagingApi
import androidx.paging.NullPaddedList
import androidx.paging.Pager
import androidx.paging.PagingData
import androidx.paging.PagingDataDiffer
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.runner.AndroidJUnit4
import app.cash.turbine.test
import com.alialfayed.tmdbmoviestask.data.local.database.AppDatabase
import com.alialfayed.tmdbmoviestask.data.local.deo.MovieDao
import com.alialfayed.tmdbmoviestask.data.local.model.MovieEntity
import com.alialfayed.tmdbmoviestask.domain.model.Movie
import com.google.common.truth.Truth.assertThat
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MovieRepoImplTest {


    @MockK
    lateinit var pager: Pager<Int, MovieEntity>
    lateinit var movieDao: MovieDao
    lateinit var sut: MovieRepoImpl //system under test
    private val fakeMovie = MovieEntity(
        primaryKey = 4384,
        id = 323,
        overview = "Test OverView",
        originalLanguage = null,
        originalTitle = null,
        video = null,
        title = "Title",
        posterPath = null,
        backdropPath = null,
        releaseDate = null,
        popularity = null,
        voteAverage = null,
        adult = null,
        voteCount = null,
        page = 3077
    )

    @Before
    fun setup() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val appDatabase = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
        movieDao = appDatabase.movieDao()
        MockKAnnotations.init(this)
        sut = MovieRepoImpl(movieDao, pager)
    }


    @Test
    fun `given existing id, when call getMovieDetailsById then return Movie `() = runTest {
        // given
        movieDao.upsertAll(listOf(fakeMovie))

        // when
        val actualMovie = sut.getMovieDetailsById(323)

        //then
        assertThat(actualMovie).isNotNull()
    }

    @Test
    fun `given not existing id, when call getMovieDetailsById then return null `() = runTest {
        //given
        val id = 300

        // when
        val actualMovie = sut.getMovieDetailsById(id)

        //then
        assertThat(actualMovie).isNull()
    }


    @Test
    fun `given list when call  getPopularMoviesPagingFlow then return flow paging data`() = runTest {
        //given
        val list = listOf(
            fakeMovie,
            fakeMovie.apply {
                primaryKey = 4385
                id = 324
            },
            fakeMovie.apply {
                primaryKey = 4386
                id = 325
            },
            fakeMovie.apply {
                primaryKey = 4387
                id = 326
            },
        )

        //when
        coEvery {
            pager.flow
        } returns flow { emit(PagingData.from(list)) }

        sut.getPopularMoviesPagingFlow().test {
            val pagingData: PagingData<Movie> = awaitItem()
            val movie = pagingData.collectDataForTest().firstOrNull()
            assertThat(movie).isNotNull()
            cancelAndIgnoreRemainingEvents()
        }
    }


    private suspend fun <T : Any> PagingData<T>.collectDataForTest(): List<T> {
        val dcb = object : DifferCallback {
            override fun onChanged(position: Int, count: Int) {}
            override fun onInserted(position: Int, count: Int) {}
            override fun onRemoved(position: Int, count: Int) {}
        }
        val items = mutableListOf<T>()
        val dif = object : PagingDataDiffer<T>(dcb, UnconfinedTestDispatcher()) {

            override suspend fun presentNewList(
                previousList: NullPaddedList<T>,
                newList: NullPaddedList<T>,
                lastAccessedIndex: Int,
                onListPresentable: () -> Unit
            ): Int? {
                for (idx in 0 until newList.size)
                    items.add(newList.getFromStorage(idx))
                onListPresentable()
                return null
            }
        }
        dif.collectFrom(this)
        return items
    }

    @After
    fun tearDown() = runTest {
        movieDao.clearAll()
    }

}