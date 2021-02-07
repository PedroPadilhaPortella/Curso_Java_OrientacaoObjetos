package entities;

import java.util.Objects;

public class Product /*implements Comparable<Product>*/{
    
    private String Name;
    private Double Price;


    public Product(String Name, Double Price) {
        this.Name = Name;
        this.Price = Price;
    }

    public String getName() {
        return this.Name;
    }
    public void setName(String Name) {
        this.Name = Name;
    }
    public Double getPrice() {
        return this.Price;
    }
    public void setPrice(Double Price) {
        this.Price = Price;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Product)) {
            return false;
        }
        Product product = (Product) o;
        return Objects.equals(Name, product.Name) && Objects.equals(Price, product.Price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Name, Price);
    }

    // @Override
    // public int compareTo(Product other) {
    //     return Name.toUpperCase().compareTo(other.getName().toUpperCase());
    // }

    public static boolean staticProductPredicate(Product p) {
        return p.getPrice() >= 100;
    }

    public boolean notStaticProductPredicate() {
        return this.getPrice() >= 100;
    }

    @Override
    public String toString() {
        return "Product [ Name='" + getName() + "', Price='" + getPrice() + "' ]";
    }
}