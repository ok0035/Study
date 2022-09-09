plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
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

    packagingOptions {
        exclude("META-INF/gradle/incremental.annotation.processors")
    }
}

dependencies {

    implementation(project(":network"))

    implementation(Libraries.KTX.CORE)
    implementation(Libraries.AndroidX.APP_COMPAT)
    implementation(Libraries.AndroidX.MATERIAL)
    implementation(Libraries.AndroidX.CONSTRAINT_LAYOUT)

    implementation(Libraries.KTX.FRAGMENT_KTX)
    implementation(Libraries.KTX.ACTIVITY_KTX)

    implementation(Libraries.Hilt.ANDROID)
    kapt(Libraries.Hilt.COMPILER_KAPT)

    implementation(Libraries.Network.RETROFIT)
    implementation(Libraries.Network.GSON)
    implementation(Libraries.Network.GSON_CONVERTER)
    implementation(Libraries.Network.SANDWICH)
    implementation(Libraries.Network.INTERCEPTER)
    implementation(Libraries.Network.OKHTTP)

    implementation(Libraries.Log.TIMBER)

    implementation(Libraries.LifeCycle.LIVE_DATA)
    implementation(Libraries.LifeCycle.VIEW_MODEL)

    implementation(Libraries.Navigation.FRAGMENT_KTX)
    implementation(Libraries.Navigation.UI_KTX)

    testImplementation(Libraries.Test.JUNIT)
    testImplementation(Libraries.AndroidTest.ANDROID_JUNIT)
    testImplementation(Libraries.AndroidTest.ESPRESSO)

}