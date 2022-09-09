plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        applicationId = "com.zerodeg.architecture"
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = AppConfig.testInstrumentationRunner
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(Libraries.KTX.CORE)
    implementation(Libraries.AndroidX.APP_COMPAT)
    implementation(Libraries.AndroidX.MATERIAL)
    implementation(Libraries.AndroidX.CONSTRAINT_LAYOUT)

    implementation(Libraries.Hilt.ANDROID)
    implementation(Libraries.Hilt.COMPILER_KAPT)

    implementation(Libraries.Log.TIMBER)

    implementation(Libraries.LifeCycle.LIVE_DATA)
    implementation(Libraries.LifeCycle.VIEW_MODEL)

    implementation(Libraries.Navigation.FRAGMENT_KTX)
    implementation(Libraries.Navigation.UI_KTX)

    testImplementation(Libraries.Test.JUNIT)
    testImplementation(Libraries.AndroidTest.ANDROID_JUNIT)
    testImplementation(Libraries.AndroidTest.ESPRESSO)

}