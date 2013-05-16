package org.grails.plugin.db.helper.rest

import org.hibernate.tool.hbm2ddl.SchemaExport

import java.sql.Connection
import java.sql.SQLException

/**
 * Drops and creates the database schema, using {@link SchemaExport}.
 *
 * @author Ondrej Kvasnovsky
 */
class DropCreateWork extends DbHelperWork {

    @Override
    void execute(Connection connection) throws SQLException {
        // drop-create schema
        SchemaExport schema = new SchemaExport(configuration, connection)
        schema.execute(true, true, false, false)
    }


}