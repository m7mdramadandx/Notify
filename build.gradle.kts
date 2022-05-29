buildscript {

    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }

    dependencies {
        classpath(Build.androidGradle)
        classpath(Build.kotlinGradle)
        classpath(Build.navigation)
        classpath(Build.daggerHilt)
        classpath(Build.googleServices)
        classpath(Build.fbCrashlytics)
        classpath(Build.fbPerformance)
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
