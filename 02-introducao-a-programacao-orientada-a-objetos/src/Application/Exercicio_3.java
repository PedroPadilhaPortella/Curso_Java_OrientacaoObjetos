package Application;

import java.util.Locale;
import java.util.Scanner;

import Entities.Student;

public class Exercicio_3 {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Student student = new Student();
		
		student.Name = sc.nextLine();
		student.Grade1 = sc.nextDouble();
		student.Grade2 = sc.nextDouble();
		student.Grade3 = sc.nextDouble();
		
		System.out.printf("FINAL GRADE %.2f%n", student.finalGrade());
		
		if(student.finalGrade() < 60.0) {
			System.out.println("FAILED");
			System.out.printf("MISSING %.2f POINTS%n", student.missingPoints());
		} else {
			System.out.println("PASS");
		}
		
		sc.close();
		
	}

}
