package estrutura_condicional;

import java.util.Scanner;

public class _04_DuracaoJogo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int initialTime = sc.nextInt();
		int finalTime = sc.nextInt();
		int total = 0;
		
		if(initialTime >= 0 && initialTime <= 24 && finalTime >= 0 && finalTime <= 24) {
			if(finalTime > initialTime)
				total = finalTime - initialTime;
			else
				total = 24 - initialTime + finalTime;
		}
		System.out.printf("O Jogo durou %s horas.", total);
		
		sc.close();
	}
}