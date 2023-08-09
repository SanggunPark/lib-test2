plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    `maven-publish`
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

    publishing {
        singleVariant("release") {
            withSourcesJar()
            withJavadocJar()
        }
    }
}

dependencies {
    implementation ("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")
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

afterEvaluate {
    publishing {
        publications {
            register<MavenPublication>("release") {
                afterEvaluate { from(components["release"]) }
                groupId = "com.github.SanggunPark"
                artifactId = "lib-test2"
                version = "1.0.8"
            }

//            register<MavenPublication>("debug") {
//                afterEvaluate { from(components["debug"]) }
////                artifact(tasks.getByName("sourcesJar"))
//                groupId = "com.github.SanggunPark.debug"
//                artifactId = "test-lib2-debug"
//                version = "1.0.4"
//            }

        }
    }
}