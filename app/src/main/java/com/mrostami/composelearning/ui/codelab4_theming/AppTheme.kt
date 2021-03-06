package com.mrostami.composelearning.ui.codelab4_theming

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.runtime.*
import com.mrostami.composelearning.ui.theme.AppShapes

object AppTheme {

    val colors: AppColors
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current

    val typography: AppTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current

    val dimensions: AppDimensions
        @Composable
        @ReadOnlyComposable
        get() = LocalDimensions.current

    val shapes: Shapes
        @Composable
        @ReadOnlyComposable
        get() = AppShapes
}

@Composable
fun AppTheme(
    darkMode: Boolean = true,
    typography: AppTypography = AppTheme.typography,
    dimensions: AppDimensions = AppTheme.dimensions,
    shapes: Shapes = AppTheme.shapes,
    content: @Composable () -> Unit
) {
    val themeColors =
        if (darkMode)
            appDarkColors()
        else
            appLightColors()

    val materialThemeColors =
        if (darkMode)
            DarkColorPalette2
        else
            LightColorPalette2
    // Explicitly creating a new object here so we don't mutate the initial [colors]
    // provided, and overwrite the values set in it.
//    val rememberedColors = remember { themeColors.copy() }.apply { updateColorsFrom(themeColors) }
    CompositionLocalProvider(
        LocalColors provides themeColors,
        LocalDimensions provides dimensions,
        LocalTypography provides typography,
        staticCompositionLocalOf { AppShapes } provides shapes
    ) {
        MaterialTheme(
            colors = materialThemeColors,
            shapes = AppShapes,
            content = content
        )
//        content()
    }
}

val MaterialTheme.appColors: AppColors
    @Composable
    @ReadOnlyComposable
    get() = LocalColors.current