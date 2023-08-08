plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("maven-publish")
}

android {
    namespace = "com.metaverse.world.testlib2"
    compileSdk = 33

    defaultConfig {
        minSdk = 23

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
}

dependencies {

    implementation(Dependencies.coreKtx)
    implementation(Dependencies.kotlinSerialization)
    implementation(group = "commons-codec", name = "commons-codec", version = "1.15")
    retrofit()
    okHttp()
    coroutines()
    koin()
    implementation(Dependencies.googlePlayServicesAuth)
    implementation(Dependencies.timber)
    kotest()
    androidTest()

    testImplementation("io.kotest.extensions:kotest-extensions-koin:1.1.0")
}

group = "com.github.SanggunPark"
version = "1.0.0"

afterEvaluate {
    publishing {
        publications {
            register<MavenPublication>("release") {
                afterEvaluate { from(components["release"]) }
                artifact(tasks.getByName("sourcesJar"))
                groupId = "com.github.SanggunPark"
                artifactId = "test-lib2"
                version = "1.0.0"

                // Mostly self-explanatory metadata
                pom {
                    name.set("Test Library")
                    description.set("Test")
                    url.set("https://github.com/SanggunPark/lib-test")
                    licenses {
                        license {
                            name.set("The Apache License, Version 2.0")
                            url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                        }
                    }
                    developers {
                        developer {
                            id.set("SanggunPark")
                            name.set("Sanggun Park")
                            email.set("psgxxx@nm-metaworld.com")
                        }
                    }

                }

            }

        }
    }
}