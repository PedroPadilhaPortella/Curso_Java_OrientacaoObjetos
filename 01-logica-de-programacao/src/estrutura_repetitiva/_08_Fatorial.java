package estrutura_repetitiva;

import java.util.Scanner;

public class _08_Fatorial {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int fat = 1;
		int n = sc.nextInt();
		
		for(int i = 1; i <= n; i++) {
			fat *= i;
		}
				
		System.out.println(fat);
		
		sc.close();
	}

}