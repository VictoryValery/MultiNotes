pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "MultiNotes"
include(":app")
include(":auth")
include(":dashboard")
include(":note")
include(":core")
include(":common")
include(":domain")
include(":data")
include(":common_ui")
