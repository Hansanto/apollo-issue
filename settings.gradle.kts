pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            version("kotlin", "2.0.0")
            version("kotlinx-datetime", "0.6.0")
            version("graphql", "4.0.0-beta.6")

            plugin("kt-multiplatform", "org.jetbrains.kotlin.multiplatform").versionRef("kotlin")
            plugin("graphql", "com.apollographql.apollo3").versionRef("graphql")

            library("kt-datetime", "org.jetbrains.kotlinx", "kotlinx-datetime").versionRef("kotlinx-datetime")

            library("graphql-runtime", "com.apollographql.apollo3", "apollo-runtime").versionRef("graphql")
            library("graphql-ktor", "com.apollographql.apollo3", "apollo-engine-ktor").versionRef("graphql")

            bundle("graphql-client", listOf("graphql-runtime", "graphql-ktor"))
        }
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

rootProject.name = "apollo-issue"
