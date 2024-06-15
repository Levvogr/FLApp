package com.levog.flapp.data.room.medicalexamination

import com.levog.flapp.data.room.medicalexamination.MedicalExaminationData
import com.levog.flapp.data.room.medicalexamination.MedicalExaminationDataDao
import com.levog.flapp.data.room.medicalexamination.MedicalExaminationRepository
import kotlinx.coroutines.flow.Flow

class OfflineMedicalExaminationRepository(
    private val itemDao: MedicalExaminationDataDao
): MedicalExaminationRepository {
    override fun getAllItemsStream(): Flow<List<MedicalExaminationData>>  = itemDao.getAllItems()
    override fun getItemStream(id: Int): Flow<MedicalExaminationData?>  = itemDao.getItem(id)
    override fun getItemByDateStream(date: Long): Flow<MedicalExaminationData?> = itemDao.getItemByDate(date)

    override suspend fun insertItem(item: MedicalExaminationData) = itemDao.insert(item)

    override suspend fun deleteItem(item: MedicalExaminationData) = itemDao.delete(item)

    override suspend fun updateItem(item: MedicalExaminationData) = itemDao.update(item)

}