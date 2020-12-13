package estrutura_sequencial;

import java.util.Locale;
import java.util.Scanner;

public class _06_Poligonos {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		double a = sc.nextDouble();
		double b = sc.nextDouble();
		double c = sc.nextDouble();
		
		double triangulo = (a * c) / 2;
		double circulo = Math.pow(c, 2) * Math.PI;
		double trapezio = (a + b) * c / 2;
		double quadrado = Math.pow(b, 2);
		double retangulo = a * b;
		
		System.out.println("TRIANGULO: " + triangulo);
		System.out.println("CIRCULO: " + circulo);
		System.out.println("TRAPEZIO: " + trapezio);
		System.out.println("QUADRADO: " + quadrado);
		System.out.println("RETANGULO: " + retangulo);
		
		sc.close();
	}
}