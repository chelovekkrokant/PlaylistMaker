package com.github.chelovekkrokant.playlistmaker.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.github.chelovekkrokant.playlistmaker.ui.screens.MainScreen
import com.github.chelovekkrokant.playlistmaker.ui.screens.SearchScreen
import com.github.chelovekkrokant.playlistmaker.ui.screens.SettingsScreen

@Composable
fun PlaylistHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screens.MAIN.route
    ) {
        composable(Screens.MAIN.route) {
            MainScreen(
                onSearchClick = { navController.navigate(Screens.SEARCH.route) },
                onSettingsClick = { navController.navigate(Screens.SETTINGS.route) },
                )
        }
        composable(Screens.SETTINGS.route) {
            SettingsScreen(
                onBackClick = { navController.navigate(Screens.MAIN.route) },
            )
        }
        composable(Screens.SEARCH.route) {
            SearchScreen(
                onBackClick = { navController.navigate(Screens.MAIN.route) },
            )
        }
    }
}