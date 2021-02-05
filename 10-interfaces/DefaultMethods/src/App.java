import java.util.Locale;
import java.util.Scanner;

import entities.*;

public class App {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Amount: ");
        double amount = sc.nextDouble();
        System.out.print("Months: ");
        int months = sc.nextInt();

        InterestService brazilIS = new BrazilInterestService(2.0);
        double payment = brazilIS.payment(amount, months);

        System.out.println("Payment after" + months + " months: ");
        System.out.println("R$ " + String.format("%.2f", payment));



        System.out.println("\n\n");



        System.out.print("Amount: ");
        amount = sc.nextDouble();
        System.out.print("Months: ");
        months = sc.nextInt();

        InterestService usaIS = new BrazilInterestService(1.0);
        payment = usaIS.payment(amount, months);

        System.out.println("Payment after" + months + " months: ");
        System.out.println("R$ " + String.format("%.2f", payment));


        sc.close();
    }
}