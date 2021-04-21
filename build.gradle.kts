plugins {
    id("org.jetbrains.kotlin.js") version Versions.kotlin
    id("io.github.gradle-nexus.publish-plugin") version Versions.nexus
    id("maven-publish")
    id("signing")
}

group = "dev.chriskrueger"
version = Versions.versionName

nexusPublishing {
    repositories {
        sonatype {
            nexusUrl.set(uri("https://s01.oss.sonatype.org/service/local/"))
            snapshotRepositoryUrl.set(uri("https://s01.oss.sonatype.org/content/repositories/snapshots/"))
            username.set(findProperty("SONATYPE_USER") as String?)
            password.set(findProperty("SONATYPE_PASSWORD") as String?)
            stagingProfileId.set(findProperty("SONATYPE_STAGING_PROFILE_ID_CHRISKRUEGER") as String?)
        }
    }
}

repositories {
    google()
    gradlePluginPortal()
    mavenCentral()
    mavenLocal()
}

base {
    archivesBaseName = "kotlin-express"
}

kotlin {
    js {
        nodejs()
    }
}

dependencies {
    implementation(kotlin("stdlib-js"))
}

val sourcesJar by tasks.creating(Jar::class) {
    archiveClassifier.set("sources")
    from("$projectDir/src")
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            artifact(sourcesJar)
            from(components["kotlin"])

            pom {
                name.set("kotlin-express")
                description.set("Kotlin wrapper for Express API.")
                url.set("https://github.com/chrisnkrueger/kotlin-express")
                inceptionYear.set("2021")
                packaging = "jar"

                developers {
                    developer {
                        id.set("chriskrueger")
                        name.set("Christian Krüger")
                        email.set("christian.krueger@moviebase.app")
                    }
                }
                licenses {
                    license {
                        name.set("The Apache Software License, Version 2.0")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }
                issueManagement {
                    system.set("GitHub Issues")
                    url.set("https://github.com/chrisnkrueger/kotlin-express/issues")
                }
                scm {
                    connection.set("scm:git:https://github.com/chrisnkrueger/kotlin-express.git")
                    developerConnection.set("scm:git:git@github.com:chrisnkrueger/kotlin-express.git")
                    url.set("https://github.com/chrisnkrueger/${project.name}")
                }
            }
        }
    }
}

signing {
    sign(publishing.publications)
}

