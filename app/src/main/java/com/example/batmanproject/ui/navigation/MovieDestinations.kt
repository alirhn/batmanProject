package com.task.movie.ui.navigation

object MovieDestinations {
    const val SPLASH_ROUTE = MovieScreen.SPLASH_SCREEN
    const val MOVIE_LIST_ROUTE = MovieScreen.MOVIE_LIST_SCREEN
    const val MOVIE_DETAIL_ROUTE =
        "${MovieScreen.MOVIE_DETAIL_SCREEN}/{${MovieDestinationsArgs.MOVIE_ID_ARG}}"
}