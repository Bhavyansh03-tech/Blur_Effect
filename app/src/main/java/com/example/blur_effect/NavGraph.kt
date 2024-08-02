package com.example.blur_effect

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavGraph(
    navController: NavHostController,
) {
    NavHost(navController = navController, startDestination = "firstScreen") {
        composable("firstScreen") {
            MainScreen(navController)
        }
        composable("secondScreen") {
            SecondScreen()
        }
    }
}