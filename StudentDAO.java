/**
 * 
 */
package dataAccessObject;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import connection.ConnectionFactory;
import model.Student;

/**
 * @author ingri
 *
 */
public class StudentDAO {

	/**
	 * 
	 */
	protected static final Logger LOGGER = Logger.getLogger(StudentDAO.class.getName());
	private static final String insertStatementString ="Insert into student (name,email)" + " values (?,?)";
	private final static String findStatementString = "SELECT * FROM student where id = ?";
	private final static String deleteStatementString = "DELETE FROM student where id = ?";
	private final static String updateStatementString = "UPDATE student set name = ?, email = ? WHERE id = ?";
	private final static String viewAllStatementString = "SELECT * FROM student";


	
	public  Student findById(int id)
	{
		Student toReturn = null;
		Connection dbConnection =null;
		ResultSet rs = null;
		PreparedStatement findStatement = null;
		
		try {
			dbConnection = ConnectionFactory.getConnection();
			findStatement = dbConnection.prepareStatement(findStatementString);
			findStatement.setInt(1, id);
			rs = findStatement.executeQuery();
			rs.next();
			
			String name = rs.getString("name");
			String email = rs.getString("email");
			//toReturn = new Student(id,name,email);
			return createObjects(rs).get(0);
			
		}catch(SQLException e)
		{
			LOGGER.log(Level.WARNING, "StudentDAO:findById "+ e.getMessage());
		}finally {
			ConnectionFactory.close(rs);
			ConnectionFactory.close(findStatement);
			ConnectionFactory.closeConnection(dbConnection);
		}
		return null;
	}
	public int insert(Student student)
	{
		Connection dbConnection = null;
		PreparedStatement insertStatement =null;
		int inseredId = -1;
		try {
			dbConnection = ConnectionFactory.getConnection();
			insertStatement = dbConnection.prepareStatement(insertStatementString,Statement.RETURN_GENERATED_KEYS);
			insertStatement.setString(1, student.getName());
			insertStatement.setString(2,student.getEmail());
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
	public  int delete(int id)
	{
		
		Connection dbConnection=null;
		PreparedStatement deleteStatement = null;
		
		try {
			dbConnection = ConnectionFactory.getConnection();
			deleteStatement = dbConnection.prepareStatement(deleteStatementString);
			deleteStatement.setInt(1, id);
			
			deleteStatement.executeUpdate();
			
		}catch(SQLException e)
		{
			LOGGER.log(Level.WARNING,"StudentDAO:delete "+e.getMessage());
		}finally {
			ConnectionFactory.close(deleteStatement);
			ConnectionFactory.closeConnection(dbConnection);
		}
		return id;
		
	}
	public  Student update(Student student, int id)
	{
		Connection dbConnection = null;
		PreparedStatement updateStatement = null;
		ResultSet rs = null;
		try {
			dbConnection = ConnectionFactory.getConnection();
			updateStatement = dbConnection.prepareStatement(updateStatementString);
			updateStatement.setString(1, student.getName());
			updateStatement.setString(2,student.getEmail());
			updateStatement.setInt(3,id);
			
			updateStatement.executeUpdate();
			
		}catch(SQLException e)
		{
			LOGGER.log(Level.WARNING,"StudentDAO:update "+e.getMessage());
		}finally {
			ConnectionFactory.close(updateStatement);
			ConnectionFactory.closeConnection(dbConnection);
		}
		return student;
		
	}
	public List<Student> createObjects(ResultSet rs) 
	{
		// TODO Auto-generated method stub
		List<Student> list = new ArrayList<Student>();
		try {
			while(rs.next())
			{
				Student s = new Student(rs.getInt("id"),rs.getString("name"),rs.getString("email"));
        		list.add(s);
			} 
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}  catch (SQLException e) {
			e.printStackTrace();
		} 
		return list;
	}
	
	public List<Student> ViewAll() throws IllegalArgumentException, IllegalAccessException {
        Connection dbConnection =null;
        PreparedStatement  viewAllStatement = null;
        ResultSet rs = null;
        List<Student> list = new ArrayList<Student>();
        try {
        	dbConnection = ConnectionFactory.getConnection();
        	viewAllStatement = dbConnection.prepareStatement(viewAllStatementString);
        	rs = viewAllStatement.executeQuery();
        	
        	return createObjects(rs);
        }catch(SQLException e)
        {
        	
        }finally
        {
        	ConnectionFactory.close(rs);
        	ConnectionFactory.close(viewAllStatement);
        	ConnectionFactory.closeConnection(dbConnection);
        }
        return null;
    }
	public String[][] viewAllContent(List<Student> objects) throws IllegalArgumentException, IllegalAccessException
	{
		String[][] values = new String[objects.size()][1000];
		int coloana = 0;
		int rand = 0;
		for(Student t:objects)
		{
			coloana = 0;
			for(Field field:t.getClass().getDeclaredFields())
			{
				field.setAccessible(true);
				values[rand][coloana++] = ""+field.get(t);
			}
			rand = rand + 1;
		}
		
		return values;
	}
	

}
