package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The Class ConnectToMySQL.
 */
public class ConnectToMySQL {
	
	/**
	 * Gets the information by database name.
	 *
	 * @param dbName the db name
	 * @return the information
	 * @throws SQLException the SQL exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	protected static Connection getInformation(String dbName) throws SQLException, ClassNotFoundException {
		String hostName = "localhost";
		String userName = Config.dbUsername;
		String password = Config.dbPassword;
		return getInformation(hostName, dbName, userName, password);
	}

	/**
	 * Gets a connection to database by host name, database name, user name and password
	 *
	 * @param hostName the host name
	 * @param dbName the db name
	 * @param userName the user name
	 * @param password the password
	 * @return a connection to specified database
	 * @throws SQLException the SQL exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	protected static Connection getInformation(String hostName, String dbName, String userName, String password) throws SQLException, ClassNotFoundException {
		String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
		Connection conn = DriverManager.getConnection(connectionURL, userName, password);
		return conn;
	}
}
