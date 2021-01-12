package Application;

import java.util.Locale;
import java.util.Scanner;

import Entities.Rectangle;

public class Exercicio_1 {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Rectangle rectangle = new Rectangle();
		System.out.println("Enter rectangle width and height:");
		rectangle.width = sc.nextDouble();
		rectangle.height = sc.nextDouble();
		
		System.out.println("Area: " + rectangle.getArea());
		System.out.println("Perimeter: " + rectangle.getPerimeter());
		System.out.println("Diagonal: " + rectangle.getDiagonal());
		
		sc.close();
	}

}
