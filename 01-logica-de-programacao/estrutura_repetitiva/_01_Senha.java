package estrutura_repetitiva;

import java.util.Scanner;

public class _01_Senha {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int senha;
		
		while(true) {
			senha = sc.nextInt();
			if(senha == 2002) {
				System.out.println("Acesso Permitido!");
				break;
			}
			else {
				System.out.println("Senha Inválida!");
			}
		}
		
		sc.close();

	}

}
