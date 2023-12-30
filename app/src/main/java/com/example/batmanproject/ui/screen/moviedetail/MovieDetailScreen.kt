package com.task.movie.ui.screen.moviedetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.task.movie.R
import com.task.movie.base.BaseUiState
import com.task.movie.data.model.MovieDetail
import com.task.movie.data.model.Rating
import com.task.movie.ui.component.MovieDefaultErrorView
import com.task.movie.ui.component.MovieDefaultLoadingView
import com.task.movie.ui.screen.moviedetail.model.MovieDetailState
import com.task.movie.ui.theme.MovieTheme

@Preview
@Composable
fun SplashScreenPreview() {
    MovieTheme {
        MovieDetailScreen(
            state = fakeMovieDetailState,
        )
    }
}

private val fakeRating = Rating(
    source = "Metacritic",
    value = "70/100"
)

private val fakeMoveDetail = MovieDetail(
    title = "Batman Begins",
    year = "2005",
    rated = "PG-13",
    released = "15 Jun 2005",
    runtime = "140 min",
    genre = "Action, Crime, Drama",
    director = "Christopher Nolan",
    writer = "Bob Kane, David S. Goyer, Christopher Nolan",
    actors = "Christian Bale, Michael Caine, Ken Watanabe",
    plot = "After witnessing his parents' death, Bruce learns the art of fighting to confront injustice. When he returns to Gotham as Batman, he must stop a secret society that intends to destroy the city.",
    language = "English, Mandarin",
    country = "United States, United Kingdom",
    awards = "Nominated for 1 Oscar. 14 wins & 79 nominations total",
    poster = "",
    metaScore = "70",
    imdbRating = "8.2",
    imdbVotes = "1,517,479",
    imdbID = "tt0372784",
    type = "movie",
    dvd = "09 Sep 2009",
    boxOffice = "$206,863,479",
    ratings = listOf(fakeRating),
)

private val fakeMovieDetailState = MovieDetailState(
    BaseUiState(
        isLoading = false,
        data = fakeMoveDetail,
        errorMessage = null
    )
)

@Composable
fun MovieDetailScreen(
    state: MovieDetailState,
) {

    val showLoading by remember(
        state.movieDetail.isLoading,
    ) {
        derivedStateOf {
            state.movieDetail.isLoading
        }
    }

    val showData by remember(
        state.movieDetail.data,
    ) {
        derivedStateOf {
            state.movieDetail.data != null
        }
    }

    val showError by remember(
        state.movieDetail.errorMessage,
    ) {
        derivedStateOf {
            state.movieDetail.errorMessage != null
        }
    }

    when {
        showLoading -> {
            MovieDefaultLoadingView()
        }

        showData -> {
            state.movieDetail.data?.let { movieDetail ->
                MovieDetailContent(movieDetail = movieDetail)
            }
        }

        showError -> {
            MovieDefaultErrorView()
        }
    }

}

@Composable
fun MovieDetailContent(
    movieDetail: MovieDetail,
) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        item {
            MovieDetailContentPoster(poster = movieDetail.poster)
        }

        item {
            MovieDetailContentProperties(movieDetail = movieDetail)
        }

        item {
            MovieDetailContentRatings(ratings = movieDetail.ratings)
        }

        item {
            Spacer(modifier = Modifier.height(100.dp))
        }

    }

}

@Composable
fun MovieDetailContentPoster(poster: String) {

    AsyncImage(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1.6f),
        model = poster,
        contentDescription = null,
        contentScale = ContentScale.Crop
    )

}

@Composable
fun MovieDetailContentProperties(
    movieDetail: MovieDetail
) {

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        MovieDetailContentProperty(
            title = stringResource(id = R.string.title),
            description = movieDetail.title
        )

        MovieDetailContentProperty(
            title = stringResource(id = R.string.year),
            description = movieDetail.year
        )

        MovieDetailContentProperty(
            title = stringResource(id = R.string.rated),
            description = movieDetail.rated
        )

        MovieDetailContentProperty(
            title = stringResource(id = R.string.released),
            description = movieDetail.released
        )

        MovieDetailContentProperty(
            title = stringResource(id = R.string.runtime),
            description = movieDetail.runtime
        )

        MovieDetailContentProperty(
            title = stringResource(id = R.string.genre),
            description = movieDetail.genre
        )

        MovieDetailContentProperty(
            title = stringResource(id = R.string.director),
            description = movieDetail.director
        )

        MovieDetailContentProperty(
            title = stringResource(id = R.string.writer),
            description = movieDetail.writer
        )

        MovieDetailContentProperty(
            title = stringResource(id = R.string.actors),
            description = movieDetail.actors
        )

        MovieDetailContentProperty(
            title = stringResource(id = R.string.plot),
            description = movieDetail.plot
        )

        MovieDetailContentProperty(
            title = stringResource(id = R.string.language),
            description = movieDetail.language
        )

        MovieDetailContentProperty(
            title = stringResource(id = R.string.country),
            description = movieDetail.country
        )

        MovieDetailContentProperty(
            title = stringResource(id = R.string.awards),
            description = movieDetail.awards
        )

        MovieDetailContentProperty(
            title = stringResource(id = R.string.meta_score),
            description = movieDetail.metaScore
        )

        MovieDetailContentProperty(
            title = stringResource(id = R.string.imdb_rating),
            description = movieDetail.imdbRating
        )

        MovieDetailContentProperty(
            title = stringResource(id = R.string.imdb_votes),
            description = movieDetail.imdbVotes
        )

        MovieDetailContentProperty(
            title = stringResource(id = R.string.dvd),
            description = movieDetail.dvd
        )


        MovieDetailContentProperty(
            title = stringResource(id = R.string.box_office),
            description = movieDetail.boxOffice
        )

    }

}

@Composable
fun MovieDetailContentProperty(
    title: String,
    description: String,
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 8.dp,
                vertical = 8.dp
            )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = title,
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.Start
            )

            Text(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .weight(3f),
                text = description,
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.Start
            )
        }

        Divider(
            modifier = Modifier
                .fillMaxWidth(),
            thickness = 1.dp,
            color = MaterialTheme.colorScheme.primary
        )

    }


}

@Composable
fun MovieDetailContentRatings(ratings: List<Rating>) {

    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        text = stringResource(id = R.string.ratings),
        color = MaterialTheme.colorScheme.primary,
        fontSize = 18.sp,
        textAlign = TextAlign.Center
    )

    ratings.forEach { rating ->
        MovieDetailContentRatingItem(rating = rating)
    }
}

@Composable
fun MovieDetailContentRatingItem(rating: Rating) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 8.dp,
                vertical = 8.dp
            )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = rating.source,
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.Start
            )

            Text(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .weight(1f),
                text = rating.value,
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.Start
            )
        }

        Divider(
            modifier = Modifier
                .fillMaxWidth(),
            thickness = 1.dp,
            color = MaterialTheme.colorScheme.primary
        )

    }

}

