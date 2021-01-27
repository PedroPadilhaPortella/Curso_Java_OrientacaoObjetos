public class OrderItem
{
    private Product Product;
    private Integer Quantity;
    // private Double Price;

    public OrderItem(Product Product, Integer Quantity) {
        this.Product = Product;
        this.Quantity = Quantity;
        // this.Price = Price;
    }

    public OrderItem() {}


    public Product getProduct() {
        return this.Product;
    }

    public void setProduct(Product Product) {
        this.Product = Product;
    }

    public Integer getQuantity() {
        return this.Quantity;
    }

    public void setQuantity(Integer Quantity) {
        this.Quantity = Quantity;
    }

    // public Double getPrice() {
    //     return this.Price;
    // }

    // public void setPrice(Double Price) {
    //     this.Price = Price;
    // }


    public Double SubTotal() {
        return Quantity * Product.getPrice();
    }

    @Override
	public String toString() {
		return Product.getName() 
				+ ", $" 
				+ String.format("%.2f", this.Product.getPrice())
				+ ", Quantity: " 
				+ this.Quantity + 
				", Subtotal: $" 
				+ String.format("%.2f", this.SubTotal());
	}

}
