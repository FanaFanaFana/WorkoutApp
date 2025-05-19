plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.compose") // this one is required now for Kotlin 2.0+
}

android {
    namespace = "com.example.workoutapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.workoutapp"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.10" // ✅ Adjust for your version
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    // Jetpack Compose
    implementation("androidx.activity:activity-compose:1.9.0")
    implementation("androidx.compose.ui:ui:1.6.6")
    implementation("androidx.compose.material:material:1.6.6")
    implementation("androidx.compose.ui:ui-tooling-preview:1.6.6")
    debugImplementation("androidx.compose.ui:ui-tooling:1.6.6")

    // ViewModel + LiveData in Compose
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.7.0")

    // Optional - sound
    implementation("androidx.compose.runtime:runtime-livedata:1.6.6")

    // Core
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")

    // SharedPreferences
    implementation("androidx.preference:preference-ktx:1.2.1")
    // Material3 Design system
    implementation("androidx.compose.material3:material3:1.1.1")

}
