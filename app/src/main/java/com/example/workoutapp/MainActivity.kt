package com.example.workoutapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.workoutapp.ui.theme.WorkoutScreen
import com.example.workoutapp.data.Exercise

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val exercises = listOf(
                Exercise("Jumping Jacks", "Jump with arms and legs wide.", R.drawable.jumping_jacks, 30),
                Exercise("Push-ups", "Keep your back straight.", R.drawable.push_ups, 20),
                Exercise("Squats", "Lower your hips and keep your heels down.", R.drawable.squats, 25)
            )
            WorkoutScreen(exercises)
        }
    }
}
