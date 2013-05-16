package org.grails.plugin.db.helper.rest

import org.hibernate.tool.hbm2ddl.SchemaExport

import java.sql.Connection
import java.sql.SQLException

/**
 * Drops the database schema, using {@link SchemaExport}.
 *
 * @author Ondrej Kvasnovsky
 */
class DropWork extends DbHelperWork {

    @Override
    void execute(Connection connection) throws SQLException {
        SchemaExport schema = new SchemaExport(configuration, connection)
        schema.drop(true, true)
    }
}
