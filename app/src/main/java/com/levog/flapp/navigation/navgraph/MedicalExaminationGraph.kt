package com.levog.flapp.navigation.navgraph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.levog.flapp.navigation.destinations.ArgumentsRoute
import com.levog.flapp.navigation.destinations.NavigationGraphRoute
import com.levog.flapp.navigation.destinations.ScreenRoute
import com.levog.flapp.ui.screens.medicalexamination.appointment.MedicalExaminationAppointmentScreen
import com.levog.flapp.ui.screens.medicalexamination.details.MedicalExaminationDetailsScreen
import com.levog.flapp.ui.screens.medicalexamination.list.MedicalExaminationListScreen
import com.levog.flapp.ui.screens.medicalexamination.start.MedicalExaminationStartScreen

fun NavGraphBuilder.medicalExaminationGraph(
    navController: NavHostController
){
    navigation(
        startDestination = ScreenRoute.MedicalExaminationGraph.MedicalExaminationStart.route,
        route = NavigationGraphRoute.MedicalExamination.route
    ) {
        composable(
            route = ScreenRoute.MedicalExaminationGraph.MedicalExaminationStart.route
        ){
            MedicalExaminationStartScreen(
                goToHomeScreen = {
                    navController.popBackStack()
                },
                goToDetailsScreen = {
                    navController.navigate(ScreenRoute.MedicalExaminationGraph.MedicalExaminationDetails.route+
                            "/$it")
                },
                goToAppointmentScreen = {
                    navController.navigate(ScreenRoute.MedicalExaminationGraph.MedicalExaminationAppointment.route)
                },
                goToListScreen = {
                    navController.navigate(ScreenRoute.MedicalExaminationGraph.MedicalExaminationList.route)
                })
        }
        composable(
            route = ScreenRoute.MedicalExaminationGraph.MedicalExaminationList.route
        ) {
            MedicalExaminationListScreen(
                goToStartScreen={
                    navController.popBackStack()
                },
                goToDetailsScreen={
                    navController.navigate(ScreenRoute.MedicalExaminationGraph.MedicalExaminationDetails.route+
                            "/$it")
                },
                goToAppointmentScreen={
                    navController.navigate(ScreenRoute.MedicalExaminationGraph.MedicalExaminationAppointment.route)
                }
            )
        }
        composable(
            route = ScreenRoute.MedicalExaminationGraph.MedicalExaminationDetails.route +
                    "/{${ArgumentsRoute.MedicalExaminationGraph.MedicalExaminationDetails.argument}}",
            arguments = listOf(navArgument(
                ArgumentsRoute.MedicalExaminationGraph.MedicalExaminationDetails.argument
            ) {
                type = NavType.IntType
            })
        ) {
            MedicalExaminationDetailsScreen(
                goToBack={
                    navController.popBackStack()
                }
            )
        }
        composable(
            route = ScreenRoute.MedicalExaminationGraph.MedicalExaminationAppointment.route
        ) {
            MedicalExaminationAppointmentScreen(
                goToBack={
                    navController.popBackStack()
                }
            )
        }
    }
}