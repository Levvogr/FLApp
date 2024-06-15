package com.levog.flapp.navigation.navgraph

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.levog.flapp.navigation.destinations.NavigationGraphRoute
import com.levog.flapp.navigation.destinations.ScreenRoute
import com.levog.flapp.ui.screens.authentication.authentication.AuthenticationScreen
import com.levog.flapp.ui.screens.authentication.registration.RegistrationScreen
import com.levog.flapp.ui.screens.authentication.registration.RegistrationViewModel

fun NavGraphBuilder.authenticationGraph(
    navController: NavHostController,
    registrationViewModel: RegistrationViewModel
){
    navigation(
        startDestination = ScreenRoute.AuthenticationGraph.Authentication.route,
        route = NavigationGraphRoute.Authentication.route
    ) {
        composable(
            route = ScreenRoute.AuthenticationGraph.Authentication.route
        ) {
            AuthenticationScreen(
                goToHomeScreen = {
                    navController.navigate(NavigationGraphRoute.Home.route){
                        popUpTo(ScreenRoute.AuthenticationGraph.Authentication.route){
                            inclusive = true
                        }
                    }
                    registrationViewModel.updateAllInputElementsToDefault()
                },
                goToRegistrationScreen = {
                    navController.navigate(ScreenRoute.AuthenticationGraph.Registration.route)
                }
            )
        }
        composable(
            route = ScreenRoute.AuthenticationGraph.Registration.route
        ) {
            RegistrationScreen(
                goToHomeScreen = {
                    navController.navigate(NavigationGraphRoute.Home.route) {
                        popUpTo(ScreenRoute.AuthenticationGraph.Authentication.route){
                            inclusive = true
                        }
                    }
                    registrationViewModel.updateAllInputElementsToDefault()
                },
                goToAuthenticationScreen = {
                    navController.popBackStack()
                    /*
                    navController.navigate(ScreenRoute.AuthenticationGraph.Authentication.route) {
                        popUpTo(ScreenRoute.AuthenticationGraph.Authentication.route){
                            inclusive = true
                        }
                    }

                     */
                },
                registrationViewModel = registrationViewModel
            )
        }
    }
}