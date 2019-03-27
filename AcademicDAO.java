package dataAccessObject;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import connection.ConnectionFactory;
import model.Academic_Situation;
import model.Student;

public class AcademicDAO {

	protected static final Logger LOGGER = Logger.getLogger(AcademicDAO.class.getName());
	private static final String insertStatementString ="Insert into academic_situation (grade1,grade2,grade3)" + " values (?,?,?)";
	private final static String findStatementString = "SELECT * FROM academic_situation where id = ?";
	private final static String deleteStatementString = "DELETE FROM academic_situation where id = ?";
	//private final static String updateStatementString = "UPDATE student set name = ?, email = ? WHERE id = ?";
	private final static String viewAllStatementString = "SELECT * FROM academic_situation";


	public List<Academic_Situation> createObjects(ResultSet rs) 
	{
		// TODO Auto-generated method stub
		List<Academic_Situation> list = new ArrayList<Academic_Situation>();
		try {
			while(rs.next())
			{
				Academic_Situation s = new Academic_Situation(rs.getInt("idacademic_situation"),rs.getInt("Grade1"),rs.getInt("Grade2"),rs.getInt("Grade3"));
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
	public List<Academic_Situation> ViewAll() throws IllegalArgumentException, IllegalAccessException {
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement  viewAllStatement = null;
        ResultSet rs = null;
        List<Academic_Situation> list = new ArrayList<Academic_Situation>();
        try {
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
	public String[][] viewAllContent(List<Academic_Situation> objects) throws IllegalArgumentException, IllegalAccessException
	{
		String[][] values = new String[objects.size()][1000];
		int coloana = 0;
		int rand = 0;
		for(Academic_Situation t:objects)
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
