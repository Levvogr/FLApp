package com.levog.flapp.data.room.medicalexamination

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.levog.flapp.data.room.ConstantsDataRoom

@Entity(tableName = ConstantsDataRoom.MEDICAL_EXAMINATION_TABLE_NAME)
data class MedicalExaminationData(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val typeExamination: String,
    val status: String,
    val conclusion: String?,
    val medicalOrganization: String,
    val organization: String?,
    val fullNameDoctor: String?,
    val medicalSpecialty: String?,
    val harmfulFactorsExamination: String?,
    val plannedDateFrom: Long?,
    val plannedDateFor: Long,
    val dateExamination: Long,
    val datePreparationAct: Long?,
    val hourExamination: Int,
    val minuteExamination: Int
)
