package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import liquibase.Liquibase;
import liquibase.database.jvm.HsqlConnection;
import liquibase.logging.LogFactory;
import liquibase.resource.FileSystemResourceAccessor;
import liquibase.resource.ResourceAccessor;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HsqlDatabase {

	private static final String CHANGE_LOG = "src/main/resources/liquibase/master.xml";
	private static final String CONNECTION_STRING = "jdbc:hsqldb:mem:testdb;shutdown=false";
	private static final String USER_NAME = "SA";
	private static final String PASSWORD = StringUtils.EMPTY;
	private static final Logger LOG = LoggerFactory.getLogger(HsqlDatabase.class);

	private Connection holdingConnection;
	private Liquibase liquibase;

	public void setUp(String contexts) {

		try {
			ResourceAccessor resourceAccessor = new FileSystemResourceAccessor();

			Class.forName("org.hsqldb.jdbcDriver");
			holdingConnection = getConnectionImpl();

			HsqlConnection hsconn = new HsqlConnection(holdingConnection);

			LogFactory.getLogger().setLogLevel("severe");
			liquibase = new Liquibase(CHANGE_LOG, resourceAccessor, hsconn);
			liquibase.dropAll();
			liquibase.update(contexts);

			hsconn.close();
		} catch (Exception ex) {
			LOG.error("Error during database initialization", ex);
			throw new RuntimeException("Error during database initialization", ex);
		}
	}

	private Connection getConnectionImpl() throws SQLException {
		return DriverManager.getConnection(CONNECTION_STRING, USER_NAME, PASSWORD);
	}
}