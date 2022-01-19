package com.mrostami.composelearning.ui.theme

import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

class AppColors (
    // Default Material colors
    primary: Color,
    primaryVariant: Color,
    secondary: Color,
    secondaryVariant: Color,
    background: Color,
    surface: Color,
    error: Color,
    onPrimary: Color,
    onSecondary: Color,
    onBackground: Color,
    onSurface: Color,
    onError: Color,
    // Our custom colors
    divider: Color,
    hint: Color,
    icon: Color,
    elementBackground: Color,
    elementBorder: Color,
    textPrimary: Color,
    textSecondary: Color,
    success: Color,
    isLight: Boolean,
) {
    var primary by mutableStateOf(primary)
        private set
    var primaryVariant by mutableStateOf(primaryVariant)
        private set
    var secondary by mutableStateOf(secondary)
        private set
    var secondaryVariant by mutableStateOf(secondaryVariant)
        private set
    var background by mutableStateOf(background)
        private set
    var surface by mutableStateOf(surface)
        private set
    var error by mutableStateOf(error)
        private set
    var onPrimary by mutableStateOf(onPrimary)
        private set
    var onSecondary by mutableStateOf(onSecondary)
        private set
    var onBackground by mutableStateOf(onBackground)
        private set
    var onSurface by mutableStateOf(onSurface)
        private set
    var onError by mutableStateOf(onError)
        private set

    var divider by mutableStateOf(divider)
        private set
    var hint by mutableStateOf(hint)
        private set
    var icon by mutableStateOf(icon)
        private set
    var elementBackground by mutableStateOf(elementBackground)
        private set
    var elementBorder by mutableStateOf(elementBorder)
        private set
    var textSecondary by mutableStateOf(textSecondary)
        private set
    var textPrimary by mutableStateOf(textPrimary)
        private set
    var success by mutableStateOf(success)
        private set

    var isLight by mutableStateOf(isLight)
        internal set

    fun copy(
        primary: Color = this.primary,
        primaryVariant: Color = this.primaryVariant,
        secondary: Color = this.secondary,
        secondaryVariant: Color = this.secondaryVariant,
        background: Color = this.background,
        surface: Color = this.surface,
        error: Color = this.error,
        onPrimary: Color = this.onPrimary,
        onSecondary: Color = this.onSecondary,
        onBackground: Color = this.onBackground,
        onSurface: Color = this.onSurface,
        onError: Color = this.onError,
        divider: Color = this.divider,
        hint: Color  = this.hint,
        icon: Color = this.icon,
        elementBackground: Color = this.elementBackground,
        elementBorder: Color = this.elementBorder,
        textPrimary: Color = this.textPrimary,
        textSecondary: Color = this.textSecondary,
        success: Color = this.success,

        isLight: Boolean = this.isLight
    ): AppColors = AppColors(
        primary = primary,
        primaryVariant = primaryVariant,
        secondary = secondary,
        secondaryVariant = secondaryVariant,
        background = background,
        surface = surface,
        error = error,
        onPrimary = onPrimary,
        onSecondary = onSecondary,
        onBackground = onBackground,
        onSurface = onSurface,
        onError = onError,
        divider = divider,
        hint = hint,
        icon = icon,
        elementBackground = elementBackground,
        elementBorder = elementBorder,
        textPrimary = textPrimary,
        textSecondary = textSecondary,
        success = success,

        isLight = isLight
    )

    fun updateColorsFrom(other: AppColors) {
        primary = other.primary
        primaryVariant = other.primaryVariant
        secondary = other.secondary
        secondaryVariant = other.secondaryVariant
        background = other.background
        surface = other.surface
        error = other.error
        onPrimary = other.onPrimary
        onSecondary= other.onSecondary
        onBackground = other.onBackground
        onSurface = other.onSurface
        onError = other.onError
        divider = other.divider
        icon = other.icon
        hint = other.hint
        elementBackground = other.elementBackground
        elementBorder = other.elementBorder
        textPrimary = other.textPrimary
        textSecondary = other.textSecondary
        success = other.success
        isLight = other.isLight
    }
}

private val colorLightPrimary = Color(0xFFFFB400)
private val colorLightPrimaryVariant = Color(0xFFF0AE11)
private val colorLightSecondary = Color(0xFF00796B)
private val colorLightSecondaryVariant = Color(0xFF00796B)
private val colorLightBackground = Color(0xFFF7F8FA)
private val colorLightSurface = Color(0xFFF3F7F7)
private val colorLightError = Color(0xFFA20E0E)
private val colorLightOnPrimary = Color(0xFFE6EEED)
private val colorLightOnSecondary = Color(0xFFE6EEED)
private val colorLightOnBackground = Color(0xFF212222)
private val colorLightOnSurface = Color(0xFF212222)
private val colorLightOnError = Color(0xFFF2F7F7)
private val colorLightDivider = Color(0xFF888B8B)
private val colorLightHint = Color(0xFF535555)
private val colorLightIcon = Color(0xFF505252)
private val colorLightElementBackground = Color(0xFFD7E0DF)
private val colorLightElementBorder = Color(0xFFD0D8D7)
private val colorLightTextPrimary = Color(0xFF222121)
private val colorLightTextSecondary = Color(0xFF4E4D4D)
private val colorLightSuccess = Color(0xFF0B7915)



