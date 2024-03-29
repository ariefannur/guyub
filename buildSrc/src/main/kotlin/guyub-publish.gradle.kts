plugins {
    `maven-publish`
    signing
}

ext["signing.keyId"] = null
ext["signing.password"] = null
ext["signing.secretKey"] = null
ext["signing.secretKeyRingFile"] = null
ext["ossrhUsername"] = null
ext["ossrhPassword"] = null
ext["gradle.publish.key"] = null
ext["gradle.publish.secret"] = null
ext["user.id"] = null
ext["user.name"] = null
ext["user.email"] = null
val localPropsFile = project.rootProject.file("local.properties")
if (localPropsFile.exists()) {
    localPropsFile.reader()
        .use { java.util.Properties().apply { load(it) } }
        .onEach { (name, value) ->
            ext[name.toString()] = value
        }
} else {
    ext["signing.keyId"] = System.getenv("SIGNING_KEY_ID")
    ext["signing.password"] = System.getenv("SIGNING_PASSWORD")
    ext["signing.secretKey"] = System.getenv("SIGNING_SECRET_KEY")
    ext["signing.secretKeyRingFile"] = System.getenv("SIGNING_SECRET_KEY_RING_FILE")
    ext["ossrhUsername"] = System.getenv("OSSRH_USERNAME")
    ext["ossrhPassword"] = System.getenv("OSSRH_PASSWORD")
    ext["gradle.publish.key"] = System.getenv("GRADLE_PUBLISH_KEY")
    ext["gradle.publish.secret"] = System.getenv("GRADLE_PUBLISH_SECRET")
    ext["user.id"] = System.getenv("POM_USER_ID")
    ext["user.name"] = System.getenv("POM_USER_NAME")
    ext["user.email"] = System.getenv("POM_USER_EMAIL")
}

fun getExtraString(name: String) = ext[name]?.toString()

val signPublications = getExtraString("signing.keyId") != null

publishing {
    repositories {
        maven {
            name = "sonatype"
            setUrl("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")
            credentials {
                username = getExtraString("ossrhUsername")
                password = getExtraString("ossrhPassword")
            }
        }

        maven {
            name = "SonatypeSnapshot"
            setUrl("https://s01.oss.sonatype.org/content/repositories/snapshots/")
            credentials {
                username = getExtraString("ossrhUsername")
                password = getExtraString("ossrhPassword")
            }
        }
    }

    publications.withType<MavenPublication> {
        if (plugins.hasPlugin("org.jetbrains.kotlin.multiplatform")) {
            artifact(tasks.register("${name}JavadocJar", Jar::class) {
                archiveClassifier.set("javadoc")
                archiveAppendix.set(this@withType.name)
            })
        } else if (plugins.hasPlugin("com.android.application") ||
            plugins.hasPlugin("com.android.library")) {
            artifact(tasks.register("${name}SourcesJar", Jar::class) {
                archiveClassifier.set("sources")
            })
            artifact(tasks.register("${name}JavadocJar", Jar::class) {
                archiveClassifier.set("javadoc")
                archiveAppendix.set(this@withType.name)
            })
        }

        if (signPublications) signing.sign(this)

        groupId = "io.github.ariefannur"
        version = LibVersions.version

        pom {
            name.set("guyub")
            description.set("Serverside rendering libraray with kotlin multi platform")
            url.set("https://github.com/ariefannur/guyub")
            licenses {
                license {
                    name.set("MIT")
                    url.set("https://opensource.org/licenses/MIT")
                }
            }
            developers {
                developer {
                    id.set(getExtraString("user.id"))
                    name.set(getExtraString("user.name"))
                    email.set(getExtraString("user.email"))
                }
            }
            scm {
                connection.set("scm:git:git://github.com/ariefannur/guyub.git")
                developerConnection.set("scm:git:ssh://github.com/ariefannur/guyub.git")
                url.set("https://github.com/ariefannur/guyub")
            }
        }
    }
}

if (signPublications) {
    signing {
        if (project.hasProperty("signing.secretKey")) {
            useGpgCmd()
        }
        useInMemoryPgpKeys(
            getExtraString("signing.keyId"),
            getExtraString("signing.secretKey"),
            getExtraString("signing.password"),
        )
        sign(publishing.publications)
    }
}


