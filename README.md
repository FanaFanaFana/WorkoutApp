# 🏋️ WorkoutApp

**WorkoutApp** is a minimalistic Android fitness app built with Kotlin and Jetpack components. It guides users through a sequence of exercises with countdowns, rest periods, sound cues, and tracks completed workouts locally.

---

## 📦 Download

👉 [Download WorkoutApp APK](./WorkoutApp.apk)

---

## 🚀 Features

- ⏱️ **Exercise Countdown**: Timer for each exercise  
- 😌 **Break Timer**: 10-second pause between exercises  
- 🔊 **Sound Effects**: Audio cues at start and pause  
- 🧠 **MVVM Architecture**: Clean separation of UI, logic, and data  
- 📊 **Progress Tracking**: Stores number of completed workouts  
- 🟢 **Start Training Button**: Begins the workout session

---


## 🛠️ Tech Stack

- **Kotlin**
- **Android Jetpack ViewModel**
- **LiveData**
- **CountDownTimer**
- **MediaPlayer**
- **Jetpack Compose** (if you're using it for UI)

---

## 🧩 Project Structure
com.example.workoutapp
├── data
│ └── Exercise.kt
│ └── ProgressRepository.kt
├── ui
│ └── WorkoutScreen.kt
├── viewmodel
│ └── WorkoutViewModel.kt


---

## 🔧 Getting Started

### Prerequisites

- Android Studio Hedgehog or later
- Kotlin 1.8+
- Android SDK 26+

### Clone & Run

```bash
git clone https://github.com/FanaFanaFana/WorkoutApp.git
cd WorkoutApp

