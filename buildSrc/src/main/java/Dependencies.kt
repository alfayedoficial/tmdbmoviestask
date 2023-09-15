import Versions.GOOGLE_IDENTIFIER_VERSION

/**
 * Created by ( Eng Ali Al Fayed)
 * Class do : Dependencies Kotlin Kit
 * Date 12/6/2022 - 11:07 AM
 */
object Versions {
    /*-----------Plugin Dependencies-----------*/
    internal const val ANDROID_GRADLE_PLUGIN = "7.2.1"
    internal const val ANDROID_GRADLE_SPOTLESS = "6.7.0"
    internal const val KOTLIN = "1.7.20"
    internal const val KOTLIN_SERIALIZATION_JSON = "1.3.2"
    internal const val KSP = "1.7.10-1.0.6"
    internal const val FIREBASE = "4.3.15"
    internal const val FIREBASE_CRASH = "2.9.7"
    internal const val FIREBASE_DISTRIBUTION = "3.1.1"
    internal const val FIREBASE_ADMIN = "8.0.0"


    /*-----------Config Dependencies-----------*/
    internal const val COMPILE_SDK = 33
    internal const val NDK_VERSION = "24.0.8215888"
    internal const val MIN_SDK_VERSION = 23
    internal const val TARGET_SDK_VERSION = 33
    internal const val VERSION_CODE = 19
    internal const val VERSION_NAME = "1.3.4"

    /*-----------Main Dependencies-----------*/
    internal const val CORE_KTX = "1.9.0"
    internal const val APP_COMPAT_VERSION = "1.6.1"
    internal const val FRAGMENT_KTX_VERSION = "1.5.0"
    internal const val ACTIVITY_KTX_VERSION = "1.5.0"
    internal const val PREFERENCE_KTX_VERSION = "1.2.0"
    internal const val MULTIDEX_VERSION = "2.0.1"

    /*-----------Test Dependencies------------*/
    internal const val APP_Legacy_Support_VERSION = "1.0.0"
    internal const val ESPRESSO_VERSION = "3.4.0"
    internal const val JUNIT_VERSION = "4.13.2"
    internal const val EXT_JUNIT_VERSION = "1.1.3"

    /*-----------UI Dependencies-------------*/
    internal const val MATERIAL_VERSION = "1.9.0"
    internal const val CONSTRAINT_LAYOUT_VERSION = "2.1.4"
    internal const val RECYCLERVIEW_VERSION = "1.3.1"
    internal const val SDP_SSP_VERSION = "1.1.0"
    internal const val PAGING_VERSION = "3.2.0"
    internal const val CIRCLE_IMAGEVIEW_VERSION = "3.1.0"
    internal const val SWIPE_REFRESH_LAYOUT_VERSION = "1.1.0"

    /*-----------Navigation Dependencies-----*/
    internal const val NAVIGATION_VERSION = "2.5.3"

    /*-----------Network Dependencies---------*/
    internal const val RETROFIT_VERSION = "2.9.0"
    internal const val GSON_VERSION = "2.8.9"
    internal const val okHttp_VERSION = "4.9.3"
    internal const val LOG_VERSION = "3.1.0"
    internal const val CHUCK_VERSION = "4.0.0"

    /*-----------Thread Dependencies---------*/
    internal const val COROUTINES_VERSION = "1.6.1"
    internal const val LIFECYCLE_VERSION = "2.5.1"
    internal const val LIFECYCLE_EXT_VERSION = "2.2.0"
    internal const val HILT_VERSION = "2.44"
    internal const val HILT_ANDROID_VERSION = "1.0.0"

    /*-----------Room Dependencies---------*/
    internal const val ROOM_VERSION = "2.5.2"

    /*-----------Google Dependencies---------*/
    internal const val FIREBASE_VERSION = "32.2.3"
    internal const val GOOGLE_LOGIN_VERSION = "20.2.0"
    internal const val FACEBOOK_LOGIN_VERSION = "12.3.0"
    internal const val GOOGLE_MAP_VIEW_VERSION = "0.1.20"
    internal const val GOOGLE_MAP_VERSION = "18.0.2"
    internal const val GOOGLE_LOCATION_VERSION = "20.0.0"
    internal const val GOOGLE_PLACES_VERSION = "17.0.0"
    internal const val GOOGLE_RATE_VERSION = "2.0.1"
    internal const val GOOGLE_IDENTIFIER_VERSION = "18.0.1"
    const val GOOGLE_ZXING_VERSION = "4.3.0"

