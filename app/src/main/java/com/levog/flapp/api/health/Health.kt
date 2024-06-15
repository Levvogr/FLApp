package com.levog.flapp.api.health

data class Health(
    val id: Long,
    val heartRate: Int,
    val bloodSugarLvl: Double,
    val bloodPressure: String,
    val userId: Long
)
