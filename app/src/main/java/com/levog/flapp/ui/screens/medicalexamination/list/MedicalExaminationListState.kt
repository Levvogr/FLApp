package com.levog.flapp.ui.screens.medicalexamination.list

import com.levog.flapp.data.room.medicalexamination.MedicalExaminationData

data class MedicalExaminationListState(
    val itemList: List<MedicalExaminationData> = listOf()
)