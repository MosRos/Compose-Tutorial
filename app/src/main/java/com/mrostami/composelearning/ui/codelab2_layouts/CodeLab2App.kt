package com.mrostami.composelearning.ui.codelab2_layouts

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.mrostami.composelearning.ui.theme.AppTheme

@Composable
fun CodeLab2App() {
    AppTheme(darkMode = false) {
        BottomNavigationMainScreenView()
    }
}

@Preview
@Composable
fun AppContent() {
    Scaffold(
        Modifier.background(color = AppTheme.colors.background),
        topBar = {
            TopAppBar(
                backgroundColor = AppTheme.colors.surface,
                title = {
                    Text(
                        text = "Hi",
                        color = AppTheme.colors.textPrimary,
                        style = AppTheme.typography.title
                    )
                },
                actions = {
                    IconButton(onClick = { }) {
                        Icon(
                            Icons.Filled.Favorite,
                            tint = AppTheme.colors.icon,
                            contentDescription = null
                        )
                    }
                }
            )
        },
        bottomBar = {
            var selectedItem by remember { mutableStateOf(HomeSections.HOME.route) }

            CodeLabBottomNav(
                tabs = arrayOf(
                    HomeSections.FEED,
                    HomeSections.HOME,
                    HomeSections.SEARCH,
                    HomeSections.PROFILE
                ),
                currentRoute = selectedItem,
                navigateToRoute = { route ->
                    selectedItem = route
                },
                backgroundColor = AppTheme.colors.surface
            )
//            BottomNavigation (
//                backgroundColor = AppTheme.colors.primary,
//                elevation = AppTheme.dimensions.appBarElevation
//                    ){
//
//            }
        }
    ) { innerPAdding ->
        BodyContent(Modifier.padding(innerPAdding))
    }
}

@Composable
fun BodyContent(modifier: Modifier = Modifier) {
    PhotographerCard()
}

@Composable
fun PhotographerCard(modifier: Modifier = Modifier) {
    Row(
        modifier
            .fillMaxWidth()
            .padding(all = AppTheme.dimensions.paddingMedium)
            .clip(shape = AppTheme.shapes.medium)
            .background(color = AppTheme.colors.surface)
            .clickable(onClick = {})
            .padding(all = AppTheme.dimensions.paddingLarge)
    ) {
        Surface(
            modifier = Modifier.size(64.dp),
            shape = CircleShape,
            color = AppTheme.colors.elementBackground
        ) {
            Image(
                painter = rememberImagePainter(
                    data = "https://developer.android.com/images/brand/Android_Robot.png"
                ),
                modifier = Modifier.clip(CircleShape),
                contentDescription = null
            )
        }
        Column(
            modifier = Modifier
                .padding(start = AppTheme.dimensions.paddingMedium)
                .align(Alignment.CenterVertically)
        ) {
            Text(text = "Alfred Sisley", style = AppTheme.typography.title)
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                Text(text = "3 minutes ago", style = AppTheme.typography.body)
            }
        }
    }
}

//@Preview
@Composable
fun PhotographerCardPreview() {
    AppTheme {
        PhotographerCard()
    }
}