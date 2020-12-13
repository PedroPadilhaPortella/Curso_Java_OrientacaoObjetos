package estrutura_condicional;

import java.util.Scanner;

public class EstruturaCondicional {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Que horas são agora? ");
		int hora = sc.nextInt();
		
		if(hora > 18 || hora < 6) {
			System.out.println("Boa Noite");			
		}else if(hora < 13) {
			System.out.println("Bom dia");			
		}else if(hora >= 13 || hora <= 18) {
			System.out.println("Boa Tarde");			
		}
		
		sc.close();
	}
}