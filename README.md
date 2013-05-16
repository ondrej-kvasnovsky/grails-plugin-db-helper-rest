DB Helper - REST
================

Provides methods for dropping, creating and initialization of database schema from the project bootstrap. For example, you can call dbHelper/dropCreateInit after each end-to-end test to have the fresh data in the database.

h2. Usage

The plugin provides methods that are exposed via REST API. It makes possible to:
* drop database schema
  * http://localhost:8080/your-project/dbHelper/drop
* create database schema
  * http://localhost:8080/your-project/dbHelper/create
* call init closure from the project BootStrap.groovy
  * http://localhost:8080/your-project/dbHelper/init
* drop and create database schema
  * http://localhost:8080/your-project/dbHelper/dropCreate
* drop and create database schema and call init closure from the project BootStrap.groovy
  * http://localhost:8080/your-project/dbHelper/dropCreateInit

h2. Install:

{code}grails install-plugin db-helper-rest{code}