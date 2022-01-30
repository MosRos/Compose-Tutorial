package com.mrostami.composelearning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import com.mrostami.composelearning.ui.codelab1_basics.CodeLabApp
import com.mrostami.composelearning.ui.codelab2_layouts.BottomNavigationMainScreenView
import com.mrostami.composelearning.ui.codelab2_layouts.CodeLab2App
import com.mrostami.composelearning.ui.theme.AppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme(darkMode = false) {
                Surface(color = AppTheme.colors.background) {
//                    ComposeBasicsApp()
//                    CodeLabApp()
                    CodeLab2App()
                }
            }
        }
    }
}