private val colorDarkPrimary = Color(0xFFFFB300)
private val colorDarkPrimaryVariant = Color(0xFFF7B315)
private val colorDarkSecondary = Color(0xFF0ABEAA)
private val colorDarkSecondaryVariant = Color(0xFF0ABEAA)
private val colorDarkBackground = Color(0xFF1B1C1F)
private val colorDarkSurface = Color(0xFF2A2B30)
private val colorDarkError = Color(0xFFA20E0E)
private val colorDarkOnPrimary = Color(0xFFE6EEED)
private val colorDarkOnSecondary = Color(0xFFE6EEED)
private val colorDarkOnBackground = Color(0xFFE6EEED)
private val colorDarkOnSurface = Color(0xFFE6EEED)
private val colorDarkOnError = Color(0xFFF2F7F7)
private val colorDarkDivider = Color(0xFF6A6D6D)
private val colorDarkHint = Color(0xFF979B9B)
private val colorDarkIcon = Color(0xFF9B9E9E)
private val colorDarkElementBackground = Color(0xFF414247)
private val colorDarkElementBorder = Color(0xFF4C4D52)
private val colorDarkTextPrimary = Color(0xFFF5F2F2)
private val colorDarkTextSecondary = Color(0xFFCAC6C6)
private val colorDarkSuccess = Color(0xFF0B7915)

fun appLightColors(
    // Default Material colors
    primary: Color = colorLightPrimary,
    primaryVariant: Color = colorLightPrimaryVariant,
    secondary: Color = colorLightSecondary,
    secondaryVariant: Color = colorLightSecondaryVariant,
    background: Color = colorLightBackground,
    surface: Color = colorLightSurface,
    error: Color = colorLightError,
    onPrimary: Color = colorLightOnPrimary,
    onSecondary: Color = colorLightOnSecondary,
    onBackground: Color = colorLightOnBackground,
    onSurface: Color = colorLightOnSurface,
    onError: Color = colorLightOnError,
    // Our custom colors
    divider: Color = colorLightDivider,
    hint: Color = colorLightHint,
    icon: Color = colorLightIcon,
    elementBackground: Color = colorLightElementBackground,
    elementBorder: Color = colorLightElementBorder,
    textPrimary: Color = colorLightTextPrimary,
    textSecondary: Color = colorLightTextSecondary,
    success: Color = colorLightSuccess
): AppColors = AppColors(
    primary = primary,
    primaryVariant = primaryVariant,
    secondary = secondary,
    secondaryVariant = secondaryVariant,
    background = background,
    surface = surface,
    error = error,
    onPrimary =  onPrimary,
    onSecondary =  onSecondary,
    onBackground = onBackground,
    onSurface = onSurface,
    onError = onError,
    divider = divider,
    hint = hint,
    icon = icon,
    elementBackground = elementBackground,
    elementBorder = elementBorder,
    textPrimary = textPrimary,
    textSecondary = textSecondary,
    success = success,
    isLight = true
)

fun appDarkColors(
    // Default Material colors
    primary: Color = colorDarkPrimary,
    primaryVariant: Color = colorDarkPrimaryVariant,
    secondary: Color = colorDarkSecondary,
    secondaryVariant: Color = colorDarkSecondaryVariant,
    background: Color = colorDarkBackground,
    surface: Color = colorDarkSurface,
    error: Color = colorDarkError,
    onPrimary: Color = colorDarkOnPrimary,
    onSecondary: Color = colorDarkOnSecondary,
    onBackground: Color = colorDarkOnBackground,
    onSurface: Color = colorDarkOnSurface,
    onError: Color = colorDarkOnError,
    // Our custom colors
    divider: Color = colorDarkDivider,
    hint: Color = colorDarkHint,
    icon: Color = colorDarkIcon,
    elementBackground: Color = colorDarkElementBackground,
    elementBorder: Color = colorDarkElementBorder,
    textPrimary: Color = colorDarkTextPrimary,
    textSecondary: Color = colorDarkTextSecondary,
    success: Color = colorDarkSuccess
): AppColors = AppColors(
    primary = primary,
    primaryVariant = primaryVariant,
    secondary = secondary,
    secondaryVariant = secondaryVariant,
    background = background,
    surface = surface,
    error = error,
    onPrimary =  onPrimary,
    onSecondary =  onSecondary,
    onBackground = onBackground,
    onSurface = onSurface,
    onError = onError,
    divider = divider,
    hint = hint,
    icon = icon,
    elementBackground = elementBackground,
    elementBorder = elementBorder,
    textPrimary = textPrimary,
    textSecondary = textSecondary,
    success = success,
    isLight = false
)

val DarkColorPalette2 = darkColors(
    primary = appDarkColors().primary,
    primaryVariant = appDarkColors().primaryVariant,
    secondary = appDarkColors().secondary,

    //Other default colors to override
    background = appDarkColors().background,
    surface = appDarkColors().surface,
    onPrimary = appDarkColors().onPrimary,
    onSecondary = appDarkColors().onSecondary,
    onBackground = appDarkColors().onBackground,
    onSurface = appDarkColors().onSurface,

    // Text Colors

)

val LightColorPalette2 = lightColors(
    primary = appLightColors().primary,
    primaryVariant = appLightColors().primaryVariant,
    secondary = appLightColors().secondary,

    // Other default colors to override
    background = appLightColors().background,
    surface = appLightColors().surface,
    onPrimary = appLightColors().onPrimary,
    onSecondary = appLightColors().onSecondary,
    onBackground = appLightColors().onBackground,
    onSurface = appLightColors().onSurface,
)

var LocalColors = staticCompositionLocalOf { appLightColors() }