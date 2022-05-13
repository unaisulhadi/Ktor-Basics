plugins {
    application
    kotlin("jvm") version "1.5.31"
}

group = "org.example"
version = "0.0.1"

repositories {
    mavenCentral()
}

application {
/*

//    Engine Main
    mainClass.set("io.ktor.server.netty.EngineMain")
*/

// Embedded Server
    mainClass.set("com.example.ApplicationKt")
}

dependencies {
    implementation(kotlin("stdlib"))

    implementation("io.ktor:ktor-server-core:1.6.4")
    implementation("io.ktor:ktor-server-netty:1.6.4")
    implementation("ch.qos.logback:logback-classic:1.2.6")
}