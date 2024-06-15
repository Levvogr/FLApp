package com.levog.flapp.data.room

import android.content.Context
import com.levog.flapp.data.room.medicalexamination.MedicalExaminationRepository
import com.levog.flapp.data.room.medicalexamination.OfflineMedicalExaminationRepository
import com.levog.flapp.data.room.sleep.OfflineSleepRepository
import com.levog.flapp.data.room.sleep.SleepRepository

class ApplicationDataContainer(private val context: Context): ApplicationContainer {
    override val medicalExaminationRepository: MedicalExaminationRepository by lazy {
        OfflineMedicalExaminationRepository(
            MainDatabase.getDatabase(context).medicalExaminationDataDao()
        )
    }
    override val sleepRepository: SleepRepository by lazy {
        OfflineSleepRepository(
            MainDatabase.getDatabase(context).sleepDataDao()
        )
    }
}