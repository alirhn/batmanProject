package com.task.movie.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.Dp
import com.task.movie.R

object Dimens {

    val StatusBarSize: Dp
        @Composable get() = dimensionResource(id = R.dimen.dp_24)

    val Dp_0: Dp
        @Composable get() = dimensionResource(id = R.dimen.dp_0)

    val Dp_2: Dp
        @Composable get() = dimensionResource(R.dimen.dp_2)

}