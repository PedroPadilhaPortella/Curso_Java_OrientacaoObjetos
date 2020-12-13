package estrutura_sequencial;

import java.util.Locale;
import java.util.Scanner;

public class EntradaDeDados {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		//string x;
		//int y;
		//double z;
		//char a;
		//x = sc.next();
		//y = sc.nextInt();
		//z = sc.nextDouble();
		//a = sc.next().charAt(0);
		
		//String x;
		//int y;
		//double z;
		//x = sc.next();
		//y = sc.nextInt();
		//z = sc.nextDouble();
		//System.out.println("Voce digitou: ");
		//System.out.println(x);
		//System.out.println(y);
		//System.out.println(z);
		
		String s1, s2, s3;
		s1 = sc.nextLine();
		s2 = sc.nextLine();
		s3 = sc.nextLine();
		System.out.println("DADOS DIGITADOS:");
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		
		int x;
		String s4, s5, s6;
		x = sc.nextInt();
		sc.nextLine();
		s4 = sc.nextLine();
		s5 = sc.nextLine();
		s6 = sc.nextLine();
		System.out.println("DADOS DIGITADOS:");
		System.out.println(x);
		System.out.println(s4);
		System.out.println(s5);
		System.out.println(s6);
		
		sc.close();
	}
}