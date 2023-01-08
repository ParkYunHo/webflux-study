import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.0.1"
    id("io.spring.dependency-management") version "1.1.0"
    id("org.asciidoctor.jvm.convert") version "3.3.2"
    kotlin("jvm") version "1.7.22"
    kotlin("plugin.spring") version "1.7.22"
    kotlin("plugin.jpa") version "1.7.22"
}

group = "com.john"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("io.r2dbc:r2dbc-h2")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springframework.boot:spring-boot-starter-aop")

    runtimeOnly("com.h2database:h2")

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.projectreactor:reactor-test")

    testImplementation("io.cucumber:cucumber-java:7.5.0")
    testImplementation("io.cucumber:cucumber-spring:7.5.0")
    testImplementation("io.cucumber:cucumber-junit-platform-engine:7.5.0")
    testImplementation("org.junit.platform:junit-platform-suite-api")


    implementation("org.springdoc:springdoc-openapi-webflux-core:1.6.9")
    implementation("org.springdoc:springdoc-openapi-webflux-ui:1.6.9")
    implementation("org.springdoc:springdoc-openapi-kotlin:1.6.9")

//    testImplementation("org.springframework.restdocs:spring-restdocs-mockmvc")
//    testImplementation("org.springframework.restdocs:spring-restdocs-asciidoctor")
//    testImplementation("com.epages:restdocs-api-spec-mockmvc:0.16.0")
}

sourceSets {
    test {
        resources {
            srcDirs("src/test/kotlin")
        }
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

////////////////////////////////////////////////////////////////////////////////////////////////


//val snippetsDir by extra { file("build/generated-snippets") }
//
//tasks.withType<Test> {
//    outputs.dir(snippetsDir)
//    useJUnitPlatform()
//}
//
//tasks.asciidoctor {
//    inputs.dir(snippetsDir)
//    dependsOn(tasks.test)
//}
//
//tasks.register("copyHTML", Copy::class) {
//    dependsOn(tasks.asciidoctor)
//    from(file("build/docs/asciidoc"))
//    into(file("src/main/resources/static/docs"))
//}
//
//tasks.build {
//    dependsOn(tasks.getByName("copyHTML"))
//}
//
//tasks.jar {
//    enabled = false
//}
//
//tasks.bootJar {
//    enabled = true
//    dependsOn(tasks.asciidoctor)
//    dependsOn(tasks.getByName("copyHTML"))
//}
