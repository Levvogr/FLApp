package com.levog.flapp.api.physicalactivity

data class PhysicalActivity(
    val id: Long,
    val steps: Int,
    val distance: Double,
    val workoutTime: String,
    val caloriesBurned: Double,
    val userId: Long
)
