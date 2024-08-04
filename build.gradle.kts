plugins {
	java
	id("org.springframework.boot") version libs.versions.springBoot.get()
	id("io.spring.dependency-management") version libs.versions.springDependencyManagement.get()
}

group = "com.engine"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(libs.versions.java.get().toInt())
	}
}

repositories {
	mavenCentral()
}

extra["springCloudVersion"] = libs.versions.springCloudVersion.get()
extra["springBoot"] = libs.versions.springBoot.get()

dependencies {
	implementation(libs.springBootStarterActuator)
	implementation(libs.springBootStarterDataJpa)
	implementation(libs.springBootStarterDataRedis)
	implementation(libs.springBootStarterSecurity)
	implementation(libs.springBootStarterValidation)
	implementation(libs.springBootStarterWeb)
	implementation(libs.springCloudStarterCircuitbreakerResilience4j)
	implementation(libs.springCloudStarterConfig)
	implementation(libs.springCloudStarterNetflixEurekaClient)
	runtimeOnly(libs.h2)
	runtimeOnly(libs.postgresql)
	testImplementation(libs.springBootStarterTest)
	testImplementation(libs.springSecurityTest)
	testImplementation(libs.junitPlatformLauncher)
}

dependencyManagement {
	imports {
		mavenBom("org.springframework.boot:spring-boot-dependencies:${property("springBoot")}")
		mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
