package com.mrostami.composelearning.ui.home

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
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.mrostami.composelearning.ui.codelab2_layouts.BodyContent
import com.mrostami.composelearning.ui.codelab2_layouts.CodeLabBottomNav
import com.mrostami.composelearning.ui.codelab2_layouts.HomeSections
import com.mrostami.composelearning.ui.codelab4_theming.AppTheme
import com.mrostami.composelearning.ui.codelab4_theming.appColors

@Composable
fun HomeLayoutScreen() {

    var tabState by remember { mutableStateOf(HomeTabs.Home) }

    Scaffold(
        Modifier
            .padding(top = 50.dp)
            .background(color = MaterialTheme.appColors.background)
            .fillMaxSize(),
        topBar = {
            TopAppBar(
                backgroundColor = MaterialTheme.appColors.background,
                title = {
                    Text(
                        text = "Hi",
                        color = MaterialTheme.appColors.textPrimary,
                        style = AppTheme.typography.title
                    )
                },
                actions = {
                    IconButton(onClick = { }) {
                        Icon(
                            Icons.Filled.Favorite,
                            tint = MaterialTheme.appColors.icon,
                            contentDescription = null
                        )
                    }
                }
            )
        }
    ) { innerPAdding ->
        Box(modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.appColors.background)
        ){
            HomeContent(
                selectedTab = tabState,
                modifier = Modifier.padding(innerPAdding)
            )
        }
    }
}

@Composable
fun HomeContent(
    selectedTab: HomeTabs,
    modifier: Modifier = Modifier
) {
    PhotographerCard()
}

@Composable
fun PhotographerCard(modifier: Modifier = Modifier) {
    Row(
        modifier
            .fillMaxWidth()
            .padding(all = AppTheme.dimensions.paddingMedium)
            .clip(shape = AppTheme.shapes.medium)
            .background(color = MaterialTheme.appColors.surface)
            .clickable(onClick = {})
            .padding(all = AppTheme.dimensions.paddingLarge)
    ) {
        Surface(
            modifier = Modifier.size(64.dp),
            shape = CircleShape,
            color = MaterialTheme.appColors.elementBackground
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