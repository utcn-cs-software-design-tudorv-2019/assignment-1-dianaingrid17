/**
 * 
 */
package model;

/**
 * @author ingri
 *
 */
public class Academic_Situation {

	/**
	 * 
	 */
	private int idacademic_situation;
	private int Grade1;
	private int Grade2;
	private int Grade3;
	public Academic_Situation() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param idacademic_situation
	 * @param grade1
	 * @param grade2
	 * @param grade3
	 */
	public Academic_Situation(int idacademic_situation, int grade1, int grade2, int grade3) {
		super();
		this.idacademic_situation = idacademic_situation;
		Grade1 = grade1;
		Grade2 = grade2;
		Grade3 = grade3;
	}
	/**
	 * @param grade1
	 * @param grade2
	 * @param grade3
	 */
	public Academic_Situation(int grade1, int grade2, int grade3) {
		super();
		Grade1 = grade1;
		Grade2 = grade2;
		Grade3 = grade3;
	}
	/**
	 * @return the idacademic_situation
	 */
	public int getIdacademic_situation() {
		return idacademic_situation;
	}
	/**
	 * @param idacademic_situation the idacademic_situation to set
	 */
	public void setIdacademic_situation(int idacademic_situation) {
		this.idacademic_situation = idacademic_situation;
	}
	/**
	 * @return the grade1
	 */
	public int getGrade1() {
		return Grade1;
	}
	/**
	 * @param grade1 the grade1 to set
	 */
	public void setGrade1(int grade1) {
		Grade1 = grade1;
	}
	/**
	 * @return the grade2
	 */
	public int getGrade2() {
		return Grade2;
	}
	/**
	 * @param grade2 the grade2 to set
	 */
	public void setGrade2(int grade2) {
		Grade2 = grade2;
	}
	/**
	 * @return the grade3
	 */
	public int getGrade3() {
		return Grade3;
	}
	/**
	 * @param grade3 the grade3 to set
	 */
	public void setGrade3(int grade3) {
		Grade3 = grade3;
	}
	

}
