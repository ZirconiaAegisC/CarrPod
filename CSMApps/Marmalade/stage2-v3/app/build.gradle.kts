plugins {
    id("com.android.application")
    kotlin("android")
}
android {
    namespace = "com.carrpod.marmalade.stage2"
    compileSdk = 36
    defaultConfig {
        applicationId = "com.carrpod.marmalade.stage2"
        minSdk = 24
        targetSdk = 35
        versionCode = 3
        versionName = "3.0.0-gemini"
    }
    buildTypes { release { isMinifyEnabled = false } }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions { jvmTarget = "11" }
}
dependencies {
    implementation(kotlin("stdlib"))
}
