package estrutura_sequencial;

import java.util.Locale;
import java.util.Scanner;

public class _02_AreaCirculo {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		double area, raio;
		double pi = Math.PI;
		raio = sc.nextDouble();
		area = Math.pow(raio, 2) * pi;
		System.out.println("Area: " + area);
		
		sc.close();
	}
}