plugins {
    id("io.micronaut.minimal.application") version "3.7.9"
    id("jacoco")
    id("org.sonarqube") version "4.0.0.2929"
    id("com.diffplug.spotless") version "6.18.0"
    id("io.freefair.lombok") version "8.0.1"
    id("com.google.cloud.tools.jib") version "3.3.2"
}

version = "0.1"
group = "example.micronaut"

repositories {
    mavenCentral()
    gradlePluginPortal()
}

micronaut{
    version("3.9.1")
    runtime("netty")
    testRuntime("junit5")
    processing {
        incremental(true)
        annotations("example.micronaut.*")
    }
}

dependencies {
    annotationProcessor("io.micronaut:micronaut-http-validation")

    implementation("io.micronaut:micronaut-http-client")
    implementation("io.micronaut:micronaut-jackson-databind")
    implementation("jakarta.annotation:jakarta.annotation-api")

    runtimeOnly("ch.qos.logback:logback-classic")
}

tasks.jacocoTestReport {
    reports {
        xml.required.set(true)
    }
}

tasks.test {
    finalizedBy(tasks.jacocoTestReport) // report is always generated after tests run
}
sonarqube {
    properties {
        property("sonar.projectKey", "StephanePaulus_gradle-micronaut-application")
        property("sonar.organization", "stephanepaulus")
        property("sonar.host.url", "https://sonarcloud.io")
    }
}

spotless {
    java{
        googleJavaFormat()
    }
}

jib {
    from{
        image="stephanepaulus/base-java17:main"
    }
    to{
        image="stephanepaulus/micronaut-application"
    }
}