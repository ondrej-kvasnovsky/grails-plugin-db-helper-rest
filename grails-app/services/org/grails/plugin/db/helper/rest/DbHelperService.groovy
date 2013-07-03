package org.grails.plugin.db.helper.rest

import org.codehaus.groovy.grails.commons.GrailsApplication
import org.hibernate.Session
import org.hibernate.SessionFactory
import org.hibernate.jdbc.Work

/**
 * Provides methods for dropping, creating and initialization of database schema from the project bootstrap.
 *
 * @author Ondrej Kvasnovsky
 */
class DbHelperService {

    SessionFactory sessionFactory
    GrailsApplication grailsApplication

    /**
     * Drops and creates database schema. Then it calls init method from the project BootStrap.groovy.
     */
    boolean dropCreateInit() {
        Session session = sessionFactory.currentSession
        Work work = new DropCreateWork(grailsApplication: grailsApplication)
        session.doWork(work)

        BootstrapInit bootstrap = new BootstrapInit(grailsApplication: grailsApplication)
        bootstrap.callInit()

        return true
    }

    /**
     * Calls init method from the project BootStrap.groovy.
     */
    boolean init() {
        BootstrapInit bootstrap = new BootstrapInit(grailsApplication: grailsApplication)
        bootstrap.callInit()

        return true
    }

    /**
     * Drops and creates database schema.
     */
    boolean dropCreate() {
        Session session = sessionFactory.currentSession
        Work dropCreate = new DropCreateWork(grailsApplication: grailsApplication)
        session.doWork(dropCreate)

        return true
    }

    /**
     * Drops the database schema.
     */
    boolean drop() {
        Session session = sessionFactory.currentSession
        Work drop = new DropWork(grailsApplication: grailsApplication)
        session.doWork(drop)

        return true
    }

    /**
     * Creates  the database schema.
     */
    boolean create() {
        Session session = sessionFactory.currentSession
        Work create = new CreateWork(grailsApplication: grailsApplication)
        session.doWork(create)

        return true
    }
}
