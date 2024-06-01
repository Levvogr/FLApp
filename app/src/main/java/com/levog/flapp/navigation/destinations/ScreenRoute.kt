package com.levog.flapp.navigation.destinations

sealed class ScreenRoute(val route: String){
    sealed class HomeGraph(){
        object Home : ScreenRoute(route = "home_screen")
        object Profile : ScreenRoute(route = "profile_screen")
        object Settings : ScreenRoute(route = "settings_screen")
    }
    sealed class AuthenticationGraph(){
        object Authentication : ScreenRoute(route = "authentication_screen")
        object Registration : ScreenRoute(route = "registration_screen")
    }
    sealed class MedicalExaminationGraph(){
        object MedicalExaminationList : ScreenRoute(route = "medical_examination_list_screen")
        object MedicalExaminationDetails : ScreenRoute(route = "medical_examination_details_screen")
        object MedicalExaminationAppointment : ScreenRoute(route = "medical_examination_appointment_screen")
    }
    sealed class HealthSleepGraph(){
        object HealthSleepStart : ScreenRoute(route = "health_sleep_start_screen")
        object HealthSleepDuration : ScreenRoute(route = "health_sleep_duration_screen")
        object HealthSleepSchedule : ScreenRoute(route = "health_sleep_schedule_screen")
    }
}