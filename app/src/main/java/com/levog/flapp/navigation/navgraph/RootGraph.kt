package com.levog.flapp.navigation.navgraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.levog.flapp.navigation.destinations.NavigationGraphRoute

@Composable
fun RootGraph(
    navController: NavHostController,
    startDestination: String = NavigationGraphRoute.Home.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        route = NavigationGraphRoute.Root.route
    ) {
        homeGraph(navController)
        authenticationGraph(navController)
        healthSleepGraph(navController)
        medicalExaminationGraph(navController)
    }
}