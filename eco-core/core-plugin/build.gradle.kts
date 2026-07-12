group = "com.willfp"
version = rootProject.version

dependencies {
    compileOnly(fileTree("../../lib") {
        include("*.jar")
    })
    
    // Paper API sürümünü senin sunucunla uyumlu olması için 1.21.4'e çektik
    compileOnly("io.papermc.paper:paper-api:1.21.4-R0.1-SNAPSHOT")
    
    compileOnly("net.essentialsx:EssentialsX:2.19.7") {
        exclude("*", "*")
    }
    
    // Hata veren v1_21_4 yerine repoda var olan en alt NMS modülünü (v1_21_8) bağlıyoruz
    implementation(project(":eco-core:core-nms:v1_21_8", configuration = "reobf"))
}

tasks {
    build {
        dependsOn(publishToMavenLocal)
    }
}

publishing {
    publications {
        create<MavenPublication>("shadow") {
            from(components["java"])
            artifactId = rootProject.name
        }
    }

    repositories {
        maven {
            name = "Auxilor"
            url = uri("https://repo.auxilor.io/repository/maven-releases/")
            credentials {
                username = System.getenv("MAVEN_USERNAME")
                password = System.getenv("MAVEN_PASSWORD")
            }
        }
    }
}