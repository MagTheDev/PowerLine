@file:Suppress(
    "SpellCheckingInspection", "SpellCheckingInspection",
    "SpellCheckingInspection", "SpellCheckingInspection", "SpellCheckingInspection", "SpellCheckingInspection"
)

plugins {
    kotlin("jvm") version "1.8.0"
    id("org.jetbrains.kotlinx.dataframe") version "0.13.1"
}

group = "dev.magthe"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.jetbrains.kotlinx:dataframe:0.13.1")
    implementation("org.jetbrains.kotlinx:dataframe-excel:0.13.1")

}

tasks.test {
    useJUnitPlatform()
}