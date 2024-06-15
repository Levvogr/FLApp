package com.levog.flapp.ui.screens.authentication.registration

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class RegistrationViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(RegistrationState())
    val uiState: StateFlow<RegistrationState> = _uiState.asStateFlow()

    var isRegistered by mutableStateOf(false)
        private set

    fun updateFalseIsRegistered(){
        isRegistered = false
    }

    var errorMessage by mutableStateOf("")
        private set

    fun updateErrorMessage(updateErrorMessage: String){
        errorMessage = updateErrorMessage
    }

    fun updateAllInputElementsToDefault(){
        updateErrorMessage("")
        _uiState.update { currentState ->
            currentState.copy(
                username = "",
                email = "",
                password = "",
            )
        }
    }
    fun updateUsername(updateUsername: String){
        updateErrorMessage("")
        _uiState.update { currentState ->
            currentState.copy(
                username = updateUsername
            )
        }
    }
    fun updateEmail(updateEmail: String){
        updateErrorMessage("")
        _uiState.update { currentState ->
            currentState.copy(
                email = updateEmail
            )
        }
    }

    fun updatePassword(updatePassword: String){
        updateErrorMessage("")
        _uiState.update { currentState ->
            currentState.copy(
                password = updatePassword
            )
        }
    }
    fun inversionIsVisiblePassword(){
        _uiState.update { currentState ->
            currentState.copy(
                isVisiblePassword = !_uiState.value.isVisiblePassword
            )
        }
    }

    fun fieldsIsNotFilled():Boolean{
        return  _uiState.value.username.equals("")||
                _uiState.value.email.equals("")||
                _uiState.value.password.equals("")

    }
    fun registration(errorMessageConnectionApi: String){
        //эмуляция работы с api
        val sucssess = true
        blockAllElements()
        CoroutineScope(Dispatchers.IO).launch {
            delay(1000L)
            if(sucssess){
                isRegistered = true


                //для глобального состояния возможно это ошибочное решение
                //нужно найти что-то получше
                _uiState.update {
                    RegistrationState()
                }






            }else{
                errorMessage = errorMessageConnectionApi
                unblockAllElements()
            }
        }
        /* работа с api
        val client= RetrofitClient().getClient()
        val api=client.create(AuthenticationApi::class.java)
        CoroutineScope(Dispatchers.IO).launch {
            try {
                var token: String
                token = api.registration(
                    RegistrationRequest(
                        username = _uiState.value.username,
                        email = _uiState.value.email,
                        password = _uiState.value.password
                    )
                ).token
                isRegistered = true
            }
            catch (e: Exception) {
                isRegistered = false
                errorMessage = errorMessageConnectionApi
                unblockAllElements()
            }
        }

         */
    }
    fun blockAllElements(){
        _uiState.update { currentState ->
            currentState.copy(
                enabledUsernameField = false,
                enabledEmailField = false,
                enabledPasswordField = false,
                enabledRegistrationButton = false,
                enabledGoToAuthenticationButton = false
            )
        }
    }
    fun unblockAllElements(){
        _uiState.update { currentState ->
            currentState.copy(
                enabledUsernameField = true,
                enabledEmailField = true,
                enabledPasswordField = true,
                enabledRegistrationButton = true,
                enabledGoToAuthenticationButton = true
            )
        }
    }
}