plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
    id("com.google.gms.google-services")
    id("com.google.firebase.crashlytics")
    id("dagger.hilt.android.plugin")
    id("com.github.triplet.play") version "3.7.0"
//    id "demo.kotlin-application-conventions"

}
android {
    compileSdk = Config.compileSDK
    buildToolsVersion = Config.buildToolsVersion

    signingConfigs {
        getByName("debug") {
            storeFile = file("D:\\android projects\\Notify\\app\\keyStore.jks")
            storePassword = "notify_password"
            keyAlias = "notify"
            keyPassword = "notify_password"
        }

        //        create("signingConfigRelease") {
//            storeFile = file(KeyHelper.getValue(KeyHelper.KEY_STORE_FILE))
//            storePassword = KeyHelper.getValue(KeyHelper.KEY_STORE_PASS)
//            keyAlias = KeyHelper.getValue(KeyHelper.KEY_ALIAS)
//            keyPassword = KeyHelper.getValue(KeyHelper.KEY_PASS)
//        }
    }

//    signingConfigs {
//        config {
//            storeFile file ("D:\\androidProjects\\Notify\\app\\keyStore.jks")
//            storePassword "99141000dx"
//            keyAlias "mhmd"
//            keyPassword "123Mhmd123"
//        }
//    }

    defaultConfig {
        applicationId = Config.applicationId
        minSdk = Config.minSDK
        targetSdk = Config.targetSDK
        versionCode = Config.versionCode
        versionName = Config.versionName
        multiDexEnabled = true
        setProperty("archivesBaseName", "$applicationId-v$versionName($versionCode)")
//        resourceConfigurations = "en"
//        ndk {
//            abiFilters("armeabi-v7a", "x86", "arm64-v8a", "x86_64")
//        }
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables { useSupportLibrary = true }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
//            extra["enableCrashlytics,enableAnalytics,enablePerformance"] = true
        }
        getByName("debug") {
            applicationIdSuffix = ".debug"
            versionNameSuffix = "-dev"
            isDebuggable = true
        }
    }

    android.applicationVariants.all { variant ->
        variant.outputs.all { it ->
            it.outputFile.renameTo(File("base-${variant.versionName}(${variant.versionCode}).apk"))
        }
    }

    play {
        defaultToAppBundles.set(true)
        track.set("internal")
        updatePriority.set(2)
        serviceAccountCredentials.set(file("key.json"))
    }

    compileOptions {
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
//
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
//        useIR = true
    }

    buildFeatures { compose = true }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.COMPOSE
//        kotlinCompilerVersion = Versions.KOTLIN
    }
    packagingOptions {
        exclude("META-INF/notice.txt")
    }

    bundle {
        language { enableSplit = true }
        density { enableSplit = true }
        abi { enableSplit = true }
    }

    lintOptions {
        isAbortOnError = false
        isIgnoreWarnings = true
        isQuiet = true
    }

}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation(Libs.coreKtx)
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:1.1.5")

    // Firebase
    implementation(platform(Libs.firebaseBoom))
    implementation(Libs.fbAnalytics)
    implementation(Libs.fbCrashlytics)
    implementation(Libs.fbPerformance)
    implementation(Libs.fbMessaging)

    // Encrypted shared Prefs
    implementation(Libs.sharedPrefs)
    implementation(Libs.encryptedSharedPrefs)


    testImplementation(TestLibs.junit)
    testImplementation(TestLibs.archCoreTesting)
    testImplementation(TestLibs.mockk)
    testImplementation("com.google.dagger:hilt-android-testing:2.42")
    kaptTest("com.google.dagger:hilt-android-compiler:2.42")

    androidTestImplementation("com.google.dagger:hilt-android-testing:2.42")
    kaptAndroidTest("com.google.dagger:hilt-android-compiler:2.42")


//    //  LiveData
//    def lifecycle_version = "2.4.1"
//    implementation "androidx.lifecycle:lifecycle-runtime-ktx:$lifecycle_version"

//    // ViewModel
//    implementation "androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03"

    // Coroutines
    implementation(Libs.coroutinesCore)
    implementation(Libs.coroutinesAndroid)

//    //  Dagger - Hilt
    implementation(Libs.hiltAndroid)
    kapt(Libs.hiltAndroidCompiler)
    implementation(Libs.hiltNavigationCompose)
//    kapt "androidx.hilt:hilt-compiler:1.0.0"

//    //Play Services
//    implementation "com.google.android.gms:play-services-base:18.0.1"
//    implementation "com.google.android.gms:play-services-ads:20.6.0"
//
//    // Play Core
    implementation(Libs.playCoreKtx)
//
    // RoomDB
    implementation(Libs.roomRunTime)
    kapt(Libs.kaptRoom)
    implementation(Libs.roomKtx)

//    // Integration with activities
    implementation(Libs.composeActivity)
//
//    // UI Tests
//    androidTestImplementation "androidx.compose.ui:ui-test-junit4:$compose_version"

//    implementation(Libs.composeViewBinding)
//    implementation(Libs.composeRuntimeLiveData)
    implementation(Libs.lifecycleViewModelCompose)

    implementation(Libs.composeUi)
    implementation(Libs.constrainLayoutCompose)
//
//    // Tooling support (Previews, etc.)
    implementation(Libs.composeTooling)
    debugImplementation(Libs.composeTooling)
    implementation(Libs.composeToolingPreview)
//
//    // Foundation (Border, Background, Box, Image, Scroll, shapes, animations, etc.)
    implementation(Libs.composeFoundation)
//
//    // Material Design
    implementation(Libs.composeMaterial3)
    implementation(Libs.composeMaterial3WindowSize)
    implementation(Libs.composeMaterialIconsCore)
    implementation(Libs.composeMaterialIconsExtended)

    // Integration with observables
    implementation(Libs.composeRuntimeLiveData)

//    // When using a MDC theme
//    implementation "com.google.android.material:compose-theme-adapter:1.1.10"
//
//    // Navigation
    implementation(Libs.navigationCompose)
    implementation(Libs.hiltNavigationCompose)

    implementation(Libs.accompanistAppcompatTheme)
    implementation(Libs.accompanistInsets)
    implementation(Libs.accompanistInsetsUI)
    implementation(Libs.accompanistSystemUiController)
    implementation(Libs.accompanistFlowLayout)
    implementation(Libs.accompanistPager)
    implementation(Libs.accompanistPagerIndicator)

}

repositories {
    mavenCentral()
}
