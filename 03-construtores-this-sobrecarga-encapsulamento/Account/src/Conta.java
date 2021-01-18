import java.util.Locale;
import java.util.Scanner;

public class Conta {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Account conta;
        
        System.out.print("Enter account number: ");
        int number = sc.nextInt();
        
		System.out.print("Enter account holder: ");
		sc.nextLine();
        String holder = sc.nextLine();
        
		System.out.print("Is there an initial deposit (y/n)? ");
        char response = sc.next().charAt(0);
        
		if (response == 'y') {
			System.out.print("Enter initial deposit value: ");
			double initialDeposit = sc.nextDouble();
			conta = new Account(number, holder, initialDeposit);
		}
		else {
			conta = new Account(number, holder);
		}
		
		System.out.println("\nAccount data:");
		System.out.println(conta);
		
		System.out.print("\nEnter a deposit value: ");
		double depositValue = sc.nextDouble();
        conta.Deposit(depositValue);
        
		System.out.println("Updated account data:");
		System.out.println(conta);
		
		System.out.print("\nEnter a withdraw value: ");
		double withdrawValue = sc.nextDouble();
        conta.WithDraw(withdrawValue);
        
		System.out.println("Updated account data:");
		System.out.println(conta);
		
		sc.close();
    }
}
