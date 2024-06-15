package com.levog.flapp.data.room.sleep

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.levog.flapp.data.room.ConstantsDataRoom

@Entity(tableName = ConstantsDataRoom.SLEEP_TABLE_NAME)
data class SleepData(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val startSleep: Long,
    val endSleep: Long
)
