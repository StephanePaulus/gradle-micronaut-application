plugins {
    id("io.micronaut.minimal.application") version "3.7.9"
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