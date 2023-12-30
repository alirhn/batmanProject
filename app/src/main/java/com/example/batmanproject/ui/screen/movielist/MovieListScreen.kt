package com.task.movie.ui.screen.movielist

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.AsyncImage
import com.task.movie.R
import com.task.movie.base.BaseUiState
import com.task.movie.data.model.Movie
import com.task.movie.ui.component.MovieDefaultErrorView
import com.task.movie.ui.component.MovieDefaultLoadingView
import com.task.movie.ui.component.clickableWithoutRipple
import com.task.movie.ui.screen.movielist.model.MovieListState
import com.task.movie.ui.theme.MovieTheme

@Preview
@Composable
fun SplashScreenPreview() {
    MovieTheme {
        MovieListScreen(
            state = fakeMovieListState,
            navigateToMovieDetail = {}
        )
    }
}

private val fakeMovie = Movie(
    id = "tt18689424",
    title = "Batman v Superman: Dawn of Justice (Ultimate Edition)",
    year = "2016",
    type = "movie",
    poster = ""
)

private val fakeMovieListState = MovieListState(
    movieList = BaseUiState(
        isLoading = false,
        data = listOf(
            fakeMovie
        ),
        errorMessage = null
    )
)


@Composable
fun MovieListScreen(
    state: MovieListState,
    navigateToMovieDetail: (String) -> Unit
) {

    val showLoading by remember(
        state.movieList.isLoading,
    ) {
        derivedStateOf {
            state.movieList.isLoading
        }
    }

    val showData by remember(
        state.movieList.data,
    ) {
        derivedStateOf {
            state.movieList.data != null
        }
    }

    val showError by remember(
        state.movieList.errorMessage,
    ) {
        derivedStateOf {
            state.movieList.errorMessage != null
        }
    }

    when {
        showLoading -> {
            MovieDefaultLoadingView()
        }

        showData -> {
            state.movieList.data?.let { movies ->
                MovieListContent(
                    movies = movies,
                    navigateToMovieDetail = navigateToMovieDetail
                )
            }
        }

        showError -> {
            MovieDefaultErrorView()
        }
    }


}

@Composable
fun MovieListContent(
    movies: List<Movie>,
    navigateToMovieDetail: (String) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(
            items = movies,
            key = { it.id }
        ) { movie ->
            MovieItem(
                movie = movie,
                navigateToMovieDetail = navigateToMovieDetail
            )
        }
    }
}

@Composable

fun MovieItem(
    movie: Movie,
    navigateToMovieDetail: (String) -> Unit,
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 8.dp,
                vertical = 8.dp
            ),
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        border = BorderStroke(
            width = 1.dp,
            color = MaterialTheme.colorScheme.onBackground
        )
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .height(140.dp)
                .background(color = MaterialTheme.colorScheme.background)
                .clickableWithoutRipple { navigateToMovieDetail(movie.id) }
        ) {

            val (titleText, yearText, posterImage) = createRefs()

            AsyncImage(
                modifier = Modifier
                    .constrainAs(posterImage) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        height = Dimension.fillToConstraints
                    }
                    .aspectRatio(ratio = 0.7f),
                model = movie.poster,
                contentDescription = null,
                contentScale = ContentScale.FillWidth
            )

            Text(
                modifier = Modifier
                    .constrainAs(titleText) {
                        start.linkTo(posterImage.end)
                        end.linkTo(parent.end)
                        top.linkTo(parent.top)
                        width = Dimension.fillToConstraints
                    }
                    .padding(horizontal = 8.dp)
                    .padding(top = 8.dp),
                text = movie.title,
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = 18.sp,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
            )

            Text(
                modifier = Modifier
                    .constrainAs(yearText) {
                        start.linkTo(posterImage.end)
                        end.linkTo(parent.end)
                        top.linkTo(titleText.bottom)
                        width = Dimension.fillToConstraints
                    }
                    .padding(horizontal = 8.dp)
                    .padding(top = 8.dp),
                text = stringResource(id = R.string.year_of_movie, movie.year),
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = 18.sp,
            )

        }
    }

}