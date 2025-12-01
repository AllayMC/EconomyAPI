import com.vanniktech.maven.publish.MavenPublishBaseExtension

plugins {
    id("java-library")
    id("com.vanniktech.maven.publish") version "0.34.0"
    id("org.allaymc.gradle.plugin") version "0.1.2"
}

group = "org.allaymc"
version = "0.1.0-SNAPSHOT"
description = "EconomyAPI is a plugin that unifies all economy plugins under one single API"

allay {
    api = "0.17.0"

    plugin {
        entrance = "org.allaymc.economyapi.Entrance"
        authors += "daoge_cmd"
        website = "https://github.com/AllayMC/EconomyAPI"
    }
}

dependencies {
    compileOnly(group = "org.projectlombok", name = "lombok", version = "1.18.34")
    annotationProcessor(group = "org.projectlombok", name = "lombok", version = "1.18.34")
}

tasks {
    withType<JavaCompile> {
        options.encoding = "UTF-8"
        configureEach {
            options.isFork = true
        }
    }

    // We already have sources jar, so no need to build Javadoc, which would cause a lot of warnings
    withType<Javadoc> {
        enabled = false
    }

    withType<Copy> {
        duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    }
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

configure<MavenPublishBaseExtension> {
    publishToMavenCentral()
    signAllPublications()

    coordinates(project.group.toString(), project.name, project.version.toString())

    pom {
        name.set(project.name)
        description.set("EconomyAPI is a plugin that unifies all economy plugins under one single API")
        inceptionYear.set("2025")
        url.set("https://github.com/AllayMC/EconomyAPI")

        scm {
            connection.set("scm:git:git://github.com/AllayMC/EconomyAPI.git")
            developerConnection.set("scm:git:ssh://github.com/AllayMC/EconomyAPI.git")
            url.set("https://github.com/AllayMC/EconomyAPI")
        }

        licenses {
            license {
                name.set("LGPL 3.0")
                url.set("https://www.gnu.org/licenses/lgpl-3.0.en.html")
            }
        }

        developers {
            developer {
                name.set("AllayMC Team")
                organization.set("AllayMC")
                organizationUrl.set("https://github.com/AllayMC")
            }
        }
    }
}
