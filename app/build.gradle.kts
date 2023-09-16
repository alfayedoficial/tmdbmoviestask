plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id ("org.jetbrains.kotlin.kapt")
    id("com.google.dagger.hilt.android")

}

android {
    namespace = "com.alialfayed.tmdbmoviestask"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.alialfayed.tmdbmoviestask"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }

    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    /*-----------Main Dependencies-----------*/
    implementation(Libs.coreExt)
    implementation(Libs.appCompat)
    implementation(Libs.fragmentKtx)
    implementation(Libs.activityKtx)
    implementation(Libs.preferenceKtx)

    /*-----------UI Dependencies-------------*/
    implementation(Libs.material)
    implementation(Libs.swipeRefreshLayout)
    implementation(Libs.constraintLayout)
    implementation(Libs.recyclerview)
    implementation(Libs.sdp)
    implementation(Libs.ssp)
    implementation(Libs.pagingRuntime)
    implementation(Libs.coilCompose)
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation( "androidx.lifecycle:lifecycle-runtime-compose:2.6.2")
    implementation( "androidx.lifecycle:lifecycle-viewmodel-compose:2.6.2")

    implementation("androidx.activity:activity-compose:1.7.2")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")

    implementation( "androidx.paging:paging-runtime-ktx:3.2.1")
    implementation( "androidx.paging:paging-compose:3.2.1")




    /*-----------Thread Dependencies---------*/
    implementation(Libs.coroutinesAndroid)
    implementation(Libs.coroutinesCore)
    implementation (Libs.lifecycleExtensions)
    implementation (Libs.lifecycleRuntime)
    implementation (Libs.lifecycleViewModel)
    implementation (Libs.lifecycleLiveData)
    implementation(Libs.hiltAndroid)
    testImplementation("junit:junit:4.12")
    kapt(Libs.hiltDaggerCompiler)
    kapt(Libs.hiltDaggerAndroidCompiler)
    implementation(Libs.hiltHiltNavigationComposeCompiler)


    /*-----------Network Dependencies-----*/
    implementation(Libs.retrofit)
    implementation(Libs.okhttp)
    implementation(Libs.converterMoshi)
    implementation(Libs.loggingInterceptor)

    /*-----------Room Dependencies---------*/
    implementation(Libs.roomKtx)
    implementation(Libs.roomRuntime)
    implementation(Libs.roomPagin)
    kapt(Libs.roomCompiler)


    implementation ("androidx.test:core:1.5.0")
    testImplementation("junit:junit:4.13.2")
    testImplementation("androidx.test:core:1.5.0")
    testImplementation("androidx.test:runner:1.5.2")
    testImplementation("androidx.test:rules:1.5.0")
    testImplementation("org.hamcrest:hamcrest-all:1.3")
    testImplementation("org.robolectric:robolectric:4.10.3")
    testImplementation("org.mockito:mockito-core:5.1.1")
    testImplementation("com.google.truth:truth:1.1.5")
    testImplementation("androidx.arch.core:core-testing:2.2.0")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.1")


    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

}