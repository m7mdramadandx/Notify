object Libs {
    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.KOTLIN}"
    const val material = "com.google.android.material:material:1.6.0"
    const val gson = "com.google.code.gson:gson:${Versions.GSON_VERSION}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.1.4"

    const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.1"
    const val lifecycleViewModelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:2.4.1"
    const val lifecycleLifeData = "androidx.lifecycle:lifecycle-livedata-ktx:2.4.1"
    const val lifecycleLifeDataCore = "androidx.lifecycle:lifecycle-livedata-core-ktx:2.4.1"

    const val appCompat = "androidx.appcompat:appcompat:1.4.1"
    const val coreKtx = "androidx.core:core-ktx:1.7.0"
    const val multidex = "androidx.multidex:multidex:2.0.1"
    const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.HILT}"
    const val hiltAndroidCompiler = "com.google.dagger:hilt-compiler:${Versions.HILT}"
    const val fragmentKtx = "androidx.fragment:fragment-ktx:1.4.1"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT_VERSION}"
    const val rxAdapter = "com.squareup.retrofit2:adapter-rxjava2:${Versions.RX_RETROFIT_ADAPTER}"
    const val loggingInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.OKHTTP_LOGGING_INTERCEPTOR_VERSION}"
    const val gsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.GSON_CONVERTER}"
    const val googleMap = "com.google.android.gms:play-services-maps:${Versions.GOOGLE_MAP}"
    const val locationServices =
        "com.google.android.gms:play-services-location:${Versions.LOCATION_SERVICES}"
    const val timber = "com.jakewharton.timber:timber:${Versions.TIMBER}"
    const val permissionsDispatcher =
        "com.github.permissions-dispatcher:permissionsdispatcher:${Versions.PERMISSION_DISPATCHER}"
    const val permissionsDispatcherProcessor =
        "com.github.permissions-dispatcher:permissionsdispatcher-processor:${Versions.PERMISSION_DISPATCHER}"
    const val swipeRefresh =
        "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.SWIPE_REFRESH}"
    const val circleImage = "de.hdodenhof:circleimageview:${Versions.CIRCLE_IMAGE}"
    const val glide = "com.github.bumptech.glide:glide:${Versions.GLIDE}"
    const val kaptGlide = "com.github.bumptech.glide:compiler:${Versions.GLIDE}"
    const val retrofitCoroutinesAdapter =
        "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.RETROFIT_COROUTINES_ADAPTER}"
    const val timeFormater = "org.ocpsoft.prettytime:prettytime:${Versions.TIME_FORMATER}"
    const val materialFavouriteButton =
        "com.github.ivbaranov:materialfavoritebutton:${Versions.MATERIAL_FAVOURITE_BUTTON}"

    const val roomRunTime = "androidx.room:room-runtime:${Versions.ROOM}"
    const val kaptRoom = "androidx.room:room-compiler:${Versions.ROOM}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.ROOM}"

//    const val navigationUi = "androidx.navigation:navigation-ui-ktx:2.4.2"
//    const val navigationUi = "androidx.navigation:navigation-ui-ktx:2.4.2"
    const val navigationCompose = "androidx.navigation:navigation-compose:2.4.2"
    const val hiltNavigationCompose = "androidx.hilt:hilt-navigation-compose:1.0.0"
    const val constrainLayoutCompose = "androidx.constraintlayout:constraintlayout-compose:1.0.1"
    const val composeCoil = "io.coil-kt:coil-compose:2.0.0-rc03"

    const val composeTooling = "androidx.compose.ui:ui-tooling:1.1.1"
    const val composeToolingData = "androidx.compose.ui:ui-tooling-data:1.1.1"
    const val composeToolingPreview = "androidx.compose.ui:ui-tooling-preview:1.1.1"
    const val composeFoundation = "androidx.compose.foundation:foundation:1.1.1"
    const val composeUi = "androidx.compose.ui:ui-util:1.1.1"
    const val composeViewBinding = "androidx.compose.ui:ui-viewbinding:1.1.1"
    const val composeMaterial3 = "androidx.compose.material3:material3:1.0.0-alpha12"
    const val composeMaterial3WindowSize =
        "androidx.compose.material3:material3-window-size-class:1.0.0-alpha12"
    const val composeMaterialIconsCore = "androidx.compose.material:material-icons-core:1.1.1"
    const val composeMaterialIconsExtended =
        "androidx.compose.material:material-icons-extended:1.1.1"
    const val composeMaterialRipple = "androidx.compose.material:material-ripple:1.1.1"
    const val composeActivity = "androidx.activity:activity-compose:1.4.0"
    const val composeRuntimeLiveData = "androidx.compose.runtime:runtime-livedata:1.1.1"

    const val accompanistSystemUiController =
        "com.google.accompanist:accompanist-systemuicontroller:0.17.0"
    const val accompanistCoil = "com.google.accompanist:accompanist-coil:0.7.0"
    const val accompanistAppcompatTheme =
        "com.google.accompanist:accompanist-appcompat-theme:0.16.0"
    const val accompanistInsets = "com.google.accompanist:accompanist-insets:0.19.0"
    const val accompanistInsetsUI = "com.google.accompanist:accompanist-insets-ui:0.19.0"
    const val accompanistPermissions = "com.google.accompanist:accompanist-permissions:0.24.6-alpha"
    const val accompanistPager = "com.google.accompanist:accompanist-pager:0.14.0"
    const val accompanistPagerIndicator =
        "com.google.accompanist:accompanist-pager-indicators:0.14.0"
    const val accompanistSwipeRefresh = "com.google.accompanist:accompanist-swiperefresh:0.19.0"
    const val accompanistFlowLayout = "com.google.accompanist:accompanist-flowlayout:0.24.9-beta"

    const val firebaseBoom = "com.google.firebase:firebase-bom:30.0.2"
    const val fbAnalytics = "com.google.firebase:firebase-analytics-ktx"
    const val fbCrashlytics = "com.google.firebase:firebase-crashlytics-ktx"
    const val fbPerformance = "com.google.firebase:firebase-perf-ktx"
    const val fbDynamicLinks = "com.google.firebase:firebase-dynamic-links-ktx"
    const val fbMessaging = "com.google.firebase:firebase-messaging-ktx"


    const val sharedPrefs = "androidx.preference:preference-ktx:1.2.0"
    const val encryptedSharedPrefs = "androidx.security:security-crypto:1.1.0-alpha03"

    const val chuckDebug = "com.github.chuckerteam.chucker:library:${Versions.chuck_Version}"
    const val chuckRelease =
        "com.github.chuckerteam.chucker:library-no-op:${Versions.chuck_Version}"


    const val Lottie = "com.airbnb.android:lottie-compose:4.0.0"

    const val coroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.KTX_COROUTINE}"
    const val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.KTX_COROUTINE}"


    const val exoplayer = "com.google.android.exoplayer:exoplayer:2.16.1"
    const val playCoreKtx = "com.google.android.play:core-ktx:1.8.1"

}