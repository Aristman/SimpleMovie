plugins {
    id("com.squareup.sqldelight")
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    kotlin("plugin.serialization")
    id("com.android.library")
}

version = Releases.sharedVersion

kotlin {
    android()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        ios.deploymentTarget = "14.1"
        framework {
            baseName = "shared"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(Dependencies.Kotlin.coroutines)
                implementation(Dependencies.Kotlin.serialization)
                implementation(Dependencies.Ktor.core)
                implementation(Dependencies.Ktor.logging)
                implementation(Dependencies.Ktor.contentNegotiation)
                implementation(Dependencies.Ktor.serializationJson)
                implementation(Dependencies.SqlDelight.core)
                implementation(Dependencies.SqlDelight.coroutines)
                implementation(Dependencies.SqlDelight.paging3)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(Dependencies.Ktor.android)
                implementation(Dependencies.Ktor.okhttp)
                implementation(Dependencies.SqlDelight.androidDriver)
            }
        }
        val androidTest by getting
    }
}

android {
    compileSdk = AppConfig.completeSdk
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
    }
}

sqldelight {
    database("MovieDatabase") {
        packageName = "ru.marslab.simplemovie.shared.database"
    }
}
