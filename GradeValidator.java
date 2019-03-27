package validator;

import model.Academic_Situation;

public class GradeValidator implements Validator<Academic_Situation> {

		// TODO Auto-generated constructor stub
	private static final int MIN_GRADE = 1;
	private static final int MAX_GRADE = 10;


	@Override
	public void validate(Academic_Situation t) {
		// TODO Auto-generated method stub
		if(t.getGrade1() <MIN_GRADE || t.getGrade1() > MAX_GRADE)
			throw new IllegalArgumentException("Grade1 limit is not respected");
		if(t.getGrade2() <MIN_GRADE || t.getGrade2() > MAX_GRADE)
			throw new IllegalArgumentException("Grade2 limit is not respected");
		if(t.getGrade3() <MIN_GRADE || t.getGrade3() > MAX_GRADE)
			throw new IllegalArgumentException("Grade3 limit is not respected");
		
	}

}
