import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import entities.*;
import util.ProductPredicate;

public class App {
    public static void main(String[] args) throws Exception {
        
        List<Product> list = new ArrayList<>();

        list.add(new Product("Tv", 900.00));
        list.add(new Product("Mouse", 50.00));
        list.add(new Product("Tablet", 350.50));
        list.add(new Product("HD Case", 80.90));

        
        list.removeIf(Product::staticProductPredicate); //usando metodo estatico
        
        list.removeIf(Product::notStaticProductPredicate); //usando metodo não estatico
        
        list.removeIf(new ProductPredicate()); //usando predicate

        double min = 100.0;
        Predicate<Product> predicado = p -> p.getPrice() >= min;
        list.removeIf(predicado); //usando expressao lambda declarada
        
        list.removeIf(p -> p.getPrice() >= 100); //usando expressao lambda inline

        
        for (Product product : list) {
            System.out.println(product);
        }
    }
}
