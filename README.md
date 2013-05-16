DB Helper - REST
================

Provides methods for dropping, creating and initialization of database schema from the project bootstrap. For example, you can call `dbHelper/dropCreateInit` after each end-to-end test to have the fresh data in the database.

Usage
=====

The plugin provides methods that are exposed via REST API. It makes possible to:
* drop database schema
  * `http://localhost:8080/your-project/`<strong style="color: #4183c4;">`dbHelper/drop`</strong>
* create database schema
  * `http://localhost:8080/your-project/`<strong style="color: #4183c4;">`dbHelper/create`</strong>
* call init closure from the project BootStrap.groovy
  * `http://localhost:8080/your-project/`<strong style="color: #4183c4;">`dbHelper/init`</strong>
* drop and create database schema
  * `http://localhost:8080/your-project/`<strong style="color: #4183c4;">`dbHelper/dropCreate`</strong>
* drop and create database schema and call init closure from the project BootStrap.groovy
  * `http://localhost:8080/your-project/`<strong style="color: #4183c4;">`bHelper/dropCreateInit`</strong>

Install
=======

`grails install-plugin db-helper-rest`