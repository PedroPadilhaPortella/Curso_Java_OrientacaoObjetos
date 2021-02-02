import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.*;

public class App {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<TaxPayer> impostos = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++)
        {
            System.out.println("Tax payer #" + i + " data:");
            System.out.print("Individual or company (i/c)? ");
            char ch = sc.next().charAt(0);

            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();

            System.out.print("Anual Income: ");
            double anualIncome = sc.nextDouble();
            
            if(ch == 'i') {
                System.out.print("Health expenditures: ");
                double healthExpenditure = sc.nextDouble();
                impostos.add(new Individual(name, anualIncome, healthExpenditure));

            } else {
                System.out.print("Number of employees: ");
                int numberOfEmployees = sc.nextInt();
                impostos.add(new Company(name, anualIncome, numberOfEmployees));
            }
        }

        double total = 0.0;
        System.out.println("TAXES PAID:");
        for (TaxPayer taxPayer : impostos) {
            System.out.println(taxPayer.getName() + ", R$ " + String.format("%.2f", taxPayer.Tax()));
            total += taxPayer.Tax();
        }

        System.out.println("\nTOTAL TAXES: R$ " + String.format("%.2f", total));

        sc.close();
    }
}
