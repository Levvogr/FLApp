package com.levog.flapp.ui.screens.medicalexamination.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.levog.flapp.data.room.medicalexamination.MedicalExaminationData
import com.levog.flapp.data.room.medicalexamination.MedicalExaminationRepository
import com.levog.flapp.extension.toLong
import com.levog.flapp.navigation.destinations.ArgumentsRoute
import com.levog.flapp.ui.screens.medicalexamination.list.MedicalExaminationListState
import com.levog.flapp.ui.screens.medicalexamination.list.MedicalExaminationListViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import java.time.LocalDate

class MedicalExaminationDetailsViewModel(
    savedStateHandle: SavedStateHandle,
    private val medicalExaminationRepository: MedicalExaminationRepository
): ViewModel(){
    private val medicalExaminationId: Int = checkNotNull(
        savedStateHandle[
            ArgumentsRoute
                .MedicalExaminationGraph
                .MedicalExaminationDetails
                .argument
        ]
    )
    private val _uiState: StateFlow<MedicalExaminationDetailsState> =
        medicalExaminationRepository.getItemStream(medicalExaminationId)
            .filterNotNull()
            .map {
                MedicalExaminationDetailsState(
                    typeExamination =it.typeExamination,
                    status = it.status,
                    conclusion = it.conclusion,
                    medicalOrganization = it.medicalOrganization,
                    organization = it.organization,
                    fullNameDoctor = it.fullNameDoctor,
                    medicalSpecialty = it.medicalSpecialty,
                    harmfulFactorsExamination = it.harmfulFactorsExamination,
                    plannedDateFrom = it.plannedDateFrom,
                    plannedDateFor = it.plannedDateFor,
                    dateExamination = it.dateExamination,
                    datePreparationAct = it.datePreparationAct,
                    hourExamination = it.hourExamination,
                    minuteExamination = it.minuteExamination
                )
            }.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = MedicalExaminationDetailsState()
            )
    val uiState: StateFlow<MedicalExaminationDetailsState> = _uiState


    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}