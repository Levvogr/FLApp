package com.levog.flapp.ui.screens.home.home

data class HomeState(
    val isAuthenticated: Boolean = false,
    val enabledExaminationButton: Boolean = false,
    val enabledSleepButton: Boolean = false,
    val enabledProfileButton: Boolean = false,
    val enabledSettingsButton: Boolean = false,
)
