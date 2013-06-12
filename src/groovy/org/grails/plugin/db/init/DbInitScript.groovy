package org.grails.plugin.db.init

import grails.util.Holders
import org.apache.commons.logging.LogFactory
import org.codehaus.groovy.grails.commons.GrailsApplication
import org.springframework.context.ApplicationContext

/**
 * Loads and executes a Groovy script.
 *
 * @author Ondrej Kvasnovsky
 */
class DbInitScript {

    private static final log = LogFactory.getLog(this)

    String scriptFile

    DbInitScript(String scriptFile) {
        this.scriptFile = scriptFile
    }

    void execute() {
        File script = new File(scriptFile)
        if (script.exists()) {
            GrailsApplication grailsApplication = Holders.grailsApplication
            ApplicationContext ctx = grailsApplication.mainContext
            Binding binding = new Binding(ctx: ctx, grailsApplication: grailsApplication)
            ClassLoader loader = this.class.classLoader
            GroovyShell shell = new GroovyShell(loader, binding)
            shell.evaluate(script.text)
        } else {
            log.error "Script doesn't exist: $scriptFile"
        }
    }
}
