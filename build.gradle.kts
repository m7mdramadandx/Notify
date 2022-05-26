buildscript {

    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }

    dependencies {
        classpath(BuildPlugins.androidGradle)
        classpath(BuildPlugins.kotlinGradle)
        classpath(BuildPlugins.navigation)
        classpath(BuildPlugins.daggerHilt)
        classpath(BuildPlugins.googleServices)
        classpath(BuildPlugins.fbCrashlytics)
        classpath(BuildPlugins.fbPerformance)
    }
}

allprojects {

    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
