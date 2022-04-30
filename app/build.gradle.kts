plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin")
}

android {
    compileSdk = AppConfig.completeSdk

    defaultConfig {
        applicationId = AppConfig.applicationId
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = Releases.versionCode
        versionName = Releases.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
        buildConfigField("String", "baseUrl", "\"https://imdb-api.com\"")
        buildConfigField("Boolean", "logging", "true")
        buildConfigField("String", "databaseName", "\"movie.db\"")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = AppConfig.javaVersion
        targetCompatibility = AppConfig.javaVersion
    }
    kotlinOptions {
        jvmTarget = AppConfig.jvmTarget
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.Compose.core
    }
    packagingOptions {
        resources.apply {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
}

dependencies {

    implementation(project(Module.core))
    implementation(project(Module.shared))

    implementation(Dependencies.Jetpack.core)
    implementation(Dependencies.Jetpack.lifeCycle)
    implementation(Dependencies.JetpackCompose.ui)
    implementation(Dependencies.JetpackCompose.material)
    implementation(Dependencies.JetpackCompose.uiTooling)
    implementation(Dependencies.JetpackCompose.activity)
    implementation(Dependencies.JetpackCompose.constraintLayout)
    implementation(Dependencies.Jetpack.Paging.core)
    implementation(Dependencies.Jetpack.Paging.compose)
    implementation(Dependencies.JetpackCompose.Voyager.core)
    implementation(Dependencies.JetpackCompose.Voyager.viewModel)
    implementation(Dependencies.JetpackCompose.Voyager.hilt)

    implementation(Dependencies.Dagger.hilt)
    kapt(Dependencies.Dagger.hiltCompiler)

    testImplementation(Dependencies.Test.junit)
    androidTestImplementation(Dependencies.Test.junitExt)
    androidTestImplementation(Dependencies.Test.espresso)
    androidTestImplementation(Dependencies.Test.composeUi)
    debugImplementation(Dependencies.JetpackCompose.uiTooling)
}
