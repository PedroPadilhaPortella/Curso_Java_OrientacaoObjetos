package estrutura_condicional;

import java.util.Scanner;

public class _03_Multiplos {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		if(n % m == 0 || m % n == 0)
			System.out.print("São Multiplos");
		else
			System.out.print("Não são Multiplos");
		
		sc.close();
	}

}
