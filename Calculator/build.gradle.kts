plugins {
    alias(libs.plugins.kotlinJvm)

    alias(libs.plugins.versionUpdate)
    alias(libs.plugins.catalogUpdate)
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(libs.logback)

    testImplementation(libs.junit)
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}

kotlin {
    jvmToolchain(17)
}


