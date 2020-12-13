package estrutura_sequencial;

import java.util.Locale;
import java.util.Scanner;

public class _03_Diferenca {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		double diferenca;
		double a = sc.nextDouble();
		sc.nextLine();
		double b = sc.nextDouble();
		sc.nextLine();
		double c = sc.nextDouble();
		sc.nextLine();
		double d = sc.nextDouble();
		sc.nextLine();
		diferenca = (a * b - c * d);
		
		System.out.println("Diferença: " + diferenca);
		
		sc.close();
	}
}