    /*-----------Github Tools Dependencies---------*/
    internal const val TIMBER = "4.7.1"
    internal const val PERMISSION_DISPATCHER = "4.8.0"
    internal const val COIL_VERSION = "1.3.2"
    internal const val COIL_COMPOS_VERSION = "2.4.0"
    internal const val SHIMMER_VERSION = "0.1.0@aar"
    internal const val LOTTIE_VERSION = "6.1.0"
    internal const val KOTLIN_VERSION = "1.0.13"
    internal const val ANDROID_ANIMATION_VERSION = "2.4@aar"
    internal const val FUEL_VERSION = "2.3.1"
    internal const val GLIDE_VERSION = "4.15.1"
    internal const val IMAGE_PICKER_VERSION = "2.1"
    internal const val DOTS_INDICATOR = "4.3"
    internal const val CCP = "2.6.1"

}

object BuildPlugins {
    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.ANDROID_GRADLE_PLUGIN}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.KOTLIN}"
    const val kotlinSerializationPlugin = "org.jetbrains.kotlin:kotlin-serialization:${Versions.KOTLIN}"
    const val kotlinSerializationJson = "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.KOTLIN_SERIALIZATION_JSON}"
    const val ksp = "com.google.devtools.ksp:com.google.devtools.ksp.gradle.plugin:${Versions.KSP}"
    const val spotlessGradlePlugin = "com.diffplug.spotless:spotless-plugin-gradle:${Versions.ANDROID_GRADLE_SPOTLESS}"
    const val hiltPlugin = "com.google.dagger:hilt-android-gradle-plugin:${Versions.HILT_VERSION}"
    const val firebasePlugin = "com.google.gms:google-services:${Versions.FIREBASE}"
    const val firebaseCrashPlugin = "com.google.firebase:firebase-crashlytics-gradle:${Versions.FIREBASE_CRASH}"
    const val firebaseDistributionPlugin = "com.google.firebase:firebase-appdistribution-gradle:${Versions.FIREBASE_DISTRIBUTION}"
    const val navigationSafeArgsPlugin = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.NAVIGATION_VERSION}"
}

object Modules{
    const val common = ":common"
    const val featureLauncher = ":feature-launcher"
    const val featureMain = ":feature-main"
    const val featureNotification = ":feature-notification"
    const val coreModel = ":core-model"
    const val coreLocal = ":core-local"
    const val coreNetwork = ":core-network"
    const val featureCreateOrder = ":feature-createOrderAsClient"
    const val cropper = ":cropper"

}

object Android {
    const val minSDK = Versions.MIN_SDK_VERSION
    const val ndkVersion = Versions.NDK_VERSION
    const val targetSDK = Versions.TARGET_SDK_VERSION
    const val versionCode = Versions.VERSION_CODE
    const val versionName = Versions.VERSION_NAME
    const val compileSDK = Versions.COMPILE_SDK
    const val applicationId = "com.fourDev.astghfrAllah"
}

object Libs {

