package com.levog.flapp.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.levog.flapp.data.room.medicalexamination.MedicalExaminationData
import com.levog.flapp.data.room.medicalexamination.MedicalExaminationDataDao
import com.levog.flapp.data.room.sleep.SleepData
import com.levog.flapp.data.room.sleep.SleepDataDao

@Database(
    entities = [
        SleepData::class,
        MedicalExaminationData::class
               ],
    version = 1,
    exportSchema = false
)
abstract class MainDatabase  : RoomDatabase() {

    abstract fun medicalExaminationDataDao(): MedicalExaminationDataDao
    abstract fun sleepDataDao(): SleepDataDao

    companion object {
        @Volatile
        private var Instance: MainDatabase? = null

        fun getDatabase(context: Context): MainDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, MainDatabase::class.java, "main_database")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { Instance = it }
            }
        }
    }
}