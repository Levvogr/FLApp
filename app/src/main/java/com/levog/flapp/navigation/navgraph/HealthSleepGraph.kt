package com.levog.flapp.navigation.navgraph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.levog.flapp.navigation.destinations.NavigationGraphRoute
import com.levog.flapp.navigation.destinations.ScreenRoute
import com.levog.flapp.ui.screens.healthsleep.duration.DurationSleepScreen
import com.levog.flapp.ui.screens.healthsleep.schedule.ScheduleSleepScreen
import com.levog.flapp.ui.screens.healthsleep.start.StartHealthSleepScreen

fun NavGraphBuilder.healthSleepGraph(
    navController: NavHostController
){
    navigation(
        startDestination = ScreenRoute.HealthSleepGraph.HealthSleepStart.route,
        route = NavigationGraphRoute.HealthSleep.route
    ) {
        composable(
            route = ScreenRoute.HealthSleepGraph.HealthSleepStart.route
        ) {
            StartHealthSleepScreen(
                goToHomeScreen={
                    navController.navigate(NavigationGraphRoute.Home.route) {
                        popUpTo(NavigationGraphRoute.Home.route){
                            inclusive = true
                        }
                    }
                },
                goToScheduleScreen={
                    navController.navigate(ScreenRoute.HealthSleepGraph.HealthSleepSchedule.route)
                },
                goToDurationScreen={
                    navController.navigate(ScreenRoute.HealthSleepGraph.HealthSleepDuration.route)
                }
            )
        }
        composable(
            route = ScreenRoute.HealthSleepGraph.HealthSleepSchedule.route
        ) {
            ScheduleSleepScreen(
                goToStartScreen={
                    navController.navigate(ScreenRoute.HealthSleepGraph.HealthSleepStart.route){
                        popUpTo(ScreenRoute.HealthSleepGraph.HealthSleepStart.route){
                            inclusive = true
                        }
                    }
                },
                goToDurationScreen={
                    navController.navigate(ScreenRoute.HealthSleepGraph.HealthSleepDuration.route){
                        popUpTo(ScreenRoute.HealthSleepGraph.HealthSleepStart.route){
                            inclusive = false
                        }
                    }
                }
            )
        }
        composable(
            route = ScreenRoute.HealthSleepGraph.HealthSleepDuration.route
        ) {
            DurationSleepScreen(
                goToStartScreen={
                    navController.navigate(ScreenRoute.HealthSleepGraph.HealthSleepStart.route){
                        popUpTo(ScreenRoute.HealthSleepGraph.HealthSleepStart.route){
                            inclusive = true
                        }
                    }
                },
                goToScheduleScreen={
                    navController.navigate(ScreenRoute.HealthSleepGraph.HealthSleepSchedule.route){
                        popUpTo(ScreenRoute.HealthSleepGraph.HealthSleepStart.route){
                            inclusive = false
                        }
                    }
                }
            )
        }
    }
}