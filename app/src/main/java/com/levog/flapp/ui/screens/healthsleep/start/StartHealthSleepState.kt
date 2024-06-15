package com.levog.flapp.ui.screens.healthsleep.start

import com.levog.flapp.data.room.medicalexamination.MedicalExaminationData
import com.levog.flapp.data.room.sleep.SleepData

data class StartHealthSleepState(
    val itemList: List<SleepData> = listOf()
)