package estrutura_sequencial;

import java.util.Date;

public class FirstJavaClass {

	public static void main(String[] args) {
		String nome = "Maria";
		int idade = 31;
		double renda = 4000.0;
		System.out.printf("%s tem %d anos e ganha R$ %.2f reais%n", nome, idade, renda);
		
		Date relogio = new Date();
		System.out.print("A hora do sistema é " + relogio.toString());
	}
}