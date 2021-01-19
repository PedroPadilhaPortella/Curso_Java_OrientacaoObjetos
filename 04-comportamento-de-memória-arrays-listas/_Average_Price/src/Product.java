public class Product {
    private String Name;
    private double Price;

    public Product(String name, double price) {
        Name = name;
        Price = price;
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public double getPrice() {
        return this.Price;
    }

    public void setPrice(double price) {
        this.Price = price;
    }

    public String toString() {
        return this.Name + ", R$ " + this.Price;
    }
}
