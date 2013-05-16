DB Helper - REST
================

Provides methods for dropping, creating and initialization of database schema from the project bootstrap. For example, you can call `dbHelper/dropCreateInit` after each end-to-end test to have the fresh data in the database.

You have to exclude this plugin in production mode since the plugin is meant to be used only in development or test environments. In Config.groovy:
`environments {
    production {
        grails.plugin.excludes = ['db-helper-rest']
    }
}`

Usage
=====

The plugin provides methods that are exposed via REST API (use GET). It makes possible to:
* drop database schema
  * `http://localhost:8080/your-app/dbHelper/drop`
* create database schema
  * `http://localhost:8080/your-app/dbHelper/create`
* call init closure from the project BootStrap.groovy
  * `http://localhost:8080/your-app/dbHelper/init`
* drop and create database schema
  * `http://localhost:8080/your-app/dbHelper/dropCreate`
* drop and create database schema and call init closure from the project BootStrap.groovy
  * `http://localhost:8080/your-app/dbHelper/dropCreateInit`

Install
=======

`grails install-plugin db-helper-rest`