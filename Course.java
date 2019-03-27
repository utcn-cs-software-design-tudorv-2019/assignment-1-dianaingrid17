package model;

public class Course {

	private int id;
	private String name;
	private String creditNumber;
	/**
	 * @param id
	 * @param name
	 * @param creditNumber
	 */
	public Course(int id, String name, String creditNumber) {
		super();
		this.id = id;
		this.name = name;
		this.creditNumber = creditNumber;
	}
	/**
	 * @param name
	 * @param creditNumber
	 */
	public Course(String name, String creditNumber) {
		super();
		this.name = name;
		this.creditNumber = creditNumber;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the creditNumber
	 */
	public String getCreditNumber() {
		return creditNumber;
	}
	/**
	 * @param creditNumber the creditNumber to set
	 */
	public void setCreditNumber(String creditNumber) {
		this.creditNumber = creditNumber;
	}
	
	
	

}
