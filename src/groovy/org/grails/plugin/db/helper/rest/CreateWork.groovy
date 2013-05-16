package org.grails.plugin.db.helper.rest

import org.hibernate.tool.hbm2ddl.SchemaExport

import java.sql.Connection
import java.sql.SQLException

/**
 * Creates the database schema, using {@link SchemaExport}.
 *
 * @author Ondrej Kvasnovsky
 */
class CreateWork extends DbHelperWork {

    @Override
    void execute(Connection connection) throws SQLException {
        SchemaExport schema = new SchemaExport(configuration, connection)
        schema.create(true, true)
    }
}