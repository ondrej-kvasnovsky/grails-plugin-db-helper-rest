package org.grails.plugin.db.helper.rest

import org.codehaus.groovy.grails.commons.GrailsApplication
import org.codehaus.groovy.grails.commons.GrailsBootstrapClass
import org.codehaus.groovy.grails.commons.GrailsClass
import org.springframework.context.ApplicationContext

import javax.servlet.ServletContext

import static org.codehaus.groovy.grails.commons.BootstrapArtefactHandler.TYPE
import static org.springframework.beans.factory.config.AutowireCapableBeanFactory.AUTOWIRE_BY_NAME

/**
 * Calls init method from the project BootStrap.groovy.
 *
 * @author Ondrej Kvasnovsky
 */
class BootstrapInit {

    GrailsApplication grailsApplication

    void callInit() {
        ApplicationContext applicationContext = grailsApplication.mainContext
        ServletContext servletContext = applicationContext.servletContext
        GrailsClass[] bootstraps = grailsApplication.getArtefacts(TYPE)
        for (GrailsClass bootstrap : bootstraps) {
            String bootstrapName = bootstrap.fullName
            if ('BootStrap'.equals(bootstrapName)) {
                GrailsBootstrapClass bootstrapClass = bootstrap
                Object instance = bootstrapClass.referenceInstance
                applicationContext.autowireCapableBeanFactory.autowireBeanProperties(instance, AUTOWIRE_BY_NAME, false)
                bootstrapClass.callInit(servletContext)
            }
        }
    }
}
