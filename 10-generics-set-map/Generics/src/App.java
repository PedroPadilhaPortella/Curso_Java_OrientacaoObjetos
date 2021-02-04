import java.util.Scanner;

import entities.PrintService;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);


        PrintService<Integer> ps = new PrintService<Integer>();
        System.out.print("How many values? ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            Integer value = sc.nextInt();
            ps.addValue(value);
        }
        ps.print();
        System.out.println("First: " + ps.first());



        PrintService<String> ps2 = new PrintService<String>();
        System.out.print("How many values? ");
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String value = sc.next();
            ps2.addValue(value);
        }
        ps2.print();
        System.out.println("First: " + ps2.first());

        sc.close();
    }
}
