package org.grails.plugin.db.init

import grails.util.Holders
import groovy.sql.Sql
import org.apache.commons.logging.LogFactory
import org.codehaus.groovy.grails.commons.GrailsApplication
import org.springframework.context.ApplicationContext

import javax.sql.DataSource

/**
 * SqlHelper is meant to be used in init groovy scripts to execute SQL insert files.
 *
 * For example:
 * <code>
 * import org.grails.plugin.db.init.SqlHelper
 *
 * SqlHelper sqlLoader = new SqlHelper()
 *
 * sqlLoader.execute('/path/to/users.sql')
 * sqlLoader.execute('/path/to/accounts.sql')
 * ...
 * </code>
 *
 * @author Ondrej Kvasnovsky
 */
class SqlHelper {

    private static final log = LogFactory.getLog(this)

    void execute(String path) {
        log.info("Executing \"$path\": start")
        GrailsApplication grailsApplication = Holders.grailsApplication
        ApplicationContext context = grailsApplication.mainContext
        DataSource dataSource = context.dataSource
        Sql sql = null
        BufferedReader br = null
        try {
            sql = new Sql(dataSource)

            br = new BufferedReader(new FileReader(path));
            String line;
            while ((line = br.readLine()) != null) {
                sql.execute(line)
            }
        } finally {
            if (sql != null) {
                sql.close()
            }
            if (br != null) {
                br.close();
            }
        }
        log.info("Executing \"$path\": end")
    }

    String getRoot() {
        String dbInitScript
        String dbInitScriptProperty = 'grails.db.init.script.location'
        if (System.env[dbInitScriptProperty]) {
            dbInitScript = System.env[dbInitScriptProperty]
        }
        if (System.properties[dbInitScriptProperty]) {
            dbInitScript = System.properties[dbInitScriptProperty]
        }
        String root = new File(dbInitScript).parentFile.absolutePath + File.separator
        return root
    }
}
