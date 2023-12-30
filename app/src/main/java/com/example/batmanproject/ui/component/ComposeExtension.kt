package com.task.movie.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed

fun Modifier.clickableWithoutRipple(
    onClick: () -> Unit
) = composed {
    val interactionSource= remember { MutableInteractionSource() }
    this.clickable(
        interactionSource = interactionSource,
        indication = null
    ) {
        onClick()
    }
}
