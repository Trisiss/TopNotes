buildscript {

    repositories {
        maven (url = "https://plugins.gradle.org/m2/")
        google()
        jcenter()
        
    }
    dependencies {
        classpath("com.android.tools.build:gradle:4.1.3")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.10")
        classpath("org.jetbrains.kotlin:kotlin-serialization:1.4.10")

        // Navigation
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.3.0")

        // Ktlint
        classpath("org.jlleitschuh.gradle:ktlint-gradle:10.1.0")

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
