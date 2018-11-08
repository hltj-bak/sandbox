import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.0"
}

subprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")
}

allprojects {
    group = "me.hltj"
    version = "1.0-SNAPSHOT"

    repositories {
        jcenter()
        mavenCentral()
    }
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}