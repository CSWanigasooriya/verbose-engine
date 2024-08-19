plugins {
	war
	alias(libs.plugins.springBoot)
	alias(libs.plugins.dependencyManagement)
}

group = "com.engine.eureka-server"
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
	implementation(libs.springCloudStarterNetflixEurekaServer)
	testImplementation(libs.springBootStarterTest)
	testImplementation(libs.springSecurityTest)
	testImplementation(libs.junitPlatformLauncher)
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.withType<War> {
	destinationDirectory.set(layout.buildDirectory.dir("services"))
}