package com.levog.flapp.ui.screens.authentication.authentication

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class AuthenticationViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(AuthenticationState())
    val uiState: StateFlow<AuthenticationState> = _uiState.asStateFlow()

    var errorMessage by mutableStateOf("")
        private set

    fun updateErrorMessage(updateErrorMessage: String){
        errorMessage = updateErrorMessage
    }
    /*
    fun resetErrorMessage(){
        errorMessage = ""
    }
    fun updateErrorMessageFieldsIsNotFilled(){
        errorMessage = "Не все поля заполнены"
    }
    fun updateErrorMessageApiError(){
        errorMessage = context.getString(R.string.error_message_connection_api)
    }

     */

    fun updateUsername(updateUsername: String){
        updateErrorMessage("")
        _uiState.update { currentState ->
            currentState.copy(
                username = updateUsername
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

    fun updatePassword(updatePassword: String){
        updateErrorMessage("")
        _uiState.update { currentState ->
            currentState.copy(
                password = updatePassword
            )
        }
    }
    fun fieldsIsNotFilled():Boolean{
        return _uiState.value.username.equals("")||uiState.value.password.equals("")
    }


}