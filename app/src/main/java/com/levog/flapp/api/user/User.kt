package com.levog.flapp.api.user

data class User(
    val userId: Long,
    val username: String,
    val passwordHash: String,
    val email: String,
    val height: Double,
    val weight: Double,
    val date: String,
    val enabled: Boolean,
    val password: String,
    val authorities: String,
    val accountNonExpired: Boolean,
    val accountNonLocked: Boolean,
    val credentialsNonExpired: Boolean
)
