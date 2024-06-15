package com.levog.flapp.ui.screens.medicalexamination.appointment

data class MedicalExaminationAppointmentState(
    val medicalOrganization: String = "",
    val dateMedicalExamination: String = "",
    val timeMedicalExamination: String = "",
    val expandedOrganizationDropdownMenu: Boolean = false,
    val expandedTimeDropdownMenu: Boolean = false,
    val displayCalendar: Boolean = false,
    val enabledAndVisibilityDateField: Boolean = false,
    val enabledAndVisibilityTimeField: Boolean = false,
    val enabledAndVisibilityAppointmentButton: Boolean = false,
)