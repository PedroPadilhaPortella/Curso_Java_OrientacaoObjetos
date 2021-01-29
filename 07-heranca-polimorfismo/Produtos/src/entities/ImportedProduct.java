package entities;

public class ImportedProduct extends Product
{
    private Double CustomsFee;

    public ImportedProduct() { super(); }


    public ImportedProduct(String Name, Double Price, Double CustomsFee) {
        super(Name, Price);
        this.CustomsFee = CustomsFee;
    }

    public Double getCustomsFee() {
        return this.CustomsFee;
    }

    public void setCustomsFee(Double CustomsFee) {
        this.CustomsFee = CustomsFee;
    }

    @Override
    public final String PriceTag() {
        return this.getName() + " $ " + this.getPrice() + " (Customs fee $ " + this.getCustomsFee() + ")";
    }

}
