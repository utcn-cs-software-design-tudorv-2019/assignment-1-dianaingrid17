package presentation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class View_Login extends JFrame{


	
private static final long serialVersionUID = 1L;
private JPanel pane = new JPanel(new GridBagLayout());

	
    GridBagConstraints c = new GridBagConstraints();
    
    private JButton login_btn = new JButton("Login");
	JLabel username_label = new JLabel("Username:");
	JLabel password_label = new JLabel("Password:");
	JTextField username_textField = new JTextField(30);
	JTextField password_textField = new JTextField(30);
	
	Controller_Login controller = new Controller_Login(this);
	public View_Login() {
		// TODO Auto-generated constructor stub
		super();
		pane.setPreferredSize(new Dimension(640,480));
		pane.setBackground(Color.LIGHT_GRAY);
		
		//listeners
		login_btn.addActionListener(controller);
		
		c.gridx = 0;
		c.gridy = 0;
		pane.add(username_label,c);
		c.gridy++;
		pane.add(password_label,c);
		
		c.gridx = 1;
		c.gridy = 0;
		pane.add(username_textField,c);
		c.gridy++;
		pane.add(password_textField,c);
		
		c.gridx = 2;
		c.gridy = 0;
		pane.add(login_btn,c);
		
		
		
		this.add(pane);}
	
	
	/**
	 * @return the button_teacher
	 */

	public static void main(String args[])
	{
		JFrame frame = new View_Login();
		frame.setTitle("Log In");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(640,480));
		frame.pack();
		frame.setVisible(true);
	}




	/**
	 * @return the login_btn
	 */
	public JButton getLogin_btn() {
		return login_btn;
	}


	/**
	 * @param login_btn the login_btn to set
	 */
	public void setLogin_btn(JButton login_btn) {
		this.login_btn = login_btn;
	}


	/**
	 * @return the username_label
	 */
	public JLabel getUsername_label() {
		return username_label;
	}


	/**
	 * @param username_label the username_label to set
	 */
	public void setUsername_label(JLabel username_label) {
		this.username_label = username_label;
	}


	/**
	 * @return the username_textField
	 */
	public JTextField getUsername_textField() {
		return username_textField;
	}


	/**
	 * @param username_textField the username_textField to set
	 */
	public void setUsername_textField(JTextField username_textField) {
		this.username_textField = username_textField;
	}


	/**
	 * @return the password_textField
	 */
	public JTextField getPassword_textField() {
		return password_textField;
	}


	/**
	 * @param password_textField the password_textField to set
	 */
	public void setPassword_textField(JTextField password_textField) {
		this.password_textField = password_textField;
	}

}
