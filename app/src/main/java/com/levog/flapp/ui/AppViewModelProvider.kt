package com.levog.flapp.ui

import android.util.Log
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.levog.flapp.FLApplication
import com.levog.flapp.extension.fLApplication
import com.levog.flapp.ui.screens.authentication.authentication.AuthenticationViewModel
import com.levog.flapp.ui.screens.healthsleep.duration.DurationSleepViewModel
import com.levog.flapp.ui.screens.healthsleep.start.StartHealthSleepViewModel
import com.levog.flapp.ui.screens.medicalexamination.appointment.MedicalExaminationAppointmentViewModel
import com.levog.flapp.ui.screens.medicalexamination.details.MedicalExaminationDetailsViewModel
import com.levog.flapp.ui.screens.medicalexamination.list.MedicalExaminationListViewModel
import com.levog.flapp.ui.screens.medicalexamination.start.MedicalExaminationStartViewModel

object AppViewModelProvider {
    val Factory = viewModelFactory {

        initializer {
            DurationSleepViewModel(
                fLApplication().container.sleepRepository,
            )
        }
        initializer {
            StartHealthSleepViewModel(
                fLApplication().container.sleepRepository
            )
        }


        initializer {
            MedicalExaminationListViewModel(
                fLApplication().container.medicalExaminationRepository
            )
        }
        initializer {
            MedicalExaminationAppointmentViewModel(
                fLApplication().container.medicalExaminationRepository
            )
        }
        initializer {
            MedicalExaminationStartViewModel(
                fLApplication().container.medicalExaminationRepository
            )
        }
        initializer {
            MedicalExaminationDetailsViewModel(
                this.createSavedStateHandle(),
                fLApplication().container.medicalExaminationRepository
            )
        }
    }
}