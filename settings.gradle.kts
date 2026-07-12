pluginManagement {
    repositories {
        maven("https://repo.papermc.io/repository/maven-public/")
        gradlePluginPortal()
        mavenLocal()
        maven("https://repo.auxilor.io/repository/maven-public/")
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

rootProject.name = "EcoEnchants"

// Core
include(":eco-core")
include(":eco-core:core-plugin")
include(":eco-core:core-nms")

// Sadece fiziksel olarak mevcut olan ve hata vermeyecek en alt modülü dahil ediyoruz
include(":eco-core:core-nms:v1_21_8")