buildscript {
    repositories {
        google()
        mavenCentral()
        maven (url = "https://plugins.gradle.org/m2/")
        maven (url = "https://jitpack.io")
    }

    dependencies{
        classpath(BuildPlugins.navigationSafeArgsPlugin)
        classpath(BuildPlugins.hiltPlugin)
    }
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.0" apply false
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false
}