import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("java")
    kotlin("jvm") version "1.5.10"
    id("com.bnorm.robocode") version "0.1.1"
}

group = "ufba.unidade.um.robots"
version = "1.0-SNAPSHOT"


val robocodeVersion = "1.9.4.5"
val robotClass: String by project
val battleFile: String by project
val robocodeHome: String by project

// extra properties
val robotJarFileName = "$robotClass.jar"
val buildBattleDir = "$rootDir/setup/battles/"
val buildBattleFile = buildBattleDir + battleFile
val robocodeBattlesDir = "$robocodeHome/battles/"
val robocodeBattleFile = robocodeBattlesDir + battleFile


repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("org.awaitility:awaitility-kotlin:4.1.0")
    // Robocode libs
    implementation("net.sf.robocode:robocode.api:${robocodeVersion}")
    implementation("net.sf.robocode:robocode.samples:${robocodeVersion}")
    implementation("net.sf.robocode:robocode.battle:${robocodeVersion}")
    implementation("net.sf.robocode:robocode.repository:${robocodeVersion}")
    implementation("net.sf.robocode:robocode.core:${robocodeVersion}")

}

tasks.test {
    useJUnitPlatform()
}

//tasks.register("toJar", Jar::class) {
//    group = "robocode"
//    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
//
//    manifest {
//        mapOf(
//            "Main-Class" to robotClass,
//            "Class-Path" to configurations
//                .runtimeClasspath
//                .get()
//                .joinToString(separator = " ") { f -> "libs/${f.name}"},
//            "robots" to robotClass
//        )
//    }
//}

// ## The script below does exactly the same that script above do
robocode {
    download = false
    robots {
        register("HolyfieldRobot") {
            classPath=configurations
                .runtimeClasspath
                .get()
                .joinToString(separator = " ") { f -> "libs/${f.name}"}
        }
    }
}

val cleanTask = task("cleanTask") {
    group = "robocode"

    doFirst{
        val robotsPath = "$robocodeHome/robots"
        delete {
            fileTree(robotsPath).matching {
                include("**/$robotJarFileName")
                include("**/robot.database")
            }
        }

        delete {


        }
    }
}

tasks.clean {
    dependsOn(cleanTask)
}

java {
    sourceCompatibility = org.gradle.api.JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "11"
}
