package com.levog.flapp.ui.screens.medicalexamination.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.levog.flapp.data.room.medicalexamination.MedicalExaminationData
import com.levog.flapp.data.room.medicalexamination.MedicalExaminationRepository
import com.levog.flapp.extension.toLong
import com.levog.flapp.ui.screens.authentication.authentication.AuthenticationState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.ZoneOffset

class MedicalExaminationListViewModel(
    private val medicalExaminationRepository: MedicalExaminationRepository
): ViewModel(){
    //private val _uiState = MutableStateFlow(MedicalExaminationListState())
    //var uiState: StateFlow<MedicalExaminationListState> = _uiState.asStateFlow()

    private val _uiState: StateFlow<MedicalExaminationListState> =
        medicalExaminationRepository.getAllItemsStream().map {
            MedicalExaminationListState(it)
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
            initialValue = MedicalExaminationListState()
        )
    val uiState: StateFlow<MedicalExaminationListState> = _uiState
    init {


        viewModelScope.launch {
            delay(3000)
            testInit()
        }

    }
    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }

    suspend fun saveItem(medicalExaminationData: MedicalExaminationData) {
        medicalExaminationRepository.insertItem(medicalExaminationData)
    }

    private fun testInit(){
        if(_uiState.value.itemList.size<2){
            viewModelScope.launch {
                saveItem(MedicalExaminationData(
                    typeExamination ="Периодический",
                    status = "Отменён",
                    conclusion = "Осмотр не пройден",
                    medicalOrganization ="ООО \"М-Лайн\"",
                    organization ="ПАО Детский мир",
                    fullNameDoctor = "Петрова Екатерина Сидорона",
                    medicalSpecialty ="Медсестра",
                    harmfulFactorsExamination ="(А1.36.2) Бута-1,3-диен (1,3-бутадиен, дивинил))",
                    plannedDateFrom = null,
                    plannedDateFor = LocalDate.of(2020,1,1).toLong(),
                    dateExamination = LocalDate.of(2020,1,1).toLong(),
                    datePreparationAct = null,
                    hourExamination = 10,
                    minuteExamination = 30
                ))
            }
            viewModelScope.launch {
                saveItem(MedicalExaminationData(
                    typeExamination ="Периодический",
                    status = "Пройден",
                    conclusion = "Осмотр пройден",
                    medicalOrganization = "ООО \"М-Лайн\"",
                    organization = "ПАО Детский мир",
                    fullNameDoctor = "Петрова Екатерина Сидорона",
                    medicalSpecialty ="Медсестра",
                    harmfulFactorsExamination ="(А1.36.2) Бута-1,3-диен (1,3-бутадиен, дивинил))",
                    plannedDateFrom = null,
                    plannedDateFor = LocalDate.of(2022,1,1).toLong(),
                    dateExamination = LocalDate.of(2022,1,1).toLong(),
                    datePreparationAct = null,
                    hourExamination = 10,
                    minuteExamination = 30
                ))
            }
        }
    }


}