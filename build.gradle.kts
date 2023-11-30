plugins {
    kotlin("jvm") version "1.9.20"
    application
}

group = "net.codetreats.aoc"
version = "1.0-SNAPSHOT"

application {
    mainClass.set("net.codetreats.aoc.MainKt")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-common:1.9.20")
    implementation("io.reactivex.rxjava3:rxjava:3.1.8")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.2")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "17"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}