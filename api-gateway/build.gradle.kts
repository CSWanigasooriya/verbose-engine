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

dependencies{
	implementation(libs.springBootStarterActuator)
	implementation(libs.springBootStarterWebFlux)
	implementation(libs.springCloudStarterGateway)
	implementation(libs.springCloudStarterConfig)
	implementation(libs.springCloudStarterNetflixEurekaClient)
	testImplementation(libs.springBootStarterTest)
	testImplementation(libs.junitPlatformLauncher)
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.withType<War> {
	destinationDirectory.set(layout.buildDirectory.dir("services"))
}