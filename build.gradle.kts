import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    libs.plugins.run {
        alias(kt.multiplatform)
//        alias(graphql)
    }
}

repositories {
    mavenCentral()
}

val jvmTargetVersion = JvmTarget.JVM_21

kotlin {
    jvmToolchain(jvmTargetVersion.target.toInt())

    jvm {
        compilerOptions {
            jvmTarget = jvmTargetVersion
        }
        testRuns.named("test") {
            executionTask.configure {
                useJUnitPlatform()
            }
        }
    }

    js {
        binaries.executable()
        nodejs()
        useCommonJs()
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.bundles.graphql.client)
                implementation(libs.kt.datetime)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))

                // Need to duplicate the commonMain dependencies here due to a Apollo Plugin bug
//                implementation(libs.bundles.graphql.client)
//                implementation(libs.kt.datetime)
            }
        }
        val jvmMain by getting
        val jvmTest by getting
        val jsMain by getting
        val jsTest by getting
    }
}

//apollo {
//    service("service") {
//        packageName.set("$group.generated.graphql")
//    }
//}
