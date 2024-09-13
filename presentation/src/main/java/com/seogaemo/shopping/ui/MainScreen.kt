package com.seogaemo.shopping.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.seogaemo.shopping.ui.theme.ShoppingTheme
import com.seogaemo.shopping.viewmodel.MainViewModel

sealed class MainNavigationItem(val route: String, val icon: ImageVector, val name: String) {
    data object Main: MainNavigationItem("Main", Icons.Filled.Home,"Main")
    data object Category: MainNavigationItem("Category", Icons.Filled.Star,"Category")
    data object MyPage: MainNavigationItem("MyPage", Icons.Filled.AccountBox,"MyPage")
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ShoppingTheme {
        MainScreen()
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val viewModel = hiltViewModel<MainViewModel>()
    Scaffold(
        topBar = {
            Header(viewModel)
        },
        bottomBar = {
            MainBottomNavigationBar(navController)
        },

    ) { innerPadding ->
        MainNavigationScreen(navController, innerPadding)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Header(viewModel: MainViewModel) {
    TopAppBar(title = { Text(text = "My App") }, actions = {
        IconButton(onClick = { viewModel.openSearchForm() }) {
            Icon(Icons.Filled.Search, "search icon")
        }
    })
}

@Composable
fun MainBottomNavigationBar(navController: NavController) {
    val bottomNavigationItems = listOf(
        MainNavigationItem.Main,
        MainNavigationItem.Category,
        MainNavigationItem.MyPage
    )
    NavigationBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        bottomNavigationItems.forEach { item ->
            NavigationBarItem(
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let {
                            popUpTo(it) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                icon = {
                    Icon(item.icon, item.name)
                }
            )
        }
    }
}

@Composable
fun MainNavigationScreen(navigationController: NavHostController, innerPadding: PaddingValues) {
    NavHost(navController = navigationController, startDestination = MainNavigationItem.Main.route) {
        composable(MainNavigationItem.Main.route) {
            Text(text = "Hello Main")
        }
        composable(MainNavigationItem.Category.route) {
            Text(text = "Hello Category")
        }
        composable(MainNavigationItem.MyPage.route) {
            Text(text = "Hello MyPage")
        }
    }
}

