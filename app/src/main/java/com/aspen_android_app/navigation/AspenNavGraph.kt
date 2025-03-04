package com.aspen_android_app.navigation

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aspen_android_app.screen.AspenDashboard
import com.aspen_android_app.screen.AspenIntro

@Composable
fun AspenNavGraph() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = AspenScreen.AspenIntroScreen.route) {
        composable(
            route = AspenScreenNameConstant.ASPEN_INTRO_SCREEN
        ) {
            AspenIntro(navigateToDashboard = {
                navController.navigate(AspenScreen.AspenDashBoardScreen.route)
            })
        }

        composable(route = AspenScreenNameConstant.ASPEN_DASHBOARD_SCREEN) {
            AspenDashboard()
        }
    }
}