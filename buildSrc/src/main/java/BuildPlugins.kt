object BuildPlugins {

    const val androidGradle = "com.android.tools.build:gradle:${Versions.ANDROID_GRADLE_VERSION}"
    const val kotlinGradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.KOTLIN}"
    const val jacocoPlugin = "com.vanniktech:gradle-android-junit-jacoco-plugin:${Versions.JACOCO}"
    const val daggerHilt = "com.google.dagger:hilt-android-gradle-plugin:${Versions.HILT}"
    const val navigation =
        "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.NAVIGATION}"

    const val googleServices = "com.google.gms:google-services:${Versions.GOOGLE_SERVICES}"
    const val fbCrashlytics =
        "com.google.firebase:firebase-crashlytics-gradle:${Versions.FB_CRASHLYTICS_GRADLE}"
    const val fbPerformance = "com.google.firebase:perf-plugin:${Versions.FB_PERFORMANCE_GRADLE}"


}

