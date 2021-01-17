package estrutura_condicional;

import java.util.Scanner;

public class _01_NegativoPositivo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(n >= 0)
			System.out.print("Positivo");
		else
			System.out.print("Negativo");
		
		sc.close();
	}	

}
