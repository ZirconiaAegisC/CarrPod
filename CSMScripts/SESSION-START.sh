# CarrPod Cloud Session Startup — One Command

# This is the recommended first command to run in any new cloud session.
# It bootstraps the complete No-Gradle Android APK build toolchain.

bash CSMScripts/SDKForge.sh && eval "$(bash CSMScripts/SDKForge.sh --export-env)"

# After this, you can build any APK:
#   cd CSMApps/Bounce/v1.0.79 && bash build.sh
#   cd CSMApps/Marmalade/v7c && bash build.sh
