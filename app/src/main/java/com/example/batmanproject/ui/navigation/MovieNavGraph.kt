package com.task.movie.ui.navigation

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.task.movie.presentation.MovieDetailViewModel
import com.task.movie.presentation.MovieListViewModel
import com.task.movie.presentation.SplashViewModel
import com.task.movie.ui.screen.moviedetail.MovieDetailScreen
import com.task.movie.ui.screen.movielist.MovieListScreen
import com.task.movie.ui.screen.splash.SplashScreen
import kotlinx.coroutines.CoroutineScope

@Composable
fun MovieNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    startDestination: String = MovieDestinations.SPLASH_ROUTE,
    navAction: MovieNavigationActions = remember(navController) {
        MovieNavigationActions(navController)
    }
) {

    val currentNavBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentNavBackStackEntry?.destination?.route ?: startDestination
    val activity = LocalContext.current as Activity

    NavHost(
        modifier = modifier, navController = navController, startDestination = startDestination
    ) {

        splashScreen(
            builder = this,
            navAction = navAction,
        )

        movieListScreen(
            builder = this,
            navAction = navAction,
        )

        movieDetailScreen(
            builder = this
        )

    }

}

fun splashScreen(
    builder: NavGraphBuilder,
    navAction: MovieNavigationActions,
) {
    builder.apply {
        composable(
            route = MovieDestinations.SPLASH_ROUTE
        ) { entry ->

            val viewModel = hiltViewModel<SplashViewModel>()
            val state by viewModel.uiState.collectAsState()

            SplashScreen(
                state = state,
                navigateToNextScreen = {
                    navAction.navigatesToMovieList()
                },
            )
        }
    }
}

fun movieListScreen(
    builder: NavGraphBuilder,
    navAction: MovieNavigationActions,
) {
    builder.apply {
        composable(
            route = MovieDestinations.MOVIE_LIST_ROUTE
        ) { entry ->

            val viewModel = hiltViewModel<MovieListViewModel>()
            val state by viewModel.uiState.collectAsState()

            MovieListScreen(
                state = state,
                navigateToMovieDetail = { movieId ->
                    navAction.navigatesToMovieDetail(movieId)
                }
            )
        }
    }
}

fun movieDetailScreen(
    builder: NavGraphBuilder,
){
    builder.apply {
        composable(
            route = MovieDestinations.MOVIE_DETAIL_ROUTE
        ) { entry ->
            val viewModel = hiltViewModel<MovieDetailViewModel>()
            val state by viewModel.uiState.collectAsState()

            MovieDetailScreen(state = state)
        }
    }
}


