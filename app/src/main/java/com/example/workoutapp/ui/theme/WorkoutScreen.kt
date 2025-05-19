package com.example.workoutapp.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.workoutapp.viewmodel.WorkoutViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutapp.data.Exercise
import androidx.compose.runtime.livedata.observeAsState


@Composable
fun WorkoutScreen(
    exercises: List<Exercise>,
    viewModel: WorkoutViewModel = viewModel()
) {
    val currentExercise by viewModel.currentExerciseIndex.observeAsState(0)
    val countdown by viewModel.currentCountdown.observeAsState(0)
    val isPaused by viewModel.isPaused.observeAsState(false)
    val isFinished by viewModel.isFinished.observeAsState(false)
    val completedWorkouts by viewModel.completedWorkouts.observeAsState(0)
    val hasStarted by viewModel.hasStarted.observeAsState(false)

    val current = viewModel.getCurrentExercise()

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Workout Progress: $completedWorkouts completed", style = MaterialTheme.typography.titleMedium)
        Spacer(Modifier.height(16.dp))

        if (!hasStarted) {
            Button(
                onClick = { viewModel.startSession(exercises) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Start Training")
            }
        } else if (!isFinished) {
            current?.let {
                Text(it.name, style = MaterialTheme.typography.titleLarge)
                Spacer(Modifier.height(8.dp))
                Image(
                    painter = painterResource(id = it.imageResId),
                    contentDescription = it.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                )
                Spacer(Modifier.height(8.dp))
                Text(it.description)
                Spacer(Modifier.height(16.dp))
                Text(if (isPaused) "Pause: $countdown" else "Time Left: $countdown")
                Spacer(Modifier.height(16.dp))
                LinearProgressIndicator(
                    progress = (currentExercise + 1).toFloat() / exercises.size,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        } else {
            Text("🎉 Workout complete!", style = MaterialTheme.typography.headlineMedium)
        }
    }
}
