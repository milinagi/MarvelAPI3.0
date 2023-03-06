package com.example.marvelapi30.navigation

sealed class AppScreens(val route: String) {
    object SplashScreen: AppScreens("splash_screen")
    object MainScreen: AppScreens("main_screen")
    object CharactersScreen: AppScreens("character_screen")
    object ComicsScreen: AppScreens("comics_screen")
    object SeriesScreen: AppScreens("series_screen")
}