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

public class View_Admin extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel pane = new JPanel(new GridBagLayout());
	GridBagConstraints c = new GridBagConstraints();
	 private JButton addStudent = new JButton("Add Student");
	 private JButton editStudent = new JButton("Edit Student");
	 private JButton removeStudent = new JButton("Remove Student");
	 private JButton viewStudent = new JButton("View Student");
	 private JButton academicActivity = new JButton("Academic activity");
	 
	 JLabel id_label = new JLabel("ID:");
	 JLabel name_label = new JLabel("Name:");
	 JLabel email_label = new JLabel("Email:");
	 
	 JTextField id_textField = new JTextField(15);
	 JTextField name_textField = new JTextField(15);
	 JTextField email_textField = new JTextField(15);
	 
	 
	 Controller_Admin controller = new Controller_Admin(this);
	public View_Admin()  {
		// TODO Auto-generated constructor stub
		super();
		pane.setPreferredSize(new Dimension(640,640));
		pane.setBackground(Color.LIGHT_GRAY);
		
		//listeners
		addStudent.addActionListener(controller);
		editStudent.addActionListener(controller);
		removeStudent.addActionListener(controller);
		viewStudent.addActionListener(controller);
		academicActivity.addActionListener(controller);
		
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
		c.gridy++;
		pane.add(academicActivity, c);
		
		this.add(pane);
			
	}
	/**
	 * @return the pane
	 */
	public JPanel getPane() {
		return pane;
	}
	/**
	 * @param pane the pane to set
	 */
	public void setPane(JPanel pane) {
		this.pane = pane;
	}
	/**
	 * @return the c
	 */
	public GridBagConstraints getC() {
		return c;
	}
	/**
	 * @param c the c to set
	 */
	public void setC(GridBagConstraints c) {
		this.c = c;
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
	 * @return the id_label
	 */
	public JLabel getId_label() {
		return id_label;
	}
	/**
	 * @param id_label the id_label to set
	 */
	public void setId_label(JLabel id_label) {
		this.id_label = id_label;
	}
	/**
	 * @return the name_label
	 */
	public JLabel getName_label() {
		return name_label;
	}
	/**
	 * @param name_label the name_label to set
	 */
	public void setName_label(JLabel name_label) {
		this.name_label = name_label;
	}
	/**
	 * @return the email_label
	 */
	public JLabel getEmail_label() {
		return email_label;
	}
	/**
	 * @param email_label the email_label to set
	 */
	public void setEmail_label(JLabel email_label) {
		this.email_label = email_label;
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
	/**
	 * @return the controller
	 */
	public Controller_Admin getController() {
		return controller;
	}
	/**
	 * @param controller the controller to set
	 */
	public void setController(Controller_Admin controller) {
		this.controller = controller;
	}
	/**
	 * @return the academicActivity
	 */
	public JButton getAcademicActivity() {
		return academicActivity;
	}
	/**
	 * @param academicActivity the academicActivity to set
	 */
	public void setAcademicActivity(JButton academicActivity) {
		this.academicActivity = academicActivity;
	}
	

}
