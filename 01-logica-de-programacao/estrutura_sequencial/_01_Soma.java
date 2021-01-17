package estrutura_sequencial;

import java.util.Locale;
import java.util.Scanner;

public class _01_Soma {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		int a, b, soma;
		a = sc.nextInt();
		sc.nextLine();
		b = sc.nextInt();
		soma = a + b;
		System.out.println("Soma: " + soma);
		
		sc.close();
	}
}