plugins {
    id("java-library")
    id("kotlin")
    id("kotlinx-serialization")
    id("org.jlleitschuh.gradle.ktlint")
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Dependencies.kotlin.stdLib8)

    // Koin
    implementation(Dependencies.koin.core)
}

java.sourceCompatibility = JavaVersion.VERSION_1_8
java.targetCompatibility = JavaVersion.VERSION_1_8