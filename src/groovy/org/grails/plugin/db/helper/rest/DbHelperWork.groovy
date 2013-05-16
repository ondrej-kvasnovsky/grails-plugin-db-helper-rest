package org.grails.plugin.db.helper.rest

import org.codehaus.groovy.grails.commons.GrailsApplication
import org.codehaus.groovy.grails.orm.hibernate.ConfigurableLocalSessionFactoryBean
import org.hibernate.cfg.Configuration
import org.hibernate.jdbc.Work
import org.springframework.context.ApplicationContext

/**
 * Provides common methods for all the works inside DbHelper.
 *
 * @author Ondrej Kvasnovsky
 */
abstract class DbHelperWork implements Work {

    GrailsApplication grailsApplication

    protected Configuration getConfiguration() {
        ApplicationContext applicationContext = grailsApplication.mainContext
        ConfigurableLocalSessionFactoryBean factory = applicationContext.getBean('&sessionFactory')
        Configuration configuration = factory.configuration
        return configuration
    }
}
