/**
 * 
 */
package businessLogic;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import dataAccessObject.StudentDAO;
import model.Student;
import validator.EmailValidator;
import validator.Validator;

/**
 * @author ingri
 *
 */
public class StudentBLL {

	/**
	 * 
	 */
	private List<Validator<Student>> validators;
	public StudentDAO studentDAO;
	public StudentBLL() {
		// TODO Auto-generated constructor stub
		validators = new ArrayList<Validator<Student>>();
		validators.add(new EmailValidator());
		studentDAO = new StudentDAO();
		
	}
	public Student findStudentById(int id)
	{
		Student s = studentDAO.findById(id);
		if(s == null)
		{
			throw new NoSuchElementException("The student with id =" + id + " was not found!");
		}
		return s;
	}
	public int insertStudent(Student student)
	{
		for(Validator<Student> v:validators)
			v.validate(student);
		
		return studentDAO.insert(student);
	}
	public int delete(int id)
	{
		return studentDAO.delete(id);
	}
	public Student update(Student student,int id)
	{
		return studentDAO.update(student, id);
	}
	public List<Student> viewAll() throws IllegalArgumentException, IllegalAccessException
	{
		return studentDAO.ViewAll();
	}
	public String[][] viewAllStudents(List<Student> studentList) throws IllegalArgumentException, IllegalAccessException
	{
		return studentDAO.viewAllContent(studentList);
	}
			
}
