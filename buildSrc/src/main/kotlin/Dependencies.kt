/**
 * Created by trisiss on 5/30/2021.
 */
object AndroidSDK {
    const val compileVersion = 30
    const val targetVersion = 30
    const val minimalVersion = 21
}
object Releases {
    const val versionCode = 3
    const val versionName = "0.1.2"
}

object Versions {
    const val kotlinVersion = "1.4.0"
    const val kotlinLibVersion = "1.4.10"
    const val viewModelVersion = "2.2.0"
    const val navVersion = "2.3.0"
    const val roomVersion = "2.2.5"
    const val ktlintVersion = "9.3.0"
    const val coroutinesVersion = "1.4.3"
    const val workVersion = "2.4.0"
    const val rxKotlinVersion = "3.0.0"
    const val rxAndroidVersion = "3.0.0"
    const val junitVersion = "1.1.2"
    const val espressoVersion = "3.3.0"
    const val koinVersion = "3.0.1"
    const val appCompatVersion = "1.2.0"
    const val serializationVersion = "0.20.0"
}

object Dependencies {
    val kotlin = KotlinDeps
    val android = AndroidDeps
    val viewModel = ViewModelDeps
    val navigation = NavigationDeps
    val liveData = LiveData
    val room = Room
    val koin = Koin
    val ui = UI
    val test = Test
}

object KotlinDeps {
    val stdLib7 = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlinVersion}"
    val stdLib8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlinLibVersion}"
    val stdLib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlinLibVersion}"
    val serialization = "org.jetbrains.kotlinx:kotlinx-serialization-runtime:${Versions.serializationVersion}"
    val coroutines = CoroutinesDeps
}

object CoroutinesDeps {
    val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesVersion}"
    val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesVersion}"
}

object AndroidDeps {
    val appCompat = "androidx.appcompat:appcompat:${Versions.appCompatVersion}"
    val core = "androidx.core:core-ktx:1.3.1"
    val legacySupport = "androidx.legacy:legacy-support-v4:1.0.0"
    val lifeCycleExtensions = "android.arch.lifecycle:extensions:1.1.1"
}

object ViewModelDeps {
    val extensions = "androidx.lifecycle:lifecycle-extensions:${Versions.viewModelVersion}"
    val ktx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.viewModelVersion}"
}

object NavigationDeps {
    val fragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navVersion}"
    val ui = "androidx.navigation:navigation-ui-ktx:${Versions.navVersion}"
    val dynamicFeature = "androidx.navigation:navigation-dynamic-features-fragment:${Versions.navVersion}"
    val test = "androidx.navigation:navigation-testing:${Versions.navVersion}"
}

object LiveData {
    val ktx = "androidx.lifecycle:lifecycle-livedata-ktx:2.3.1"
}

object Room {
    val runtime = "androidx.room:room-runtime:${Versions.roomVersion}"
    val compiler = "androidx.room:room-compiler:${Versions.roomVersion}"
    val ktx = "androidx.room:room-ktx:${Versions.roomVersion}"
    val test = "androidx.room:room-testing:${Versions.roomVersion}"
}

object Koin {
    val android = "io.insert-koin:koin-android:${Versions.koinVersion}"
    val core = "io.insert-koin:koin-core:${Versions.koinVersion}"
}

object UI {
    val recycler = "androidx.recyclerview:recyclerview:1.2.1"
    val constraint = "androidx.constraintlayout:constraintlayout:2.0.0"
    val recyclerSelection = "androidx.recyclerview:recyclerview-selection:1.0.0"
}

object Test {
    val junit = "junit:junit:4.12"
    val androidJunit = "androidx.test.ext:junit:1.1.1"
    val espresso = "androidx.test.espresso:espresso-core:3.2.0"
}

