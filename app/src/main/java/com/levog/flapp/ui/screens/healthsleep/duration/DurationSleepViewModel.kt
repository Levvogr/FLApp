package com.levog.flapp.ui.screens.healthsleep.duration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.levog.flapp.data.room.sleep.SleepRepository
import com.levog.flapp.ui.screens.healthsleep.start.StartHealthSleepState
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class DurationSleepViewModel(
    private val sleepRepository: SleepRepository
): ViewModel(){
    private val _uiState: StateFlow<DurationSleepState> =
        sleepRepository.getAllItemsStream().map {
            DurationSleepState(it)
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
            initialValue = DurationSleepState()
        )
    val uiState: StateFlow<DurationSleepState> = _uiState

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}