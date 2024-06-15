package com.levog.flapp.data.room.sleep

import com.levog.flapp.data.room.sleep.SleepData
import com.levog.flapp.data.room.sleep.SleepDataDao
import com.levog.flapp.data.room.sleep.SleepRepository
import kotlinx.coroutines.flow.Flow

class OfflineSleepRepository(
    private val itemDao: SleepDataDao
): SleepRepository {
    override fun getAllItemsStream(): Flow<List<SleepData>> = itemDao.getAllItems()

    override fun getItemStream(id: Int): Flow<SleepData?> = itemDao.getItem(id)

    override suspend fun insertItem(item: SleepData) = itemDao.insert(item)

    override suspend fun deleteItem(item: SleepData) = itemDao.delete(item)

    override suspend fun updateItem(item: SleepData) = itemDao.update(item)

}