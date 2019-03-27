/**
 * 
 */
package connection;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author ingri
 *
 */
public class ConnectionFactory {

	/**
	 * 
	 */
	private static final Logger LOGGER = Logger.getLogger(ConnectionFactory.class.getName());
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DBURL="jdbc:mysql://localhost:3306/utcnmanagement";
	private static final String USER = "root";
	private static final String PASSWORD = "";
	
	private static ConnectionFactory sigleInstance = new ConnectionFactory();
	
	private ConnectionFactory() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName(DRIVER);
			
		}catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	private Connection createConnection()
	{
		Connection c = null;
		try {
			c = DriverManager.getConnection(DBURL, USER, PASSWORD);
		}catch(SQLException e)
		{
			LOGGER.log(Level.WARNING, "Error while trying to connect to the database");
			e.printStackTrace();
		}
		return c;
	}
	public static Connection getConnection()
	{
		return sigleInstance.createConnection();
	}
	public static void closeConnection(Connection c)
	{
		if(c != null)
		{
			try {
				c.close();
			}catch(SQLException e)
			{
				LOGGER.log(Level.WARNING, "Error while trying to close the connection");
			}
		}
	}
	public static void close(Statement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				LOGGER.log(Level.WARNING, "An error occured while trying to close the statement");
			}
		}
	}

	public static void close(ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				LOGGER.log(Level.WARNING, "An error occured while trying to close the ResultSet");
			}
		}
	}
	

}
