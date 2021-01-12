package Application;

import java.util.Locale;
import java.util.Scanner;

import Entities.Employee;


public class Exercicio_2 {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Employee employee = new Employee();
		System.out.println("Name:");
		employee.Name = sc.nextLine();
		System.out.println("Gross Salary:");
		employee.GrossSalary = sc.nextDouble();
		System.out.println("Tax:");
		employee.Tax = sc.nextDouble();
		
		System.out.println("Employee: " + employee);
		
		System.out.println("Which percentage to increase salary? ");
		double percentage = sc.nextDouble();
		employee.IncreaseSalary(percentage);
		
		System.out.println("Updated data: " + employee);
		
		
		sc.close();
	}

}
