plugins {
    id("java-library")
    id("kotlin")
    id("org.jlleitschuh.gradle.ktlint")
    id("name.remal.check-dependency-updates") version "1.5.0"
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Dependencies.kotlin.stdLib8)

    // Koin
    implementation(Dependencies.koin.core)

    // Coroutines
    implementation(Dependencies.kotlin.coroutines.core)
}

java.sourceCompatibility = JavaVersion.VERSION_1_8
java.targetCompatibility = JavaVersion.VERSION_1_8

val compileKotlin: org.jetbrains.kotlin.gradle.tasks.KotlinCompile by tasks
compileKotlin.kotlinOptions.jvmTarget = "1.8"

ktlint {
    outputColorName.set("RED")
    additionalEditorconfigFile.set(file("../config/ktlint/.editorconfig"))
    disabledRules.set(setOf("final-newline"))
    ignoreFailures.set(true)
}