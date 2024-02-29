plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.sqldelight)
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            //put your multiplatform dependencies here
            implementation(libs.sql.delight.runtime)
            implementation(libs.kotlinx.datetime)
        }
        iosMain.dependencies {
            implementation(libs.sql.delight.runtime)
        }
        androidMain.dependencies {
            implementation(libs.sql.delight.android.driver)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}
sqldelight{
    databases{
        create("TodoDatabase"){
            packageName.set("com.example.todo.database")
        }
    }
}

android {
    namespace = "com.example.todo"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
}
