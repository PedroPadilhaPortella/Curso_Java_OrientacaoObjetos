package Entities;

public class Student {
	public String Name;
	public double Grade1;
	public double Grade2;
	public double Grade3;
	
	public double finalGrade() {
		return Grade1 + Grade2 + Grade3;
	}
	
	public double missingPoints() {
		if(finalGrade() < 60.00) {
			return 60.0 - finalGrade();
		} else {
			return 0.0;
		}
	}
}
