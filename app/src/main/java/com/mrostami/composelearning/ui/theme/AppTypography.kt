package com.mrostami.composelearning.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.mrostami.composelearning.R


private val raleWayFamily = FontFamily(
    Font(R.font.raleway_light, FontWeight.Light),
    Font(R.font.raleway_regular, FontWeight.Normal),
    Font(R.font.raleway_medium, FontWeight.Medium),
    Font(R.font.raleway_semibold, FontWeight.SemiBold)
)

data class AppTypography(
    val h1: TextStyle = TextStyle(
        fontFamily = raleWayFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp
    ),
    val subtitle: TextStyle = TextStyle(
        fontFamily = raleWayFamily,
        fontWeight = FontWeight.Light,
        fontSize = 13.sp
    ),
    val body: TextStyle = TextStyle(
        fontFamily = raleWayFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    val button: TextStyle = TextStyle(
        fontFamily = raleWayFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 15.sp
    ),
    val caption: TextStyle = TextStyle(
        fontFamily = raleWayFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp
    ),
    val title: TextStyle = TextStyle(
        fontFamily = raleWayFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp
    )
)

internal val LocalTypography = staticCompositionLocalOf { AppTypography() }
