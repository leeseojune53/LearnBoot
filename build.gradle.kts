plugins {
    id("java")
    id("com.diffplug.spotless") version "6.25.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

allprojects {
    apply(plugin = "com.diffplug.spotless")

    spotless {
        java {
            palantirJavaFormat()
        }
    }

}
