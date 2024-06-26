package com.levog.flapp.api.authentication

import com.levog.flapp.api.authentication.Token
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface AuthenticationApi {

    @Headers(
        "Content-Type: application/json"
    )
    @POST("in/auth")
    suspend fun authorisation(@Body authorisationRequest: AuthorisationRequest): Token

    @Headers(
        "Content-Type: application/json"
    )
    @POST("in/register")
    suspend fun registration(@Body registrationRequest: RegistrationRequest): Token
}