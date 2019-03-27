/**
 * 
 */
package dataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import connection.ConnectionFactory;
import model.Course;
import model.Student;

/**
 * @author ingri
 *
 */
public class CourseDAO {

	/**
	 * 
	 */
	protected static final Logger LOGGER = Logger.getLogger(CourseDAO.class.getName());
	private static final String insertStatementString ="Insert into course (name,creditNumber)" + " values (?,?)";
	private final static String findStatementString = "SELECT * FROM course where id = ?";
	//private final static String deleteStatementString = "DELETE FROM student where id = ?";
	//private final static String updateStatementString = "UPDATE student set name = ?, email = ? WHERE id = ?";
	private final static String viewAllStatementString = "SELECT * FROM course";

	public static Course findById(int id)
	{
		Course toReturn = null;
		Connection dbConnection = ConnectionFactory.getConnection();
		ResultSet rs = null;
		PreparedStatement findStatement = null;
		
		try {
			findStatement = dbConnection.prepareStatement(findStatementString);
			findStatement.setLong(1, id);
			rs = findStatement.executeQuery();
			rs.next();
			
			String name = rs.getString("name");
			String credit = rs.getString("creditNumber");
			toReturn = new Course(id,name,credit);
			
		}catch(SQLException e)
		{
			LOGGER.log(Level.WARNING, "CourseDAO:findById "+ e.getMessage());
		}finally {
			ConnectionFactory.close(rs);
			ConnectionFactory.close(findStatement);
			ConnectionFactory.closeConnection(dbConnection);
		}
		return toReturn;
	}
	public static int insert(Course course)
	{
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement insertStatement =null;
		int inseredId = -1;
		try {
			insertStatement = dbConnection.prepareStatement(insertStatementString,Statement.RETURN_GENERATED_KEYS);
			insertStatement.setString(1, course.getName());
			insertStatement.setString(2,course.getCreditNumber());
			insertStatement.executeUpdate();
			ResultSet rs = insertStatement.getGeneratedKeys();
			if(rs.next())
			{
				inseredId = rs.getInt(1);
			}
			
		}catch(SQLException e)
		{
			LOGGER.log(Level.WARNING,"CourseDAO:insert "+e.getMessage());
		}finally {
			ConnectionFactory.close(insertStatement);
			ConnectionFactory.closeConnection(dbConnection);
		}
		return inseredId;
		
	}
}
