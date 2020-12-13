package estrutura_sequencial;

import java.util.Locale;
import java.util.Scanner;

public class _04_Funcionario {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		int numero = sc.nextInt();
		sc.nextLine();
		int horasTrabalhadas = sc.nextInt();
		sc.nextLine();
		double valorPorHora = sc.nextDouble();
		sc.nextLine();
		double salario = horasTrabalhadas * valorPorHora;
		
		System.out.println("NUMBER: " + numero);
		System.out.println("SALARY: U$" + salario);
		
		sc.close();
	}
}