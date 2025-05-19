package com.example.workoutapp.data

import android.content.Context
import androidx.core.content.edit

class ProgressRepository(context: Context) {
    private val prefs = context.getSharedPreferences("workout_prefs", Context.MODE_PRIVATE)

    fun saveProgress(count: Int) {
        prefs.edit() { putInt("completed_workouts", count) }
    }

    fun getProgress(): Int = prefs.getInt("completed_workouts", 0)
}
