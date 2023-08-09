plugins {
    application
    kotlin("jvm") version "1.9.0"
}

group = "com.ryctabo.retroscreen"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

application {
    mainClass.set("com.ryctabo.retroscreen.MainKt")
}