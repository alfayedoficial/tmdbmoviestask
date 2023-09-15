pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven(url = "https://jitpack.io")
    }

    resolutionStrategy {
        eachPlugin {
            when(requested.id.id){
                "dagger.hilt.android.plugin" ->{useModule("com.google.dagger:hilt-android-gradle-plugin:2.44")}
            }

        }
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven(url = "https://jitpack.io")
    }
}

rootProject.name = "TMDb Movies Task"
include(":app")
 