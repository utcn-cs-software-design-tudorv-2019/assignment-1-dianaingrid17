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
import model.Enrollment;
import model.Student;

/**
 * @author ingri
 *
 */
public class EnrollmentDAO {

	/**
	 * 
	 */
	protected static final Logger LOGGER = Logger.getLogger(EnrollmentDAO.class.getName());
	private static final String insertStatementString ="Insert into enrollment (student_id,course_id,academic_id)" + " values (?,?,?)";
	//private final static String findStatementString = "SELECT * FROM student where id = ?";
	//private final static String deleteStatementString = "DELETE FROM student where id = ?";
	//private final static String updateStatementString = "UPDATE student set name = ?, email = ? WHERE id = ?";
	private final static String viewAllStatementString = "SELECT * FROM enrollment";

	
	public static int insert(Enrollment enrollment)
	{
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement insertStatement =null;
		int inseredId = -1;
		try {
			insertStatement = dbConnection.prepareStatement(insertStatementString,Statement.RETURN_GENERATED_KEYS);
			insertStatement.setInt(1, enrollment.getStudent_id());
			insertStatement.setInt(2, enrollment.getCourse_id());
			insertStatement.setInt(3, enrollment.getAcademic_id());
			insertStatement.executeUpdate();
			ResultSet rs = insertStatement.getGeneratedKeys();
			if(rs.next())
			{
				inseredId = rs.getInt(1);
			}
			
		}catch(SQLException e)
		{
			LOGGER.log(Level.WARNING,"StudentDAO:insert "+e.getMessage());
		}finally {
			ConnectionFactory.close(insertStatement);
			ConnectionFactory.closeConnection(dbConnection);
		}
		return inseredId;
		
	}
}
