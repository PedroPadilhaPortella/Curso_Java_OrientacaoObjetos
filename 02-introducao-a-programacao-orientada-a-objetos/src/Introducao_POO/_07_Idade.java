package Introducao_POO;

import java.util.Scanner;

public class _07_Idade {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int idade = sc.nextInt();
		
		int anos = idade / 365;
		idade -= idade/365;
		int meses = idade/30;
		idade -= idade/ 30;
		int dias = idade;
		
		System.out.println(anos + "ano(s)");
		System.out.println(meses + "mes(es)");
		System.out.println(dias + "dia(s)");

		sc.close();
	}

}
