package com.levog.flapp.ui.screens.authentication.authentication

data class AuthenticationState (
    val password: String = "",
    val username: String = "",
    val isVisiblePassword: Boolean = false,
    val enabledUsernameField: Boolean = true,
    val enabledPasswordField: Boolean = true,
    val enabledAuthenticationButton: Boolean = true,
    val enabledGoToRegistrationButton: Boolean = true,
)