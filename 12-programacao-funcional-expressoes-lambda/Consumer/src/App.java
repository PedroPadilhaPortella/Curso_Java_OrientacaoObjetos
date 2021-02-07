import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import entities.Product;
import util.PriceUpdate;

public class App {
    public static void main(String[] args) throws Exception {
        
        List<Product> list = new ArrayList<>();
        list.add(new Product("Tv", 900.00));
        list.add(new Product("Mouse", 50.00));
        list.add(new Product("Tablet", 350.50));
        list.add(new Product("HD Case", 80.90));


        list.forEach(new PriceUpdate()); //usando classe Consumer

        list.forEach(Product::staticPriceUpdate); //usando uma classe estatica

        list.forEach(Product::notStaticPriceUpdate); //usando uma classe não estatica

        double factor = 1.1;
        Consumer<Product> consumer = p -> p.setPrice(p.getPrice() * factor);
        list.forEach(consumer); //expressao lamdba declarada

        list.forEach(p -> p.setPrice(p.getPrice() * 1.1)); //expressao lambda inline


        list.forEach(System.out::println);
    }
}
