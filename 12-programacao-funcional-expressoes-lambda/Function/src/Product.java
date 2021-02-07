import java.util.Objects;

public class Product {
    
    private String Name;
    private Double Price;


    public Product(String Name, Double Price) {
        this.Name = Name;
        this.Price = Price;
    }

    public String getName() { return this.Name; }
    public void setName(String Name) { this.Name = Name; }

    public Double getPrice() { return this.Price; }
    public void setPrice(Double Price) { this.Price = Price; }


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

    public static String staticUpperCaseName(Product p) {
        return p.getName().toUpperCase();
    }
    
    public String notStaticUpperCaseName() {
        return this.getName().toUpperCase();
    }

    @Override
    public String toString() {
        return "Product [ Name='" + getName() + "', Price='" + getPrice() + "' ]";
    }
}