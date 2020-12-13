package estrutura_condicional;

import java.util.Scanner;

public class _02_ParImpar {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(n % 2 == 0)
			System.out.print("Par");
		else
			System.out.print("Impar");
		
		sc.close();
	}
}