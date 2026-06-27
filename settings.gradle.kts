pluginManagement {
    repositories {
        mavenLocal()
        mavenCentral()
        gradlePluginPortal()
        maven("https://maven.neoforged.net/releases/") { name = "NeoForged" }
        maven("https://maven.kikugie.dev/snapshots") { name = "KikuGie" }
        maven("https://maven.kikugie.dev/releases") { name = "KikuGie Releases" }
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.9.0"
    id("dev.kikugie.stonecutter") version "0.7"
}

stonecutter {
    create(rootProject) {
        fun match(version: String) {
            vers(version, version).buildscript = "build.gradle.kts"
        }

        match("26.1.2")

        vcsVersion = "26.1.2"
    }
}