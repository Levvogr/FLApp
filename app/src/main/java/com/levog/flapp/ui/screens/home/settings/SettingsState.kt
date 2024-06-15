package com.levog.flapp.ui.screens.home.settings

data class SettingsState(
    val displayThemeDialog: Boolean = false,
    val displayNotificationSleepDialog: Boolean = false,
    val displayNotificationMedicalExaminationDialog: Boolean = false,
    val theme: String = "",
    val notificationSleep: String = "",
    val notificationMedicalExamination: String = "",
)