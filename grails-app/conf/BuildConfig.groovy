grails.project.work.dir = "target"

grails.project.dependency.resolution = {

    inherits "global"
    log "warn"

    repositories {
        grailsCentral()
        mavenLocal()
        mavenCentral()
        grailsPlugins()
    }

    dependencies {
        compile "org.hibernate:hibernate-core:3.6.10.Final" {
            transitive = false
        }
    }

    plugins {
        build ":release:2.2.1", ":rest-client-builder:1.0.3" {
            export = false
            transitive = false
        }
    }
}
