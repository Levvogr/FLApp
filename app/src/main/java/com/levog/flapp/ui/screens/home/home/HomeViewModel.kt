package com.levog.flapp.ui.screens.home.home

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class HomeViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(HomeState())
    val uiState: StateFlow<HomeState> = _uiState.asStateFlow()

    fun updateIsAuthenticated(updateIsAuthenticated: Boolean){
        _uiState.update { currentState ->
            currentState.copy(
                isAuthenticated = updateIsAuthenticated
            )
        }
    }
    fun updateEnabledExaminationButton(updateEnabledExaminationButton: Boolean){
        _uiState.update { currentState ->
            currentState.copy(
                enabledExaminationButton = updateEnabledExaminationButton
            )
        }
    }
    fun updateEnabledSleepButton(updateEnabledSleepButton: Boolean){
        _uiState.update { currentState ->
            currentState.copy(
                enabledSleepButton = updateEnabledSleepButton
            )
        }
    }
    fun updateEnabledProfileButton(updateEnabledProfileButton: Boolean){
        _uiState.update { currentState ->
            currentState.copy(
                enabledProfileButton = updateEnabledProfileButton
            )
        }
    }
    fun updateEnabledSettingsButton(updateEnabledSettingsButton: Boolean){
        _uiState.update { currentState ->
            currentState.copy(
                enabledSettingsButton = updateEnabledSettingsButton
            )
        }
    }
}