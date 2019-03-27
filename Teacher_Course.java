/**
 * 
 */
package model;

/**
 * @author ingri
 *
 */
public class Teacher_Course {

	/**
	 * 
	 */
	private int idTeacher_Course;
	private int teacher_id;
	private int course_id;
	/**
	 * @param idTeacher_Course
	 * @param teacher_id
	 * @param course_id
	 */
	public Teacher_Course(int idTeacher_Course, int teacher_id, int course_id) {
		super();
		this.idTeacher_Course = idTeacher_Course;
		this.teacher_id = teacher_id;
		this.course_id = course_id;
	}
	/**
	 * @param teacher_id
	 * @param course_id
	 */
	public Teacher_Course(int teacher_id, int course_id) {
		super();
		this.teacher_id = teacher_id;
		this.course_id = course_id;
	}
	/**
	 * @return the idTeacher_Course
	 */
	public int getIdTeacher_Course() {
		return idTeacher_Course;
	}
	/**
	 * @param idTeacher_Course the idTeacher_Course to set
	 */
	public void setIdTeacher_Course(int idTeacher_Course) {
		this.idTeacher_Course = idTeacher_Course;
	}
	/**
	 * @return the teacher_id
	 */
	public int getTeacher_id() {
		return teacher_id;
	}
	/**
	 * @param teacher_id the teacher_id to set
	 */
	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
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
	
	
}