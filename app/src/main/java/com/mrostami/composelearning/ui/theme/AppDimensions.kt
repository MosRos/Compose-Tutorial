package com.mrostami.composelearning.ui.theme

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class AppDimensions(
    val marginSmall: Dp = 10.dp,
    val marginMedium: Dp = 12.dp,
    val marginLarge: Dp = 24.dp,
    val paddingSmall: Dp = 4.dp,
    val paddingMedium: Dp = 8.dp,
    val paddingLarge: Dp = 12.dp,

    val appBarElevation: Dp = 2.dp,
    val textIconSpacing: Dp = 2.dp,
    val bottomNavHeight: Dp = 56.dp,
)

internal val LocalDimensions = staticCompositionLocalOf { AppDimensions() }
