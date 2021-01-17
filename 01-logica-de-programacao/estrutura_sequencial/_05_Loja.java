package estrutura_sequencial;

import java.util.Locale;
import java.util.Scanner;

public class _05_Loja {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		int quantidade = sc.nextInt();
		double preco = sc.nextDouble();
		sc.nextLine();
		
		double total = quantidade * preco;
		
		quantidade = sc.nextInt();
		preco = sc.nextDouble();
		total += quantidade * preco;
		
		System.out.println("BILL: U$" + total);
		
		sc.close();
	}
}