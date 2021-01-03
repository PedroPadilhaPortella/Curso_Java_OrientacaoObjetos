package estrutura_repetitiva;

import java.util.Scanner;

public class _05_Intervalo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int in = 0;
		int out = 0;
		
		int n = sc.nextInt();
		
		for(int i = 0; i < n; i++)
		{
			int v = sc.nextInt();
			
			if(v >= 10 && v <= 20) {
				in += 1;
			}else {
				out += 1;
			}
		}
		
		 System.out.println(in + " in\n" + out + " out");
		
		sc.close();
	}

}
