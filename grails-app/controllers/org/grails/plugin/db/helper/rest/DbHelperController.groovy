package org.grails.plugin.db.helper.rest

/**
 * Provides REST methods for {@link DbHelperService}. E.g. http://localhost:8080/dbHelper/dropCreateInit
 *
 * @author Ondrej Kvasnovsky
 */
class DbHelperController {

    DbHelperService dbHelperService

    /**
     * Drops and creates database schema. Then it calls init method from the project BootStrap.groovy.
     */
    def dropCreateInit() {
        boolean result = dbHelperService.dropCreateInit()
        renderResult(result)
    }

    /**
     * Calls init method from the project BootStrap.groovy.
     */
    def init() {
        boolean result = dbHelperService.init()
        renderResult(result)
    }

    /**
     * Drops and creates database schema.
     */
    def dropCreate() {
        def result = dbHelperService.dropCreate()
        renderResult(result)
    }

    /**
     * Drops the database schema.
     */
    def drop() {
        def result = dbHelperService.drop()
        renderResult(result)
    }

    /**
     * Creates  the database schema.
     */
    def create() {
        def result = dbHelperService.create()
        renderResult(result)
    }

    private void renderResult(boolean result) {
        if (result) {
            render "success"
        } else {
            render "fail"
        }
    }
}