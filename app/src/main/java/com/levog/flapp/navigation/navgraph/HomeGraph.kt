package com.levog.flapp.navigation.navgraph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.levog.flapp.navigation.destinations.NavigationGraphRoute
import com.levog.flapp.navigation.destinations.ScreenRoute
import com.levog.flapp.ui.screens.home.home.HomeScreen
import com.levog.flapp.ui.screens.home.profile.ProfileScreen
import com.levog.flapp.ui.screens.home.settings.SettingsScreen

fun NavGraphBuilder.homeGraph(
    navController: NavHostController
){
    navigation(
        startDestination = ScreenRoute.HomeGraph.Home.route,
        route = NavigationGraphRoute.Home.route
    ) {
        composable(
            route = ScreenRoute.HomeGraph.Home.route
        ) {
            HomeScreen(
                goToProfileScreen={
                    navController.navigate(ScreenRoute.HomeGraph.Profile.route)
                },
                goToSettingsScreen={
                    navController.navigate(ScreenRoute.HomeGraph.Settings.route)
                },
                goToMedicalExaminationScreen={
                    navController.navigate(NavigationGraphRoute.MedicalExamination.route)
                },
                goToHealthSleepScreen={
                    navController.navigate(NavigationGraphRoute.HealthSleep.route)
                }
            )
        }
        composable(
            route = ScreenRoute.HomeGraph.Profile.route
        ) {
            ProfileScreen(
                goToHomeScreen={
                    navController.navigate(ScreenRoute.HomeGraph.Home.route){
                        popUpTo(ScreenRoute.HomeGraph.Home.route){
                            inclusive = true
                        }
                    }
                },
                goToAuthenticationScreen={
                    navController.navigate(NavigationGraphRoute.Authentication.route){
                        popUpTo(ScreenRoute.HomeGraph.Home.route){
                            inclusive = true
                        }
                    }
                }
            )
        }
        composable(
            route = ScreenRoute.HomeGraph.Settings.route
        ) {
            SettingsScreen(
                goToHomeScreen={
                    navController.navigate(ScreenRoute.HomeGraph.Home.route){
                        popUpTo(ScreenRoute.HomeGraph.Home.route){
                            inclusive = true
                        }
                    }
                }
            )
        }
    }
}