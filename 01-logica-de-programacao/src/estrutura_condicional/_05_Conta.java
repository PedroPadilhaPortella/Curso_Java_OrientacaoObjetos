package estrutura_condicional;

import java.util.Scanner;

public class _05_Conta {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Código Quantidade");
		int code = sc.nextInt();
		int quantidade = sc.nextInt();
		double preco = 0;
		double total = 0;
		boolean teste = true;
		
		switch(code) {
			case 1:
				preco = 4.0;
				break;
			case 2:
				preco = 4.5;
				break;
			case 3:
				preco = 5.0;
				break;
			case 4:
				preco = 2.0;
				break;
			case 5:
				preco = 1.5;
				break;
			default:
				System.out.println("Valor Inválido");
				teste = false;
		}
		total = preco * quantidade;
		if(teste) {
			System.out.printf("BILL R$ %s", total);
		}
		
		
		sc.close();
	}

}
