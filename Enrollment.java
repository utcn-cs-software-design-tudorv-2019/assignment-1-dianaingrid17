package model;

public class Enrollment {

	private int idenrollment;
	private int student_id;
	private int course_id;
	private int academic_id;
	/**
	 * @param idenrollment
	 * @param student_id
	 * @param course_id
	 * @param academic_id
	 */
	public Enrollment(int idenrollment, int student_id, int course_id, int academic_id) {
		super();
		this.idenrollment = idenrollment;
		this.student_id = student_id;
		this.course_id = course_id;
		this.academic_id = academic_id;
	}
	/**
	 * @param student_id
	 * @param course_id
	 * @param academic_id
	 */
	public Enrollment(int student_id, int course_id, int academic_id) {
		super();
		this.student_id = student_id;
		this.course_id = course_id;
		this.academic_id = academic_id;
	}
	/**
	 * @return the idenrollment
	 */
	public int getIdenrollment() {
		return idenrollment;
	}
	/**
	 * @param idenrollment the idenrollment to set
	 */
	public void setIdenrollment(int idenrollment) {
		this.idenrollment = idenrollment;
	}
	/**
	 * @return the student_id
	 */
	public int getStudent_id() {
		return student_id;
	}
	/**
	 * @param student_id the student_id to set
	 */
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	/**
	 * @return the course_id
	 */
	public int getCourse_id() {
		return course_id;
	}
	/**
	 * @param course_id the course_id to set
	 */
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	/**
	 * @return the academic_id
	 */
	public int getAcademic_id() {
		return academic_id;
	}
	/**
	 * @param academic_id the academic_id to set
	 */
	public void setAcademic_id(int academic_id) {
		this.academic_id = academic_id;
	}
	
	
	

}
