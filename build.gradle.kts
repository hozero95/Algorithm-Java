plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    // https://mvnrepository.com/artifact/junit/junit
    testImplementation("junit:junit:4.13.2")

    // https://mvnrepository.com/artifact/com.tngtech.java/junit-dataprovider
    testImplementation("com.tngtech.java:junit-dataprovider:1.13.1")
}

tasks.test {
    useJUnitPlatform()
}