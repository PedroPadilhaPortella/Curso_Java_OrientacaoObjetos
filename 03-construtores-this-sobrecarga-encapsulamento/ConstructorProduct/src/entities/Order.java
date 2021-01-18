package entities;

import java.util.Date;

public class Order {
    private Date Date;
    private Product Product;

    public Order(Date date, Product product) {
        this.Date = date;
        this.Product = product;
    }

    public Date getDate() {
        return this.Date;
    }

    public void setDate(Date date) {
        this.Date = date;
    }

    public Product getProduct() {
        return this.Product;
    }

    public void setProduct(Product product) {
        this.Product = product;
    }
}