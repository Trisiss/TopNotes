plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
    id("androidx.navigation.safeargs.kotlin")
    id("org.jlleitschuh.gradle.ktlint")
}

android {
    compileSdkVersion(AndroidSDK.compileVersion)
    buildToolsVersion = "29.0.3"

    defaultConfig {
        applicationId = "ru.trisiss.topnotes"
        minSdkVersion(AndroidSDK.minimalVersion)
        targetSdkVersion(AndroidSDK.targetVersion)
        versionCode(Releases.versionCode)
        versionName(Releases.versionName)

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    android.buildFeatures.dataBinding = true
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile
                ("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_1_8)
        targetCompatibility(JavaVersion.VERSION_1_8)
    }
    // work-runtime-ktx 2.1.0 and above now requires Java 8
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Dependencies.kotlin.stdLib7)
    implementation(Dependencies.android.appCompat)
    implementation(Dependencies.android.core)
    implementation(Dependencies.android.legacySupport)
    implementation(Dependencies.android.lifeCycleExtensions)
    implementation(project(path = ":domain"))
    implementation(project(path = ":data"))

    // ViewModel
    implementation(Dependencies.viewModel.extensions)
    implementation(Dependencies.viewModel.ktx)

    // Navigation
    implementation(Dependencies.navigation.fragment)
    implementation(Dependencies.navigation.ui)
    // Dynamic Feature Module Support
    implementation(Dependencies.navigation.dynamicFeature)
    // Testing Navigation
    androidTestImplementation(Dependencies.navigation.test)

    // Room
    implementation(Dependencies.room.runtime)
    kapt(Dependencies.room.compiler)
    // optional - Kotlin Extensions and Coroutines support for Room
    implementation(Dependencies.room.ktx)
    testImplementation(Dependencies.room.test)

    // LiveData
    implementation(Dependencies.liveData.ktx)

    // Koin
    implementation(Dependencies.koin.android)

    // UI
    implementation(Dependencies.ui.recycler)
    implementation(Dependencies.ui.constraint)
    implementation(Dependencies.ui.recyclerSelection)
    
    // Test
    testImplementation(Dependencies.test.junit)
    androidTestImplementation(Dependencies.test.androidJunit)
    androidTestImplementation(Dependencies.test.espresso)
}
