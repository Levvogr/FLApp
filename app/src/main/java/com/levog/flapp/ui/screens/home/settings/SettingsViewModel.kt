package com.levog.flapp.ui.screens.home.settings

import androidx.lifecycle.ViewModel
import com.levog.flapp.ui.screens.home.home.HomeState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SettingsViewModel: ViewModel(){
    private val _uiState = MutableStateFlow(SettingsState())
    val uiState: StateFlow<SettingsState> = _uiState.asStateFlow()

    fun updateDisplayThemeDialog(updateDisplayThemeDialog: Boolean){
        _uiState.update { currentState ->
            currentState.copy(
                displayThemeDialog = updateDisplayThemeDialog
            )
        }
    }
    fun updateDisplayNotificationSleepDialog(updateDisplayNotificationSleepDialog: Boolean){
        _uiState.update { currentState ->
            currentState.copy(
                displayNotificationSleepDialog = updateDisplayNotificationSleepDialog
            )
        }
    }
    fun updateDisplayNotificationMedicalExaminationDialog(updateDisplayNotificationMedicalExaminationDialog: Boolean){
        _uiState.update { currentState ->
            currentState.copy(
                displayNotificationMedicalExaminationDialog = updateDisplayNotificationMedicalExaminationDialog
            )
        }
    }
    fun updateTheme(updateTheme: String){
        _uiState.update { currentState ->
            currentState.copy(
                theme = updateTheme
            )
        }
    }
    fun updateNotificationSleep(updateNotificationSleep: String){
        _uiState.update { currentState ->
            currentState.copy(
                notificationSleep = updateNotificationSleep
            )
        }
    }
    fun updateNotificationMedicalExamination(updateNotificationMedicalExamination: String){
        _uiState.update { currentState ->
            currentState.copy(
                notificationMedicalExamination = updateNotificationMedicalExamination
            )
        }
    }
}