plugins {
    war
    alias(libs.plugins.springBoot)
    alias(libs.plugins.dependencyManagement)
}

group = "com.engine.api-gateway"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.boot:spring-boot-dependencies:${libs.versions.springBoot.get()}")
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${libs.versions.springCloudVersion.get()}")
    }
}

dependencies {
    implementation(project(":shared"))
    implementation(libs.lombok)
    implementation(libs.mapstruct)
    implementation(libs.lombokMapstructBinding)
    implementation(libs.springBootStarterActuator)
    implementation(libs.springBootStarterDataJpa)
    implementation(libs.springBootStarterWeb)
    implementation(libs.springBootStarterSecurity)
    implementation(libs.springBootStarterValidation)
    implementation(libs.springCloudStarterNetflixEurekaClient)
    implementation(libs.springdocOpenapiStarterWebmvcUi)
    testImplementation(libs.springBootStarterTest)
    testImplementation(libs.springSecurityTest)
    testImplementation(libs.junitPlatformLauncher)
    runtimeOnly(libs.postgresql)
    annotationProcessor(libs.lombok)
    annotationProcessor(libs.mapstructProcessor)
}

tasks.withType<JavaCompile> {
    options.annotationProcessorPath = configurations["annotationProcessor"]
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<War> {
    destinationDirectory.set(layout.buildDirectory.dir("services"))
}