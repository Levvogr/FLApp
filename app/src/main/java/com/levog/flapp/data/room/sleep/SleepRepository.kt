package com.levog.flapp.data.room.sleep

import kotlinx.coroutines.flow.Flow

interface SleepRepository {
    fun getAllItemsStream(): Flow<List<SleepData>>

    fun getItemStream(id: Int): Flow<SleepData?>

    suspend fun insertItem(item: SleepData)

    suspend fun deleteItem(item: SleepData)

    suspend fun updateItem(item: SleepData)
}