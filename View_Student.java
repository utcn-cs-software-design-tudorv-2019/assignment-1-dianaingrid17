/**
 * 
 */
package presentation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author ingri
 *
 */
public class View_Student extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pane = new JPanel(new GridBagLayout());
	GridBagConstraints c = new GridBagConstraints();
	 private JButton addStudent = new JButton("Add Student");
	 private JButton editStudent = new JButton("Edit Student");
	 private JButton removeStudent = new JButton("Remove Student");
	 private JButton viewStudent = new JButton("View Student");
	
	 
	 JLabel id_label = new JLabel("ID:");
	 JLabel name_label = new JLabel("Name:");
	 JLabel email_label = new JLabel("Email:");
	 
	 JTextField id_textField = new JTextField(15);
	 JTextField name_textField = new JTextField(15);
	 JTextField email_textField = new JTextField(15);
	 
	 
	 Controller_Student controller = new Controller_Student(this);
	 
	public View_Student() {
		// TODO Auto-generated constructor stub
		super();
		pane.setPreferredSize(new Dimension(640,640));
		pane.setBackground(Color.LIGHT_GRAY);
		
		//listeners
		addStudent.addActionListener(controller);
		editStudent.addActionListener(controller);
		removeStudent.addActionListener(controller);
		viewStudent.addActionListener(controller);
		
		
		//labels
		c.gridx=0;
		c.gridy=0;
		pane.add(id_label,c);
		
		c.gridy++;
		pane.add(name_label,c);
		
		c.gridy++;
		pane.add(email_label,c);
		
		c.gridx = 1;
		c.gridy = 0;
		pane.add(id_textField,c);
		c.gridy++;
		pane.add(name_textField,c);
		c.gridy++;
		pane.add(email_textField,c);
		
		c.gridx = 2;
		c.gridy = 0;
		pane.add(addStudent, c);
		c.gridy++;
		pane.add(editStudent, c);
		c.gridy++;
		pane.add(removeStudent, c);
		c.gridy++;
		pane.add(viewStudent, c);
		
		this.add(pane);
			
	}

	/**
	 * @return the addStudent
	 */
	public JButton getAddStudent() {
		return addStudent;
	}



	/**
	 * @param addStudent the addStudent to set
	 */
	public void setAddStudent(JButton addStudent) {
		this.addStudent = addStudent;
	}



	/**
	 * @return the editStudent
	 */
	public JButton getEditStudent() {
		return editStudent;
	}



	/**
	 * @param editStudent the editStudent to set
	 */
	public void setEditStudent(JButton editStudent) {
		this.editStudent = editStudent;
	}



	/**
	 * @return the removeStudent
	 */
	public JButton getRemoveStudent() {
		return removeStudent;
	}



	/**
	 * @param removeStudent the removeStudent to set
	 */
	public void setRemoveStudent(JButton removeStudent) {
		this.removeStudent = removeStudent;
	}



	/**
	 * @return the viewStudent
	 */
	public JButton getViewStudent() {
		return viewStudent;
	}



	/**
	 * @param viewStudent the viewStudent to set
	 */
	public void setViewStudent(JButton viewStudent) {
		this.viewStudent = viewStudent;
	}



	/**
	 * @return the id_textField
	 */
	public JTextField getId_textField() {
		return id_textField;
	}



	/**
	 * @param id_textField the id_textField to set
	 */
	public void setId_textField(JTextField id_textField) {
		this.id_textField = id_textField;
	}



	/**
	 * @return the name_textField
	 */
	public JTextField getName_textField() {
		return name_textField;
	}



	/**
	 * @param name_textField the name_textField to set
	 */
	public void setName_textField(JTextField name_textField) {
		this.name_textField = name_textField;
	}



	/**
	 * @return the email_textField
	 */
	public JTextField getEmail_textField() {
		return email_textField;
	}



	/**
	 * @param email_textField the email_textField to set
	 */
	public void setEmail_textField(JTextField email_textField) {
		this.email_textField = email_textField;
	}
	

}
