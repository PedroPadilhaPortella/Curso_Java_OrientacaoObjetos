package services;

import java.util.List;
import java.util.function.Predicate;

import entities.Product;

public class ProductService {
    
    public Double filteredSum(List<Product> list, Predicate<Product> criterial) {
        Double sum = 0.0;
        
        for (Product p : list) {
            if(criterial.test(p))
                sum += p.getPrice();       
        }
        
        return sum;
    }
}
