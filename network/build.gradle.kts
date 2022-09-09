plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = 32

    defaultConfig {
        minSdk = 21
        targetSdk = 32

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    packagingOptions {
        exclude("META-INF/gradle/incremental.annotation.processors")
    }
}

dependencies {

    implementation(Libraries.KTX.CORE)
    implementation(Libraries.KTX.FRAGMENT_KTX)
    implementation(Libraries.KTX.ACTIVITY_KTX)
    implementation(Libraries.AndroidX.APP_COMPAT)
    implementation(Libraries.AndroidX.MATERIAL)
    implementation(Libraries.Coroutine.COROUTINE)

    implementation(Libraries.Network.RETROFIT)
    implementation(Libraries.Network.GSON)
    implementation(Libraries.Network.GSON_CONVERTER)
    implementation(Libraries.Network.SANDWICH)
    implementation(Libraries.Network.INTERCEPTER)
    implementation(Libraries.Network.OKHTTP)

    implementation(Libraries.Hilt.ANDROID)
    implementation(Libraries.Hilt.COMPILER_KAPT)

    testImplementation(Libraries.Test.JUNIT)
    androidTestImplementation(Libraries.AndroidTest.ANDROID_JUNIT)
    androidTestImplementation(Libraries.AndroidTest.ESPRESSO)
}