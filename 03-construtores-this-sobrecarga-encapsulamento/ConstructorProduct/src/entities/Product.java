package entities;

public class Product {

    private String Name;
    private double Price;
    private int Quantity;

    public Product() { }

    public Product(String name, double price) {
        this.Name = name;
        this.Price = price;
    }

    public Product(String name, double price, int quantity) {
        this.Name = name;
        this.Price = price;
        this.Quantity = quantity;
    }

    public double totalValueInStock() {
        return Price * Quantity;
    }

    public void addProducts(int quantity) {
        this.Quantity += quantity;
    }

    public void removeProducts(int quantity) {
        this.Quantity -= quantity;
    }

    public String toString() {
        return Name + ", $ " + String.format("%.2f", this.getPrice()) + ", " + this.getQuantity() + " units, Total: $ "
                + String.format("%.2f", totalValueInStock());
    }


    public String getName() {
        return this.Name;
    }

    public void setName(final String name) {
        this.Name = name;
    }

    public double getPrice() {
        return this.Price;
    }

    public void setPrice(final double price) {
        this.Price = price;
    }

    public int getQuantity() {
        return this.Quantity;
    }
}