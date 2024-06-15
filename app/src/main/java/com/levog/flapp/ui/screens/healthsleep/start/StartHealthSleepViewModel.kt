package com.levog.flapp.ui.screens.healthsleep.start

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.levog.flapp.data.room.medicalexamination.MedicalExaminationData
import com.levog.flapp.data.room.medicalexamination.MedicalExaminationRepository
import com.levog.flapp.data.room.sleep.SleepData
import com.levog.flapp.data.room.sleep.SleepRepository
import com.levog.flapp.extension.toLong
import com.levog.flapp.ui.screens.medicalexamination.list.MedicalExaminationListState
import com.levog.flapp.ui.screens.medicalexamination.list.MedicalExaminationListViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.LocalDateTime

class StartHealthSleepViewModel(
    private val sleepRepository: SleepRepository
): ViewModel(){
    private val _uiState: StateFlow<StartHealthSleepState> =
        sleepRepository.getAllItemsStream().map {
            StartHealthSleepState(it)
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
            initialValue = StartHealthSleepState()
        )
    val uiState: StateFlow<StartHealthSleepState> = _uiState

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
    init {
        viewModelScope.launch {
            delay(1000)
            testInit()
        }
    }
    suspend fun saveItem(sleepData: SleepData) {
        sleepRepository.insertItem(sleepData)
    }
    private fun testInit() {
        if (_uiState.value.itemList.size < 5) {
            viewModelScope.launch {
                saveItem(
                    SleepData(
                        startSleep = LocalDateTime.of(
                            2024,6,14,22,30
                        ).toLong(),
                        endSleep = LocalDateTime.of(
                            2024,6,15,8,30
                        ).toLong(),
                    )
                )
                saveItem(
                    SleepData(
                        startSleep = LocalDateTime.of(
                            2024,6,13,22,30
                        ).toLong(),
                        endSleep = LocalDateTime.of(
                            2024,6,14,8,30
                        ).toLong(),
                    )
                )
                saveItem(
                    SleepData(
                        startSleep = LocalDateTime.of(
                            2024,6,12,22,30
                        ).toLong(),
                        endSleep = LocalDateTime.of(
                            2024,6,13,8,30
                        ).toLong(),
                    )
                )
                saveItem(
                    SleepData(
                        startSleep = LocalDateTime.of(
                            2024,6,11,19,30
                        ).toLong(),
                        endSleep = LocalDateTime.of(
                            2024,6,12,10,30
                        ).toLong(),
                    )
                )
                saveItem(
                    SleepData(
                        startSleep = LocalDateTime.of(
                            2024,6,10,22,30
                        ).toLong(),
                        endSleep = LocalDateTime.of(
                            2024,6,11,8,30
                        ).toLong(),
                    )
                )
                saveItem(
                    SleepData(
                        startSleep = LocalDateTime.of(
                            2024,6,9,18,30
                        ).toLong(),
                        endSleep = LocalDateTime.of(
                            2024,6,10,6,30
                        ).toLong(),
                    )
                )
                saveItem(
                    SleepData(
                        startSleep = LocalDateTime.of(
                            2024,6,8,22,30
                        ).toLong(),
                        endSleep = LocalDateTime.of(
                            2024,6,9,8,30
                        ).toLong(),
                    )
                )
                saveItem(
                    SleepData(
                        startSleep = LocalDateTime.of(
                            2024,6,7,16,30
                        ).toLong(),
                        endSleep = LocalDateTime.of(
                            2024,6,8,4,30
                        ).toLong(),
                    )
                )
                saveItem(
                    SleepData(
                        startSleep = LocalDateTime.of(
                            2024,6,6,16,30
                        ).toLong(),
                        endSleep = LocalDateTime.of(
                            2024,6,7,4,30
                        ).toLong(),
                    )
                )
                saveItem(
                    SleepData(
                        startSleep = LocalDateTime.of(
                            2024,6,5,16,30
                        ).toLong(),
                        endSleep = LocalDateTime.of(
                            2024,6,6,4,30
                        ).toLong(),
                    )
                )
            }
        }
    }
}