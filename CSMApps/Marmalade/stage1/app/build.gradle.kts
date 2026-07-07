plugins {
    id("com.android.application")
    kotlin("android")
}
android {
    namespace = "com.carrpod.marmalade.stage1"
    compileSdk = 33
    defaultConfig {
        applicationId = "com.carrpod.marmalade.stage1"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0.0-stage1"
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
