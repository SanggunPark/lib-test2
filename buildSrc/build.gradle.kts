import org.gradle.kotlin.dsl.`kotlin-dsl`

plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
    `maven-publish`
}

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}