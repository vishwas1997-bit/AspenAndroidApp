package com.aspen_android_app.navigation

sealed class AspenScreen(val route: String) {
    data object AspenIntroScreen : AspenScreen(AspenScreenNameConstant.ASPEN_INTRO_SCREEN)
    data object AspenDashBoardScreen : AspenScreen(AspenScreenNameConstant.ASPEN_DASHBOARD_SCREEN)
}


object AspenScreenNameConstant {
    const val ASPEN_INTRO_SCREEN = "aspen_intro_screen"
    const val ASPEN_DASHBOARD_SCREEN = "aspen_dashboard_screen"
}