plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "yoon.tutorials.navigationsample"
    compileSdk = 34

    defaultConfig {
        applicationId = "yoon.tutorials.navigationsample"
        minSdk = 24
        targetSdk = 34
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
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    val nav_version = "2.7.4"

    // Jetpack Compose integration
    // Navigation Compose
    // Navigation Compose 라이브러리를 사용하여 Jetpack Compose와 Navigation을 통합
    // Navigation Compose 라이브러리는 Jetpack Compose와 Navigation을 통합하는 기능을 제공
    // Navigation Compose 라이브러리를 사용하면 Jetpack Compose에서 Navigation을 쉽게 사용할 수 있음
    implementation("androidx.navigation:navigation-compose:$nav_version")
    //오류버전
//    implementation("androidx.core:core-ktx:1.12.0")
    //정상버전
    implementation("androidx.core:core-ktx:1.12.0")
    // 이 라이브러리는 LifecycleOwner 및 LifecycleObserver와 같은 컴포넌트를 더 쉽게 사용할 수 있게 합니다.
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")

    // Jetpack Compose와 Activity를 통합하는 기능을 제공합니다.
    implementation("androidx.activity:activity-compose:1.8.0")
    //compose-bom:2023.08.00
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
    // Compose UI Testing
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}