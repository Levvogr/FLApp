package com.levog.flapp.navigation.destinations

sealed class ArgumentsRoute(val argument: String) {
    sealed class MedicalExaminationGraph {
        object MedicalExaminationDetails : ArgumentsRoute(argument = "id")
    }
}