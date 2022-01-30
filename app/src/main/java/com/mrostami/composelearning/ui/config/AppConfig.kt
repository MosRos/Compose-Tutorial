package com.mrostami.composelearning.ui.config

import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.unit.dp

object AppConfig {
    enum class ThemeState(mode: Int) {
        LIGHT(mode = AppCompatDelegate.MODE_NIGHT_NO),
        DARK(mode = AppCompatDelegate.MODE_NIGHT_YES),
        SYSTEM(mode = AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
    }
    var darkModeState: ThemeState = ThemeState.LIGHT

    val BottomNavLabelTransformOrigin = TransformOrigin(0f, 0.5f)
    private val BottomNavIndicatorShape = RoundedCornerShape(percent = 50)
    private val BottomNavigationItemPadding = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
}