package org.grails.plugin.db.init

import org.codehaus.groovy.grails.commons.GrailsApplication
import org.springframework.context.ApplicationContext

/**
 * Loads and executes a Groovy script.
 *
 * @author Ondrej Kvasnovsky
 */
class DbInitScript {

    GrailsApplication grailsApplication

    DbInitScript(GrailsApplication grailsApplication) {
        this.grailsApplication = grailsApplication
    }

    /**
     * Executs the Groovy script which has been taken from grails.db.init.script.location property
     */
    void execute() {
        String scriptFile = grailsApplication.config.grails.db.init.script.location
        File script = new File(scriptFile)
        if (script.exists()) {
            ApplicationContext ctx = grailsApplication.mainContext
            Binding binding = new Binding(ctx: ctx, grailsApplication: grailsApplication)
            ClassLoader loader = this.class.classLoader
            GroovyShell shell = new GroovyShell(loader, binding)
            shell.evaluate(script.text)
        } else {
            println "Script doesn't exist: $scriptFile"
        }
    }

    /**
     * Checks if -Dgrails.db.init.script.location is set and external DB initialization script should be used
     */
    boolean isAvailable() {
        boolean res = false
        String dbInitScriptLocation = grailsApplication.config.grails.db.init.script.location
        if (dbInitScriptLocation) {
            String dbInitScript = dbInitScriptLocation.trim()
            if ("".equals(dbInitScript)) {
                return false;
            }
            if ("{}".equals(dbInitScript)) {
                return false;
            }
            res = true
        }
        return res
    }
}
