package com.levog.flapp.data.room.medicalexamination

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.levog.flapp.data.room.ConstantsDataRoom
import com.levog.flapp.data.room.medicalexamination.MedicalExaminationData
import com.levog.flapp.data.room.sleep.SleepData
import kotlinx.coroutines.flow.Flow

@Dao
interface MedicalExaminationDataDao {
    @Query("SELECT * from ${ConstantsDataRoom.MEDICAL_EXAMINATION_TABLE_NAME} ORDER BY dateExamination DESC")
    fun getAllItems(): Flow<List<MedicalExaminationData>>

    @Query("SELECT * from ${ConstantsDataRoom.MEDICAL_EXAMINATION_TABLE_NAME} WHERE id = :id")
    fun getItem(id: Int): Flow<MedicalExaminationData>

    @Query("SELECT * from ${ConstantsDataRoom.MEDICAL_EXAMINATION_TABLE_NAME} WHERE dateExamination = :date")
    fun getItemByDate(date: Long): Flow<MedicalExaminationData>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: MedicalExaminationData)

    @Update
    suspend fun update(item: MedicalExaminationData)

    @Delete
    suspend fun delete(item: MedicalExaminationData)
}