    /*-----------Main Dependencies-----------*/
    const val coreExt = "androidx.core:core-ktx:${Versions.CORE_KTX}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.APP_COMPAT_VERSION}"
    const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.FRAGMENT_KTX_VERSION}"
    const val activityKtx = "androidx.activity:activity-ktx:${Versions.ACTIVITY_KTX_VERSION}"
    const val preferenceKtx = "androidx.preference:preference-ktx:${Versions.PREFERENCE_KTX_VERSION}"
    const val multidex = "androidx.multidex:multidex:${Versions.MULTIDEX_VERSION}"
    const val kotlinSerializationJson = "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.KOTLIN_SERIALIZATION_JSON}"

    /*-----------UI Dependencies-------------*/
    const val material = "com.google.android.material:material:${Versions.MATERIAL_VERSION}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT_VERSION}"
    const val recyclerview = "androidx.recyclerview:recyclerview:${Versions.RECYCLERVIEW_VERSION}"
    const val swipeRefreshLayout = "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.SWIPE_REFRESH_LAYOUT_VERSION}"
    const val circleImageview = "de.hdodenhof:circleimageview:${Versions.CIRCLE_IMAGEVIEW_VERSION}"
    const val sdp = "com.intuit.sdp:sdp-android:${Versions.SDP_SSP_VERSION}"
    const val ssp = "com.intuit.ssp:ssp-android:${Versions.SDP_SSP_VERSION}"
    const val pagingCommon = "androidx.paging:paging-common-ktx:${Versions.PAGING_VERSION}"
    const val pagingRuntime = "androidx.paging:paging-runtime-ktx:${Versions.PAGING_VERSION}"
    const val svgLibrary = "com.caverock:androidsvg-aar:1.4"
    /*-----------Navigation Dependencies-----*/
    const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.NAVIGATION_VERSION}"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.NAVIGATION_VERSION}"
    const val navigationDynamic = "androidx.navigation:navigation-dynamic-features-fragment:${Versions.NAVIGATION_VERSION}"

    /*-----------Network Dependencies---------*/
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT_VERSION}"
    const val converterMoshi = "com.squareup.retrofit2:converter-moshi:${Versions.RETROFIT_VERSION}"
    const val converterGson = "com.squareup.retrofit2:converter-gson:${Versions.RETROFIT_VERSION}"
    const val gson = "com.google.code.gson:gson:${Versions.GSON_VERSION}"
    const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp_VERSION}"
    const val okhttpLogging = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp_VERSION}"
    const val loggingInterceptor = "com.github.ihsanbal:LoggingInterceptor:${Versions.LOG_VERSION}"
    const val chuck = "com.github.chuckerteam.chucker:library:${Versions.CHUCK_VERSION}"

    /*-----------Thread Dependencies---------*/
    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.COROUTINES_VERSION}"
    const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINES_VERSION}"
    const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.HILT_VERSION}"
    const val hiltDaggerCompiler = "com.google.dagger:hilt-compiler:${Versions.HILT_VERSION}"
    const val hiltDaggerAndroidCompiler = "com.google.dagger:hilt-android-compiler:${Versions.HILT_VERSION}"
    const val hiltHiltCompiler = "androidx.hilt:hilt-compiler:${Versions.HILT_ANDROID_VERSION}"
    const val hiltHiltNavigationComposeCompiler = "androidx.hilt:hilt-navigation-compose:${Versions.HILT_ANDROID_VERSION}"
    const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.LIFECYCLE_EXT_VERSION}"
    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.LIFECYCLE_VERSION}"
    const val lifecycleCore = "androidx.lifecycle:lifecycle-livedata-core-ktx:${Versions.LIFECYCLE_VERSION}"
    const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.LIFECYCLE_VERSION}"
    const val lifecycleLiveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.LIFECYCLE_VERSION}"

    /*-----------Room Dependencies---------*/
    const val roomKtx = "androidx.room:room-ktx:${Versions.ROOM_VERSION}"
    const val roomRuntime = "androidx.room:room-runtime:${Versions.ROOM_VERSION}"
    const val roomPagin = "androidx.room:room-paging:${Versions.ROOM_VERSION}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.ROOM_VERSION}"

    /*-----------Google Dependencies---------*/
    const val firebaseBom = "com.google.firebase:firebase-bom:${Versions.FIREBASE_VERSION}"
    const val firebaseCrashlyticsKtx = "com.google.firebase:firebase-crashlytics-ktx"
    const val firebaseAnalyticsKtx = "com.google.firebase:firebase-analytics-ktx"
    const val firebaseMessagingKtx = "com.google.firebase:firebase-messaging-ktx"
    const val firebaseAuthKtx = "com.google.firebase:firebase-auth-ktx"
    const val firebaseDatabaseKtx = "com.google.firebase:firebase-database-ktx"
    const val firebaseStorageKtx = "com.google.firebase:firebase-storage-ktx"
    const val firebaseRemoteConfigKtx = "com.google.firebase:firebase-config-ktx"
    const val firebaseDynamicLinkKtx = "com.google.firebase:firebase-dynamic-links-ktx"
    const val firebaseAdmin = "com.google.firebase:firebase-admin:${Versions.FIREBASE_ADMIN}"
    const val googleIdentifier = "com.google.android.gms:play-services-ads-identifier:${GOOGLE_IDENTIFIER_VERSION}"
    const val googleLoginKtx = "com.google.android.gms:play-services-auth:${Versions.GOOGLE_LOGIN_VERSION}"
    const val facebookLoginKtx = "com.facebook.android:facebook-android-sdk:${Versions.FACEBOOK_LOGIN_VERSION}"
    const val googleRateKtx = "com.google.android.play:review-ktx:${Versions.GOOGLE_RATE_VERSION}"

    const val googleMapView = "com.google.maps:google-maps-services:${Versions.GOOGLE_MAP_VIEW_VERSION}"
    const val googleMapServices = "com.google.android.gms:play-services-maps:${Versions.GOOGLE_MAP_VERSION}"
    const val googleLocationServices = "com.google.android.gms:play-services-location:${Versions.GOOGLE_LOCATION_VERSION}"
    const val googlePlacesServices = "com.google.android.gms:play-services-places:${Versions.GOOGLE_PLACES_VERSION}"
    const val googleZxingEmbedded = "com.journeyapps:zxing-android-embedded:${Versions.GOOGLE_ZXING_VERSION}"

    /*-----------Github Tools Dependencies---------*/
    const val permissionsDispatcher = "com.github.permissions-dispatcher:permissionsdispatcher:${Versions.PERMISSION_DISPATCHER}"
    const val permissionsDispatcherProcessor = "com.github.permissions-dispatcher:permissionsdispatcher-processor:${Versions.PERMISSION_DISPATCHER}"
    const val timber = "com.jakewharton.timber:timber:${Versions.TIMBER}"
    const val coil = "io.coil-kt:coil:${Versions.COIL_VERSION}"
    const val coilCompose = "io.coil-kt:coil-compose:${Versions.COIL_COMPOS_VERSION}"
    const val shimmer = "com.facebook.shimmer:shimmer:${Versions.SHIMMER_VERSION}"
    const val lottie = "com.airbnb.android:lottie:${Versions.LOTTIE_VERSION}"
    const val kotlinUtils = "com.github.alfayedoficial:kotlinUtils:${Versions.KOTLIN_VERSION}"
    const val androidAnimations = "com.daimajia.androidanimations:library:${Versions.ANDROID_ANIMATION_VERSION}"
    const val fuel = "com.github.kittinunf.fuel:fuel:${Versions.FUEL_VERSION}"
    const val fuelAndroid = "com.github.kittinunf.fuel:fuel-android:${Versions.FUEL_VERSION}"
    const val fuelCoroutines = "com.github.kittinunf.fuel:fuel-coroutines:${Versions.FUEL_VERSION}"
    const val glide = "com.github.bumptech.glide:glide:${Versions.GLIDE_VERSION}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.GLIDE_VERSION}"
    const val imagePicker = "com.github.dhaval2404:imagepicker:${Versions.IMAGE_PICKER_VERSION}"
    const val dotsIndicator = "com.tbuonomo:dotsindicator:${Versions.DOTS_INDICATOR}"
    const val ccpCountry = "com.hbb20:ccp:${Versions.CCP}"
    const val jodaTime = "joda-time:joda-time:2.12.1"

}

object TestLibs {

    /*-----------Test Dependencies------------*/
    const val legacySupport = "androidx.legacy:legacy-support-v4:${Versions.APP_Legacy_Support_VERSION}"
    const val junit = "junit:junit:${Versions.JUNIT_VERSION}"
    const val extJunit = "androidx.test.ext:junit:${Versions.EXT_JUNIT_VERSION}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.ESPRESSO_VERSION}"
    const val navigationTesting = "androidx.navigation:navigation-testing:${Versions.NAVIGATION_VERSION}"
    const val roomTesting = "androidx.room:room-testing:${Versions.ROOM_VERSION}"

}

object Config {

    const val RELEASE_STORE_FILE_MAC="/Users/alial-shahatali/StudioProjects/4fdev/astghfer/Astagfirullah_v3/app/keystore/4fDev.keystore"
    const val RELEASE_STORE_PASS = "1213321994"
    const val RELEASE_ALIAS = "app"
    const val RELEASE_KEY_PASS = "1213321994"
}

