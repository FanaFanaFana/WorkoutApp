package com.example.workoutapp.viewmodel

import android.app.Application
import android.media.MediaPlayer
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.workoutapp.R
import com.example.workoutapp.data.Exercise
import com.example.workoutapp.data.ProgressRepository
import android.os.CountDownTimer

class WorkoutViewModel(application: Application) : AndroidViewModel(application) {

    private val repo = ProgressRepository(application)
    private var exerciseList: List<Exercise> = emptyList()
    private var timer: CountDownTimer? = null

    val currentExerciseIndex = MutableLiveData(0)
    val currentCountdown = MutableLiveData(0)
    val isPaused = MutableLiveData(false)
    val isFinished = MutableLiveData(false)
    val completedWorkouts = MutableLiveData(repo.getProgress())
    val hasStarted = MutableLiveData(false)

    fun startSession(exercises: List<Exercise>) {
        if (hasStarted.value == true) return
        hasStarted.value = true
        startWorkout(exercises)
    }

    private fun startWorkout(exercises: List<Exercise>) {
        exerciseList = exercises
        currentExerciseIndex.value = 0
        isFinished.value = false
        startExercise()
    }

    private fun startExercise() {
        isPaused.value = false
        playSound(R.raw.start)

        val duration = exerciseList[currentExerciseIndex.value!!].durationSec
        startTimer(duration) {
            isPaused.value = true
            playSound(R.raw.pause)
            startPause()
        }
    }

    private fun startPause() {
        startTimer(10) {
            val nextIndex = currentExerciseIndex.value!! + 1
            if (nextIndex < exerciseList.size) {
                currentExerciseIndex.value = nextIndex
                startExercise()
            } else {
                isFinished.value = true
                completedWorkouts.value = completedWorkouts.value!! + 1
                repo.saveProgress(completedWorkouts.value!!)
            }
        }
    }

    private fun startTimer(durationSec: Int, onFinish: () -> Unit) {
        timer?.cancel()
        timer = object : CountDownTimer(durationSec * 1000L, 1000L) {
            override fun onTick(millisUntilFinished: Long) {
                currentCountdown.value = (millisUntilFinished / 1000).toInt()
            }

            override fun onFinish() {
                onFinish()
            }
        }.start()
    }

    private fun playSound(resId: Int) {
        val player = MediaPlayer.create(getApplication(), resId)
        player.setOnCompletionListener { it.release() }
        player.start()
    }

    override fun onCleared() {
        super.onCleared()
        timer?.cancel()
    }

    fun getCurrentExercise(): Exercise? {
        return exerciseList.getOrNull(currentExerciseIndex.value ?: 0)
    }
}
