package entities;

public class Product 
{
    private String Name;
    private Double Price;

    public Product() {}

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

    public String PriceTag() {
        return this.getName() + " $ " + this.getPrice();
    }
}