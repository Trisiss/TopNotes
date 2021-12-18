buildscript {

    repositories {
        maven (url = "https://plugins.gradle.org/m2/")
        google()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.0.3")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.31")

        // Navigation
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.3.5")

        // Ktlint
        classpath("org.jlleitschuh.gradle:ktlint-gradle:10.2.0")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
