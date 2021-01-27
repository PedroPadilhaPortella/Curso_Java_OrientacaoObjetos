public class Product
{
    private String Name;    
    private Double Price;
    
    public Product(String name, Double price) {
        this.Name = name;
        this.Price = price;
    }

    public Product() {}


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
}
