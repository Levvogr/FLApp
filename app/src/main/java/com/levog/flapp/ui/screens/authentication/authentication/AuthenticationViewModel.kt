package com.levog.flapp.ui.screens.authentication.authentication

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.levog.flapp.data.protodatastore.MainDataStoreManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AuthenticationViewModel(): ViewModel() {
    private val _uiState = MutableStateFlow(AuthenticationState())
    val uiState: StateFlow<AuthenticationState> = _uiState.asStateFlow()

    var isAuthenticated by mutableStateOf(false)
        private set


    fun saveInDataStoreIsAuthenticatedTrue(context: Context){
        val mainDataStoreManager = MainDataStoreManager(context)
        viewModelScope.launch {
            mainDataStoreManager.saveIsAuthenticatedValue(true)
        }
    }
    suspend fun getIsAuthenticatedFromDataStore(context: Context){
        val mainDataStoreManager = MainDataStoreManager(context)
        mainDataStoreManager.getIsAuthenticatedValue().collect{ settings ->
            isAuthenticated = settings
        }

    }
    fun updateFalseIsAuthenticated(){
        isAuthenticated = false
    }

    var errorMessage by mutableStateOf("")
        private set

    fun updateErrorMessage(updateErrorMessage: String){
        errorMessage = updateErrorMessage
    }

    fun updateUsername(updateUsername: String){
        updateErrorMessage("")
        _uiState.update { currentState ->
            currentState.copy(
                username = updateUsername
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
        return _uiState.value.username.equals("")||_uiState.value.password.equals("")
    }

    fun authentication(errorMessageConnectionApi: String){
        //эмуляция работы с api
        val sucssess: Boolean = true
        blockAllElements()
        CoroutineScope(Dispatchers.IO).launch {
            delay(1000L)
            if(sucssess){
                isAuthenticated = true
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
                token = api.authorisation(
                    AuthorisationRequest(
                    username = _uiState.value.username,
                    password = _uiState.value.password
                    )
                ).token
                isAuthenticated = true
            }
            catch (exception: Exception) {
                isAuthenticated = false
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
                enabledPasswordField = false,
                enabledAuthenticationButton = false,
                enabledGoToRegistrationButton = false
            )
        }
    }
    fun unblockAllElements(){
        _uiState.update { currentState ->
            currentState.copy(
                enabledUsernameField = true,
                enabledPasswordField = true,
                enabledAuthenticationButton = true,
                enabledGoToRegistrationButton = true
            )
        }
    }

}