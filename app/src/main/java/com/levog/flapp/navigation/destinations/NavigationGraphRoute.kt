package com.levog.flapp.navigation.destinations

sealed class NavigationGraphRoute(val route: String){
    object Root : NavigationGraphRoute(route = "root_graph")
    object Home : NavigationGraphRoute(route = "home_graph")
    object Authentication : NavigationGraphRoute(route = "authentication_graph")
    object MedicalExamination : NavigationGraphRoute(route = "medical_examination_graph")
    object HealthSleep : NavigationGraphRoute(route = "health_sleep_graph")
}
