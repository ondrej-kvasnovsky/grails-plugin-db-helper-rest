class GrailsPluginDbHelperRestGrailsPlugin {

    def version = "0.1"
    def grailsVersion = "2.1 > *"
    def dependsOn = [:]
    def pluginExcludes = [
            "grails-app/views/error.gsp"
    ]

    def title = "DB Helper - Rest"
    def author = "Ondrej Kvasnovsky"
    def authorEmail = "ondrej.kvasnovsky@gmail.com"
    def description = '''\
Provides methods for dropping, creating and initialization of database schema from the project bootstrap.
'''

    def documentation = "http://grails.org/plugin/grails-plugin-db-helper-rest"

    def license = "APACHE"

    def issueManagement = [system: "GIT", url: "https://github.com/ondrej-kvasnovsky/grails-plugin-db-helper-rest/issues"]

    def scm = [url: "http://grails.org/plugin/grails-plugin-db-helper-rest"]

    def doWithWebDescriptor = { xml ->
    }

    def doWithSpring = {
    }

    def doWithDynamicMethods = { ctx ->
    }

    def doWithApplicationContext = { applicationContext ->
    }

    def onChange = { event ->
    }

    def onConfigChange = { event ->
    }

    def onShutdown = { event ->
    }
}
