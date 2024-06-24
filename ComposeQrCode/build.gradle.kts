import com.vanniktech.maven.publish.SonatypeHost

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.compose.compiler)
    id("maven-publish")
    id("signing")
    id("com.vanniktech.maven.publish") version "0.28.0"

}
apply(plugin = "maven-publish")
apply(plugin = "signing")

mavenPublishing {
    publishToMavenCentral(SonatypeHost.S01)

    signAllPublications()
}

mavenPublishing {
    coordinates("io.github.the-best-is-best", "compose_qr_code", "1.0.0")

    pom {
        name.set("Compose QrCode")
        description.set("A Compose library that provides to add Qr generator and qr reader.")
        url.set("https://github.com/the-best-is-best/ComposeQrCode")
        licenses {
            license {
                name.set("Apache-2.0")
                url.set("https://opensource.org/licenses/Apache-2.0")
            }
        }
        issueManagement {
            system.set("Github")
            url.set("https://github.com/the-best-is-best/ComposeQrCode/issues")
        }
        scm {
            connection.set("https://github.com/the-best-is-best/ComposeQrCode.git")
            url.set("https://github.com/the-best-is-best/ComposeQrCode")
        }
        developers {
            developer {
                id.set("MichelleRaouf")
                name.set("Michelle Raouf")
                email.set("eng.michelle.raouf@gmail.com")
            }
        }
    }

}


signing {
    useGpgCmd()
    sign(publishing.publications)
}
android {
    namespace = "io.tbib.composeqrcode"
    compileSdk = 34

    buildFeatures {
        compose = true
    }

    defaultConfig {
        minSdk = 21

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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }


}



dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.material3)
//    implementation(libs.material)
    // activity compose
    implementation(libs.androidx.activity.compose)
    // cameraX
    implementation(libs.androidx.camera.camera2)
    implementation(libs.androidx.camera.lifecycle)
    implementation(libs.androidx.camera.view)

    //Zxing
    implementation(libs.zxing.core)
//    implementation(libs.zxing.android.embedded)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}