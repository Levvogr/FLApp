package com.levog.flapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.levog.flapp.navigation.destinations.NavigationGraphRoute
import com.levog.flapp.navigation.navgraph.RootGraph

@Composable
fun AppNavigation(
){
    val navController = rememberNavController()
    RootGraph(
        navController = navController,
        startDestination = NavigationGraphRoute.Home.route
    )
}