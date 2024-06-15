package com.levog.flapp.data.room.sleep

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.levog.flapp.data.room.ConstantsDataRoom
import kotlinx.coroutines.flow.Flow

@Dao
interface SleepDataDao {
    @Query("SELECT * from ${ConstantsDataRoom.SLEEP_TABLE_NAME} ORDER BY startSleep DESC")
    fun getAllItems(): Flow<List<SleepData>>

    @Query("SELECT * from ${ConstantsDataRoom.SLEEP_TABLE_NAME} WHERE id = :id")
    fun getItem(id: Int): Flow<SleepData>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: SleepData)

    @Update
    suspend fun update(item: SleepData)

    @Delete
    suspend fun delete(item: SleepData)
}