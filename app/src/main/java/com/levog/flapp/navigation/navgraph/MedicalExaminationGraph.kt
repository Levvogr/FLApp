package com.levog.flapp.navigation.navgraph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.levog.flapp.navigation.destinations.NavigationGraphRoute
import com.levog.flapp.navigation.destinations.ScreenRoute
import com.levog.flapp.ui.screens.medicalexamination.appointment.MedicalExaminationAppointmentScreen
import com.levog.flapp.ui.screens.medicalexamination.details.MedicalExaminationDetailsScreen
import com.levog.flapp.ui.screens.medicalexamination.list.MedicalExaminationListScreen

fun NavGraphBuilder.medicalExaminationGraph(
    navController: NavHostController
){
    navigation(
        startDestination = ScreenRoute.MedicalExaminationGraph.MedicalExaminationList.route,
        route = NavigationGraphRoute.MedicalExamination.route
    ) {
        composable(
            route = ScreenRoute.MedicalExaminationGraph.MedicalExaminationList.route
        ) {
            MedicalExaminationListScreen(
                goToHomeScreen={
                    navController.navigate(NavigationGraphRoute.Home.route) {
                        popUpTo(NavigationGraphRoute.Home.route){
                            inclusive = true
                        }
                    }
                },
                goToDetailsScreen={
                    navController.navigate(ScreenRoute.MedicalExaminationGraph.MedicalExaminationDetails.route)
                },
                goToAppointmentScreen={
                    navController.navigate(ScreenRoute.MedicalExaminationGraph.MedicalExaminationAppointment.route)
                }
            )
        }
        composable(
            route = ScreenRoute.MedicalExaminationGraph.MedicalExaminationDetails.route
        ) {
            MedicalExaminationDetailsScreen(
                goToListScreen={
                    navController.navigate(ScreenRoute.MedicalExaminationGraph.MedicalExaminationList.route){
                        popUpTo(ScreenRoute.MedicalExaminationGraph.MedicalExaminationList.route){
                            inclusive = true
                        }
                    }
                }
            )
        }
        composable(
            route = ScreenRoute.MedicalExaminationGraph.MedicalExaminationAppointment.route
        ) {
            MedicalExaminationAppointmentScreen(
                goToListScreen={
                    navController.navigate(ScreenRoute.MedicalExaminationGraph.MedicalExaminationList.route){
                        popUpTo(ScreenRoute.MedicalExaminationGraph.MedicalExaminationList.route){
                            inclusive = true
                        }
                    }
                }
            )
        }
    }
}