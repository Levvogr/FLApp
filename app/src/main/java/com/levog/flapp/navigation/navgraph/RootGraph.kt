package com.levog.flapp.navigation.navgraph

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.levog.flapp.navigation.destinations.NavigationGraphRoute
import com.levog.flapp.ui.screens.authentication.registration.RegistrationViewModel

@Composable
fun RootGraph(
    navController: NavHostController,
    startDestination: String = NavigationGraphRoute.Home.route
) {
    //Инициализируется здесь, а не в RegistrationScreen
    // так как доступ к RegistrationViewModel нужен во всей области
    // подграфа authenticationGraph
    val registrationViewModel: RegistrationViewModel = viewModel()
    NavHost(
        navController = navController,
        startDestination = startDestination,
        route = NavigationGraphRoute.Root.route
    ) {
        homeGraph(navController)
        authenticationGraph(navController, registrationViewModel)
        healthSleepGraph(navController)
        medicalExaminationGraph(navController)
    }
}