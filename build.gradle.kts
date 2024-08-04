plugins {
    java
    alias(libs.plugins.springBoot) apply false
    alias(libs.plugins.dependencyManagement) apply false
}

group = "com.engine"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(libs.versions.java.get().toInt())
    }
}
