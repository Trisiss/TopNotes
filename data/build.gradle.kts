plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("org.jlleitschuh.gradle.ktlint")
    id("name.remal.check-dependency-updates") version "1.5.0"
}

android {
    compileSdk = AndroidSDK.compileVersion
    buildToolsVersion = AndroidSDK.buildToolVersion

    defaultConfig {
        minSdk = AndroidSDK.minimalVersion
        targetSdk = AndroidSDK.targetVersion

        consumerProguardFiles("consumer-rules.pro")

        javaCompileOptions {
            annotationProcessorOptions {
                arguments["room.incremental"] = "true"
            }
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Dependencies.kotlin.stdLib)
    implementation(Dependencies.android.core)
    implementation(Dependencies.android.appCompat)
    implementation(project(path = ":domain"))

    // Room
    implementation(Dependencies.room.runtime)
    implementation(Dependencies.room.ktx)
    kapt(Dependencies.room.compiler)

    // Coroutines
    implementation(Dependencies.kotlin.coroutines.android)
    implementation(Dependencies.kotlin.coroutines.core)

    // Koin
    implementation(Dependencies.koin.core)
    implementation(Dependencies.koin.android)

    // Test
    testImplementation(Dependencies.test.junit)
    androidTestImplementation(Dependencies.test.androidJunit)
    androidTestImplementation(Dependencies.test.espresso)

}

ktlint {
    android.set(true)
    outputColorName.set("RED")
    additionalEditorconfigFile.set(file("../config/ktlint/.editorconfig"))
    disabledRules.set(setOf("final-newline"))
    ignoreFailures.set(true)
}