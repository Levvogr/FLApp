package com.levog.flapp.ui.screens.medicalexamination.start

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.levog.flapp.data.room.medicalexamination.MedicalExaminationData
import com.levog.flapp.data.room.medicalexamination.MedicalExaminationRepository
import com.levog.flapp.extension.toFormattedDateString
import com.levog.flapp.extension.toLong
import com.levog.flapp.ui.screens.medicalexamination.details.MedicalExaminationDetailsState
import com.levog.flapp.ui.screens.medicalexamination.details.MedicalExaminationDetailsViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class MedicalExaminationStartViewModel(
    private val medicalExaminationRepository: MedicalExaminationRepository
): ViewModel() {

    private val _uiState = MutableStateFlow(MedicalExaminationStartState())
    val uiState: StateFlow<MedicalExaminationStartState> = _uiState.asStateFlow()

    val itemListState: StateFlow<MedicalExaminationStartListState> =
        medicalExaminationRepository.getAllItemsStream().map {
            MedicalExaminationStartListState(itemList = it)
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
            initialValue = MedicalExaminationStartListState()
        )
    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }


    init {

        viewModelScope.launch {
            delay(1000)
            testInit()
        }
        getListFormattedDates()
        findDateNextPeriodMedicalExamination()
    }
    private fun getListFormattedDates(){
        viewModelScope.launch {
            itemListState.value.itemList.map{
                _uiState.value.listFormattedDates.add(it.dateExamination.toFormattedDateString())
            }
        }

    }
    suspend fun getMedicalExaminationIdByDate(date: Long): Int{
        var id: Int = 0
        medicalExaminationRepository.getItemByDateStream(date)
            .filterNotNull()
            .map {
                id = it.id
            }
        return id
    }

    private fun findDateNextPeriodMedicalExamination(){
        var isNotFind = true
        if(itemListState.value.itemList.size>0) {
            itemListState.value.itemList.forEach { item ->
                if ((item.typeExamination == "Периодический") and (item.status == "Пройден")) {
                    isNotFind = false
                    val temp = item.dateExamination.toFormattedDateString()
                    updateDateNextPeriodMedicalExamination(
                        temp.substring(0, 6) + (temp.substring(0, 6).toInt() + 1).toString()
                    )
                }
            }
        }
        if (isNotFind) {
            updateDateNextPeriodMedicalExamination(LocalDate.now().toFormattedDateString())
        }
    }

    fun updateDateNextPeriodMedicalExamination(updateDateNextPeriodMedicalExamination: String){
        _uiState.update { currentState ->
            currentState.copy(
                dateNextPeriodMedicalExamination = updateDateNextPeriodMedicalExamination
            )
        }
    }
    fun updateDisplayCalendar(updateDisplayCalendar: Boolean){
        _uiState.update { currentState ->
            currentState.copy(
                displayCalendar = updateDisplayCalendar
            )
        }
    }













    suspend fun saveItem(medicalExaminationData: MedicalExaminationData) {
        medicalExaminationRepository.insertItem(medicalExaminationData)
    }
    private fun testInit(){
        if(itemListState.value.itemList.size<2){
            viewModelScope.launch {
                saveItem(
                    MedicalExaminationData(
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
                )
                )
            }
            viewModelScope.launch {
                saveItem(
                    MedicalExaminationData(
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
                )
                )
            }
            viewModelScope.launch {
                saveItem(
                    MedicalExaminationData(
                        typeExamination ="Периодический",
                        status = "Пройден",
                        conclusion = "Осмотр пройден",
                        medicalOrganization = "ООО \"М-Лайн\"",
                        organization = "ПАО Детский мир",
                        fullNameDoctor = "Петрова Екатерина Сидорона",
                        medicalSpecialty ="Медсестра",
                        harmfulFactorsExamination ="(А1.36.2) Бута-1,3-диен (1,3-бутадиен, дивинил))",
                        plannedDateFrom = null,
                        plannedDateFor = LocalDate.of(2024,6,10).toLong(),
                        dateExamination = LocalDate.of(2024,6,10).toLong(),
                        datePreparationAct = null,
                        hourExamination = 10,
                        minuteExamination = 30
                    )
                )
            }
        }
    }
}