package com.mrostami.composelearning.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.mrostami.composelearning.ui.codelab2_layouts.PostsList
import com.mrostami.composelearning.ui.codelab2_layouts.TopicsGrid
import com.mrostami.composelearning.ui.codelab3_state.ToDoLayoutScreen
import com.mrostami.composelearning.ui.codelab3_state.ToDoViewModel
import com.mrostami.composelearning.ui.home.HomeLayoutScreen
import com.mrostami.composelearning.ui.theme.AppTheme

enum class BottomNavItem(
    var title: String,
    var icon: ImageVector,
    var screen_route: String
    ) {

    Home("Home", Icons.Rounded.Home, "home"),
    ToDo("ToDo", Icons.Rounded.Task, "to_do"),
    Feeds("Feeds", Icons.Rounded.RssFeed, "feeds_list"),
    Topics("Topics", Icons.Rounded.Topic, "topics"),
//    Jobs("Jobs", Icons.Rounded.Work, "jobs")
}

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = AppTheme.colors.background)
            .wrapContentSize(align = Alignment.Center)
    ) {
        HomeLayoutScreen()
    }
}

@Composable
fun ToDoScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = AppTheme.colors.background)
            .wrapContentSize(align = Alignment.Center)
    ) {
        ToDoLayoutScreen(viewModel = hiltViewModel<ToDoViewModel>())
    }
}

@Composable
fun FeedsScreen() {
    Box(
        modifier = Modifier
            .padding(bottom = AppTheme.dimensions.bottomNavHeight)
            .fillMaxSize()
            .background(color = AppTheme.colors.background)
            .wrapContentSize(align = Alignment.Center)
    ) {
//        Text(
//            text = "Add Post Screen",
//            style = AppTheme.typography.title,
//            color = AppTheme.colors.textPrimary,
//            modifier = Modifier.align(Alignment.CenterHorizontally),
//            textAlign = TextAlign.Center,
//            fontSize = 20.sp
//        )
        PostsList()
    }
}


@Composable
fun TopicsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = AppTheme.colors.background)
            .wrapContentSize(align = Alignment.Center)
    ) {
        TopicsGrid()
    }
}


@Composable
fun JobScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = AppTheme.colors.background)
            .wrapContentSize(align = Alignment.Center)
    ) {
        Text(
            text = "Jobs Screen",
            style = AppTheme.typography.title,
            color = AppTheme.colors.textPrimary,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 20.sp
        )
    }
}

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = BottomNavItem.Home.screen_route) {
        composable(BottomNavItem.Home.screen_route) {
            HomeScreen()
        }
        composable(BottomNavItem.ToDo.screen_route) {
            ToDoScreen()
        }
        composable(BottomNavItem.Feeds.screen_route) {
            FeedsScreen()
        }
        composable(BottomNavItem.Topics.screen_route) {
            TopicsScreen()
        }
//        composable(BottomNavItem.Jobs.screen_route) {
//            JobScreen()
//        }
    }
}


@Composable
fun BottomNavigation(navController: NavController) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.ToDo,
        BottomNavItem.Feeds,
        BottomNavItem.Topics,
//        BottomNavItem.Jobs
    )
    androidx.compose.material.BottomNavigation(
        backgroundColor = AppTheme.colors.surface,
        contentColor = AppTheme.colors.success
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(rememberVectorPainter(item.icon), contentDescription = item.title) },
                label = {
                    Text(
                        text = item.title,
                        fontSize = 9.sp,
                        maxLines = 1
                    )
                },
                selectedContentColor = AppTheme.colors.primary,
                unselectedContentColor = AppTheme.colors.icon,
                alwaysShowLabel = false,
                selected = currentRoute == item.screen_route,
                onClick = {
                    navController.navigate(item.screen_route) {

                        navController.graph.startDestinationRoute?.let { screen_route ->
                            popUpTo(screen_route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Composable
fun BottomNavigationMainScreenView() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigation(navController = navController) }
    ) {

        NavigationGraph(navController = navController)
    }
}