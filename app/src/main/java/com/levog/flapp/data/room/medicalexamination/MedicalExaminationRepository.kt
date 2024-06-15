package com.levog.flapp.data.room.medicalexamination

import com.levog.flapp.data.room.medicalexamination.MedicalExaminationData
import com.levog.flapp.data.room.sleep.SleepData
import kotlinx.coroutines.flow.Flow

interface MedicalExaminationRepository {
    fun getAllItemsStream(): Flow<List<MedicalExaminationData>>
    fun getItemStream(id: Int): Flow<MedicalExaminationData?>
    fun getItemByDateStream(date: Long): Flow<MedicalExaminationData?>

    suspend fun insertItem(item: MedicalExaminationData)

    suspend fun deleteItem(item: MedicalExaminationData)

    suspend fun updateItem(item: MedicalExaminationData)
}