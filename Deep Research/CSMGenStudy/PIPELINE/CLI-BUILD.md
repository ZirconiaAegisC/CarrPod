# Marmalade CLI Build Guide
## PIPELINE Research — Android Command-Line APK Compilation

### No Android Studio Required
All Marmalade APKs are built from the command line using Gradle. This enables CI/CD, automated builds, and versioning.

### Prerequisites Installation (one-time)
```bash
# Install JDK 17
sudo apt-get install openjdk-17-jdk

# Install Android SDK command-line tools
wget https://dl.google.com/android/repository/commandlinetools-linux-11076708_latest.zip
unzip commandlinetools-linux-*.zip -d $HOME/Android/Sdk/cmdline-tools
export ANDROID_HOME=$HOME/Android/Sdk
export PATH=$PATH:$ANDROID_HOME/cmdline-tools/latest/bin

# Accept licenses
yes | sdkmanager --licenses

# Install required SDK components
sdkmanager "platforms;android-34" "build-tools;34.0.0" "platform-tools"
```

### Build Commands
```bash
# Debug APK (unsigned, for testing)
./gradlew assembleDebug
# APK: app/build/outputs/apk/debug/app-debug.apk

# Release APK (signed, for distribution)
./gradlew assembleRelease
# APK: app/build/outputs/apk/release/app-release.apk

# Clean + Rebuild
./gradlew clean assembleDebug

# Run tests
./gradlew test
./gradlew connectedAndroidTest
```

### APK Signing
```bash
# Generate keystore
keytool -genkey -v -keystore marmalade.keystore -alias marmalade \
    -keyalg RSA -keysize 2048 -validity 10000 \
    -storepass marmalade2024

# Sign APK
apksigner sign --ks marmalade.keystore app-debug.apk

# Verify
apksigner verify app-debug.apk
```

### Build Variants
```kotlin
// build.gradle.kts
buildTypes {
    debug {
        applicationIdSuffix = ".debug"
        isMinifyEnabled = false
    }
    release {
        isMinifyEnabled = true
        proguardFiles(...)
    }
}
```

### Multiple APK Flavors
```kotlin
flavorDimensions += "version"
productFlavors {
    create("free") { dimension = "version" }
    create("pro") { dimension = "version" }
}
```

### CI/CD (GitHub Actions)
```yaml
name: Build APK
on: [push]
jobs:
  build:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v4
      - uses: actions/setup-java@v4
        with: { java-version: '17', distribution: 'temurin' }
      - run: chmod +x gradlew && ./gradlew assembleDebug
      - uses: actions/upload-artifact@v4
        with: { name: marmalade-apk, path: app/build/outputs/apk/debug/ }
```

### Target APIs
- minSdk: 24 (Android 7.0 Nougat)
- targetSdk: 34 (Android 14)
- compileSdk: 34

### Build Script
Run `bash build-marmalade.sh debug` or `bash build-marmalade.sh release` for automated APK generation with keystore handling.
