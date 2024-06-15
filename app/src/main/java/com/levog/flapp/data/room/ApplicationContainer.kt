package com.levog.flapp.data.room

import com.levog.flapp.data.room.medicalexamination.MedicalExaminationRepository
import com.levog.flapp.data.room.sleep.SleepRepository

interface ApplicationContainer {
    val medicalExaminationRepository: MedicalExaminationRepository
    val sleepRepository: SleepRepository
}