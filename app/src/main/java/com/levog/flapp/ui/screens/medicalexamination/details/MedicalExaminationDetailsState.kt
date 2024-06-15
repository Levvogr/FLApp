package com.levog.flapp.ui.screens.medicalexamination.details

data class MedicalExaminationDetailsState(
    val typeExamination: String = "Нет данных",
    val status: String = "Нет данных",
    val conclusion: String? = "Нет данных",
    val medicalOrganization: String = "Нет данных",
    val organization: String? = "Нет данных",
    val fullNameDoctor: String? = "Нет данных",
    val medicalSpecialty: String? = "Нет данных",
    val harmfulFactorsExamination: String? = "Нет данных",
    val plannedDateFrom: Long? = null,
    val plannedDateFor: Long? = null,
    val dateExamination: Long? = null,
    val datePreparationAct: Long? = null,
    val hourExamination: Int? = null,
    val minuteExamination: Int? = null
)