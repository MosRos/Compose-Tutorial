package com.mrostami.composelearning.ui.config

import androidx.appcompat.app.AppCompatDelegate

object AppConfig {
    enum class ThemeState(mode: Int) {
        LIGHT(mode = AppCompatDelegate.MODE_NIGHT_NO),
        DARK(mode = AppCompatDelegate.MODE_NIGHT_YES),
        SYSTEM(mode = AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
    }
    var darkModeState: ThemeState = ThemeState.LIGHT
}