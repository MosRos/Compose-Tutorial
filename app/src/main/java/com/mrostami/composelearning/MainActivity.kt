package com.mrostami.composelearning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import com.mrostami.composelearning.ui.codelab1.CodeLabApp
import com.mrostami.composelearning.ui.theme.AppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme(darkMode = false) {
                Surface(color = AppTheme.colors.background) {
//                    ComposeBasicsApp()
                    CodeLabApp()
                }
            }
        }
    }
}

