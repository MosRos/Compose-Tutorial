package com.mrostami.composelearning.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.mrostami.composelearning.ui.codelab1_basics.CodeLabApp
import com.mrostami.composelearning.ui.codelab2_layouts.CodeLab2App
import com.mrostami.composelearning.ui.codelab4_theming.AppTheme
import com.mrostami.composelearning.ui.codelab4_theming.appColors
import com.mrostami.composelearning.ui.navigation.BottomNavigationMainScreenView
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme(darkMode = true) {
                Surface(color = MaterialTheme.appColors.background) {
//                    ComposeBasicsApp()
//                    CodeLabApp()
                    BottomNavigationMainScreenView()
                }
            }
        }
    }
}

