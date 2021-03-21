import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws Exception {
        
        List<Product> list = new ArrayList<>();
        list.add(new Product("Tv", 900.00));
        list.add(new Product("Mouse", 50.00));
        list.add(new Product("Tablet", 350.50));
        list.add(new Product("HD Case", 80.90));

        List<String> names;

        names = list.stream().map(new UpperCaseName()).collect(Collectors.toList()); //interface function
        
        names = list.stream().map(Product::staticUpperCaseName).collect(Collectors.toList()); //metodo estatico
        
        names = list.stream().map(Product::notStaticUpperCaseName).collect(Collectors.toList()); //metodo nao estatico
        
        Function<Product, String> touppercase = p -> p.getName().toUpperCase();
        names = list.stream().map(touppercase).collect(Collectors.toList()); //expressao lambda declarada

        names = list.stream().map(p -> p.getName().toUpperCase()).collect(Collectors.toList()); //expressao lambda inline
        
        names.forEach(System.out::println);
    }
}