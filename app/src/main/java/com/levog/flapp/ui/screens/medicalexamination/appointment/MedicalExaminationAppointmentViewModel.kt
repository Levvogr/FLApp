package com.levog.flapp.ui.screens.medicalexamination.appointment

import androidx.lifecycle.ViewModel
import com.levog.flapp.data.room.medicalexamination.MedicalExaminationData
import com.levog.flapp.data.room.medicalexamination.MedicalExaminationRepository
import com.levog.flapp.extension.toFormattedDateString
import com.levog.flapp.extension.toLong
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.time.LocalDate

class MedicalExaminationAppointmentViewModel(
    private val medicalExaminationRepository: MedicalExaminationRepository
): ViewModel(){
    private val _uiState = MutableStateFlow(MedicalExaminationAppointmentState())
    val uiState: StateFlow<MedicalExaminationAppointmentState> = _uiState.asStateFlow()

    var listMedicalExaminationOrganiztions: List<String> = listOf()
    var listMedicalExaminationFormattedDates: List<String> = listOf()
    var listMedicalExaminationTimes: List<String> = listOf()



    init {
        updateListOrganizations()
        updateListFormattedDatesOfOrganization()
        updateListTimeOfDateAndOrganization()


    }


    suspend fun saveItem() {
        medicalExaminationRepository.insertItem(
            MedicalExaminationData(
                typeExamination ="Периодический",
                status = "Ожидается",
                conclusion = null,
                medicalOrganization = _uiState.value.medicalOrganization,
                organization = null,
                fullNameDoctor = null,
                medicalSpecialty =null,
                harmfulFactorsExamination = null,
                plannedDateFrom = null,
                plannedDateFor = LocalDate.of(_uiState.value.dateMedicalExamination.substring(6).toInt(),
                    _uiState.value.dateMedicalExamination.substring(3,5).toInt(),
                    _uiState.value.dateMedicalExamination.substring(0,2).toInt())
                    .toLong(),
                dateExamination = LocalDate.of(_uiState.value.dateMedicalExamination.substring(6).toInt(),
                    _uiState.value.dateMedicalExamination.substring(3,5).toInt(),
                    _uiState.value.dateMedicalExamination.substring(0,2).toInt())
                    .toLong(),
                datePreparationAct = null,
                hourExamination = _uiState.value.timeMedicalExamination.substring(0,2).toInt(),
                minuteExamination = _uiState.value.timeMedicalExamination.substring(3).toInt()
            )
        )
    }

    fun updateExpandedOrganizationDropdownMenu(updateExpandedOrganizationDropdownMenu: Boolean){
        _uiState.update { currentState ->
            currentState.copy(
                expandedOrganizationDropdownMenu = updateExpandedOrganizationDropdownMenu
            )
        }
    }
    fun updateExpandedTimeDropdownMenu(updateExpandedTimeDropdownMenu: Boolean){
        _uiState.update { currentState ->
            currentState.copy(
                expandedTimeDropdownMenu = updateExpandedTimeDropdownMenu
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
    fun updateEnabledAndVisibilityDateField(updateEnabledAndVisibilityDateField: Boolean){
        _uiState.update { currentState ->
            currentState.copy(
                enabledAndVisibilityDateField = updateEnabledAndVisibilityDateField
            )
        }
    }
    fun updateEnabledAndVisibilityTimeField(updateEnabledAndVisibilityTimeField: Boolean){
        _uiState.update { currentState ->
            currentState.copy(
                enabledAndVisibilityTimeField = updateEnabledAndVisibilityTimeField
            )
        }
    }
    fun updateEnabledAndVisibilityAppointmentButton(updateEnabledAndVisibilityAppointmentButton: Boolean){
        _uiState.update { currentState ->
            currentState.copy(
                enabledAndVisibilityAppointmentButton = updateEnabledAndVisibilityAppointmentButton
            )
        }
    }
    fun updateMedicalOrganization(updateMedicalOrganization: String){
        _uiState.update { currentState ->
            currentState.copy(
                medicalOrganization = updateMedicalOrganization
            )
        }
    }
    fun updateDateMedicalExamination(updateDateMedicalExamination: String){
        _uiState.update { currentState ->
            currentState.copy(
                dateMedicalExamination = updateDateMedicalExamination
            )
        }
    }
    fun updateTimeMedicalExamination(updateTimeMedicalExamination: String){
        _uiState.update { currentState ->
            currentState.copy(
                timeMedicalExamination = updateTimeMedicalExamination
            )
        }
    }





























    //Ниже три тестовые функции заместо подключения к api
    fun updateListOrganizations(){
        listMedicalExaminationOrganiztions = listOf(
            "ООО \"М-Лайн\"",
            "Альфа-Центр",
            "СоюзМедТранс"
        )

    }

    fun updateListFormattedDatesOfOrganization(organization: String=""){
        val listDates = listOf(
            LocalDate.of(2024,6,15),
            LocalDate.of(2024,6,17),
            LocalDate.of(2024,6,19),
            LocalDate.of(2024,6,21),
            LocalDate.of(2024,6,22),
            LocalDate.of(2024,6,23),
            LocalDate.of(2024,6,24),
            LocalDate.of(2024,6,25),
            LocalDate.of(2024,6,26),
            LocalDate.of(2024,6,27),
            LocalDate.of(2024,6,29),
            LocalDate.of(2024,7,15),
            LocalDate.of(2024,7,17),
            LocalDate.of(2024,7,19),
            LocalDate.of(2024,7,21),
            LocalDate.of(2024,7,22),
            LocalDate.of(2024,7,23),
            LocalDate.of(2024,7,24),
            LocalDate.of(2024,7,25),
            LocalDate.of(2024,7,26),
            LocalDate.of(2024,7,27),
            LocalDate.of(2024,7,29),
        )
        listMedicalExaminationFormattedDates = listDates.map{
            it.toFormattedDateString()
        }

    }

    fun updateListTimeOfDateAndOrganization(
        organization: String="",
        date: LocalDate=LocalDate.now()
    ){
        listMedicalExaminationTimes = listOf(
            "10:00",
            "10:30",
            "10:45",
            "11:00",
            "11:15",
            "11:45",
            "15:00",
            "15:30",
            "15:45",
            "16:00",
            "17:30",
            "17:45",
            "18:00",
            "18:30",
            "18:45")

    }
}