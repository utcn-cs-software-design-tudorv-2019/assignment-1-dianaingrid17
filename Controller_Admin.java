package presentation;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;

import businessLogic.StudentBLL;
import model.Student;

public class Controller_Admin implements ActionListener {

	View_Admin view_admin;
	private StudentBLL studentBLL;
	private Student student;
	private Print_Students print_Students;
	
	public Controller_Admin(View_Admin view_admin) {
		// TODO Auto-generated constructor stub
		this.view_admin=view_admin;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Object source = arg0.getSource();
		
		if(source == view_admin.getAddStudent())
		{
			String name, email;
			try {
				name = view_admin.getName_textField().getText();
				email = view_admin.getEmail_textField().getText();
				
				studentBLL = new StudentBLL();
				student = new Student(name,email);
				studentBLL.insertStudent(student);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		if(source == view_admin.getEditStudent())
		{
			String name,email;
			int id;
			try {
				id = Integer.parseInt(view_admin.getId_textField().getText());
				name = view_admin.getName_textField().getText();
				email = view_admin.getEmail_textField().getText();
				
				studentBLL = new StudentBLL();
				student = new Student(name,email);
				studentBLL.update(student, id);
				
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		if(source == view_admin.getRemoveStudent())
		{
			int id;
			try {
				id = Integer.parseInt( view_admin.getId_textField().getText());
				studentBLL = new StudentBLL();
				studentBLL.delete(id);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		if(source == view_admin.getViewStudent())
		{
			studentBLL = new StudentBLL();
			try {
				List<Student> studentList = studentBLL.viewAll();
				String[][]values = studentBLL.viewAllStudents(studentList);
				
				print_Students = new Print_Students(values);
				JFrame frame = new JFrame();
				frame.add(print_Students);
				frame.setTitle("Student Table");
				frame.setPreferredSize(new Dimension(400,300));
				frame.pack();
				frame.setVisible(true);
			}catch(IllegalArgumentException e)
			{
				e.printStackTrace();
			}catch(IllegalAccessException e)
			{
				e.printStackTrace();
			}
		}
		if(source == view_admin.getAcademicActivity())
		{
			int id;
			try {
				id = Integer.parseInt( view_admin.getId_textField().getText());
				studentBLL = new StudentBLL();
				//studentBLL.delete(id);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
	}

}
