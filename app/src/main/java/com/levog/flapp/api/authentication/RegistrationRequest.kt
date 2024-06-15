package com.levog.flapp.api.authentication

data class RegistrationRequest(
    val username: String,
    val email: String,
    val password: String
)
