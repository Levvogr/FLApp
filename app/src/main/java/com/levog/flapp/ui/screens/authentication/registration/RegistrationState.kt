package com.levog.flapp.ui.screens.authentication.registration

data class RegistrationState (
    val username: String = "",
    val email: String = "",
    val password: String = "",
    val isVisiblePassword: Boolean = false,
    val enabledUsernameField: Boolean = true,
    val enabledEmailField: Boolean = true,
    val enabledPasswordField: Boolean = true,
    val enabledRegistrationButton: Boolean = true,
    val enabledGoToAuthenticationButton: Boolean = true,
)