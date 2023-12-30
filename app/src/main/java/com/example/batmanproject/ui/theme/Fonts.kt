package com.task.movie.ui.theme

import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import com.task.movie.R

object Fonts {

    val kalamehFamily = FontFamily(
        Font(R.font.kalameh_fa_num_regular, FontWeight.Normal),
        Font(R.font.kalameh_fa_num_bold, FontWeight.Bold),
        Font(R.font.kalameh_fa_num_thin, FontWeight.Thin),
        Font(R.font.kalameh_fa_num_black, FontWeight.Black),
    )

    val kalamehFaFamily = FontFamily(
        Font(R.font.kalameh_regular, FontWeight.Normal),
        Font(R.font.kalameh_bold, FontWeight.Bold),
        Font(R.font.kalameh_thin, FontWeight.Thin),
        Font(R.font.kalameh_black, FontWeight.Black),
    )

    val kalamehEnFamily = FontFamily(
        Font(R.font.kalameh_en_num_regular, FontWeight.Normal),
        Font(R.font.kalameh_en_num_bold, FontWeight.Bold),
        Font(R.font.kalameh_en_num_thin, FontWeight.Thin),
        Font(R.font.kalameh_en_num_black, FontWeight.Black),
    )

}

val defaultTextStyle = TextStyle(
    fontFamily = Fonts.kalamehFaFamily,
    platformStyle = PlatformTextStyle(
        includeFontPadding = false
    ),
    lineHeightStyle = LineHeightStyle(
        alignment = LineHeightStyle.Alignment.Center,
        trim = LineHeightStyle.Trim.None
    )
)


