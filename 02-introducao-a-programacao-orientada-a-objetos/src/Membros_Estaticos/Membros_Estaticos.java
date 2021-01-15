package Membros_Estaticos;

import java.util.Locale;
import java.util.Scanner;


public class Membros_Estaticos {
	
	// public static final double PI = Math.PI;

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		//Calculator calc = new Calculator();
		
		System.out.println("Enter Radius: ");
		double radius = sc.nextDouble();
		double c = Calculator.circunference(radius);
		double v = Calculator.volume(radius);
		
		System.out.printf("Circunference: %.2f%n", c);
		System.out.printf("Volume: %.2f%n", v);
		System.out.printf("PI Value: %.2f%n", Calculator.PI);
		
		
		sc.close();
	}

	//public static double circunference(double radius) {
	//	return 2 * PI * radius;
	//}
	
	//public static double volume(double radius) {
	//	return 4 * PI * Math.pow(radius, 3) / 3.0;
	//}
}
