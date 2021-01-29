package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product
{
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    private Date ManufactureDate;

    public UsedProduct() { super(); }

    public UsedProduct(String Name, Double Price, Date ManufactureDate) {
        super(Name, Price);
        this.ManufactureDate = ManufactureDate;
    }

    public Date getManufactureDate() {
        return this.ManufactureDate;
    }

    public void setManufactureDate(Date ManufactureDate) {
        this.ManufactureDate = ManufactureDate;
    }
    
    @Override
    public final String PriceTag() {
        return this.getName() + " (used) $ " + this.getPrice() 
        + " (Manufacture date: " + sdf.format(this.getManufactureDate()) + ")";
    }
}
