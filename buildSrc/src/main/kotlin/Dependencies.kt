/**
 * Created by trisiss on 5/30/2021.
 */
object AndroidSDK {
    const val compileVersion = 31
    const val targetVersion = 31
    const val minimalVersion = 21
    const val buildToolVersion = "30.0.2"
}
object Releases {
    const val versionCode = 3
    const val versionName = "0.1.2"
}

object Versions {
    const val kotlin = "1.5.31"
    const val kotlinLib = "1.5.31"
    const val viewModel = "2.4.0"
    const val nav = "2.3.5"
    const val room = "2.3.0"
    const val coroutines = "1.5.2"
    const val androidJunit = "1.1.3"
    const val junit = "4.13.2"
    const val espresso = "3.4.0"
    const val koin = "3.1.3"
    const val appCompat = "1.3.1"
    const val androidxCore = "1.7.0"
    const val legacySupport = "1.0.0"
    const val livedataKtx = "2.4.0"
    const val recycler = "1.2.1"
    const val constraint = "2.1.1"
    const val recyclerSelection = "1.1.0"
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
    val stdLib7 = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    val stdLib8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlinLib}"
    val stdLib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlinLib}"
    val coroutines = CoroutinesDeps
}

object CoroutinesDeps {
    val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
}

object AndroidDeps {
    val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    val core = "androidx.core:core-ktx:${Versions.androidxCore}"
    val legacySupport = "androidx.legacy:legacy-support-v4:${Versions.legacySupport}"
}

object ViewModelDeps {
    val ktx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.viewModel}"
}

object NavigationDeps {
    val fragment = "androidx.navigation:navigation-fragment-ktx:${Versions.nav}"
    val ui = "androidx.navigation:navigation-ui-ktx:${Versions.nav}"
    val dynamicFeature = "androidx.navigation:navigation-dynamic-features-fragment:${Versions.nav}"
    val test = "androidx.navigation:navigation-testing:${Versions.nav}"
}

object LiveData {
    val ktx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.livedataKtx}"
}

object Room {
    val runtime = "androidx.room:room-runtime:${Versions.room}"
    val compiler = "androidx.room:room-compiler:${Versions.room}"
    val ktx = "androidx.room:room-ktx:${Versions.room}"
    val test = "androidx.room:room-testing:${Versions.room}"
}

object Koin {
    val android = "io.insert-koin:koin-android:${Versions.koin}"
    val core = "io.insert-koin:koin-core:${Versions.koin}"
}

object UI {
    val recycler = "androidx.recyclerview:recyclerview:${Versions.recycler}"
    val constraint = "androidx.constraintlayout:constraintlayout:${Versions.constraint}"
    val recyclerSelection = "androidx.recyclerview:recyclerview-selection:${Versions.recyclerSelection}"
}

object Test {
    val junit = "junit:junit:${Versions.junit}"
    val androidJunit = "androidx.test.ext:junit:${Versions.androidJunit}"
    val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
}

