import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Product[] produtos = new Product[n];

        for (int i = 0; i < produtos.length; i++) {
            sc.nextLine();
            String name = sc.nextLine();
            double price = sc.nextDouble();
            Product produto = new Product(name, price);
            produtos[i] = produto;
        }

        double sum = 0.0;
        for (int i = 0; i < produtos.length; i++) {
            sum += produtos[i].getPrice();
            System.out.println(produtos[i]);
        }

        double average = sum / produtos.length;
        System.out.printf("%nAVERAGE PRICE = %.2f", average);

        sc.close();
    }
}
