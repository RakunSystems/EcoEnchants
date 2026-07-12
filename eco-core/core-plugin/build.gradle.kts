group = "com.willfp"
version = rootProject.version

dependencies {
    compileOnly(fileTree("../../lib") {
        include("*.jar")
    })
    
    // Paper API sürümünü senin sunucun olan 1.21.4'e çektik
    compileOnly("io.papermc.paper:paper-api:1.21.4-R0.1-SNAPSHOT")
    
    compileOnly("net.essentialsx:EssentialsX:2.19.7") {
        exclude("*", "*")
    }
    
    // Core NMS 1.21.4 modülünü buraya bağlıyoruz
    implementation(project(":eco-core:core-nms:v1_21_4", configuration = "reobf"))
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
        }
    }
}