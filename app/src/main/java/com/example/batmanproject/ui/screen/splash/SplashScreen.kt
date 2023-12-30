package com.task.movie.ui.screen.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.task.movie.R
import com.task.movie.ui.screen.splash.model.SplashState
import com.task.movie.ui.theme.MovieTheme

@Preview
@Composable
fun SplashScreenPreview() {
    MovieTheme {
        SplashScreen(
            state = fakeSplashState,
            navigateToNextScreen = {},
        )
    }
}

private val fakeSplashState = SplashState(
    finishSplashScreen = false
)

@Composable
fun SplashScreen(
    state: SplashState,
    navigateToNextScreen: () -> Unit,
) {

    LaunchedEffect(key1 = state.finishSplashScreen) {
        if (state.finishSplashScreen) {
            navigateToNextScreen()
        }
    }

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = MaterialTheme.colorScheme.primary
            )
    ) {

        val (appname) = createRefs()

        Text(
            modifier = Modifier.constrainAs(appname) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
            },
            text = stringResource(id = R.string.app_name),
            fontSize = 30.sp,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold
        )

    }

}