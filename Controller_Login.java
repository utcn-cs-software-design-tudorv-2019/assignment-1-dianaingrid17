/**
 * 
 */
package presentation;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

/**
 * @author ingri
 *
 */
public class Controller_Login implements ActionListener{

	/**
	 * 
	 */
	private static final String student_user = "student";
	private static final String student_pass = "student";
	private static final String teacher_user = "teacher";
	private static final String teacher_pass = "teacher";
	
	private View_Login view_login;
	public Controller_Login(View_Login v) {
		// TODO Auto-generated constructor stub
		this.view_login = v;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		if(source == view_login.getLogin_btn())
		{
			String user;
			String pass;
			try
			{
				user = view_login.getUsername_textField().getText();
				pass = view_login.getPassword_textField().getText();
				if(user.equals(student_user) && pass.equals(student_pass))
				{
					JFrame frame = new View_Student();
					frame.setTitle("Student_View");
					frame.setPreferredSize(new Dimension(480,480));
					frame.pack();
					frame.setVisible(true);
				}
				if(user.equals(teacher_user) && pass.equals(teacher_pass))
				{
					JFrame frame = new View_Admin();
					frame.setTitle("Teacher_View");
					frame.setPreferredSize(new Dimension(480,480));
					frame.pack();
					frame.setVisible(true);
				}
				
			}catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
		
	}

}
