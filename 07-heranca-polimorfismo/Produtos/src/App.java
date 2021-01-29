import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class App {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        List<Product> produtos = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++)
        {

            Product produto;
            System.out.println("Product #"+ i +" data:");

            System.out.print("Common, used or imported (c/u/i)? ");
            sc.nextLine();
            char type = sc.nextLine().charAt(0);

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Price: ");
            double price = sc.nextDouble();

            if(type == 'i') {
                System.out.print("Customs fee: ");
                double fee = sc.nextDouble();
                produto = new ImportedProduct(name, price, fee);

            } else if(type == 'u') {
                System.out.print("Manufacture Date (DD/MM/YYYY): ");
                Date date = sdf.parse(sc.next());
                produto = new UsedProduct(name, price, date);

            } else {
                produto = new Product(name, price);
            }

            produtos.add(produto);
        }

        System.out.println("PRICE TAGS:");
        for (Product product : produtos) {
            System.out.println(product.PriceTag());
        }

        sc.close();
    }
}
