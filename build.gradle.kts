plugins {
    id("java")
}

group = "com.chosseang"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("com.amazonaws:aws-java-sdk-core:1.12.711")
    implementation("com.amazonaws:aws-java-sdk-kms:1.12.711")

}

tasks.test {
    useJUnitPlatform()
}
