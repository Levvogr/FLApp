package com.levog.flapp.ui.screens.medicalexamination.start

import com.levog.flapp.data.room.medicalexamination.MedicalExaminationData

data class MedicalExaminationStartState (
    val displayCalendar: Boolean = false,
    val dateNextPeriodMedicalExamination: String = "",
    val listFormattedDates: MutableList<String> = mutableListOf("")
)