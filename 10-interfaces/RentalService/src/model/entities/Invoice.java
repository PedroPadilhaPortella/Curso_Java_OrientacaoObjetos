package model.entities;

public class Invoice
{
    private double BasicPayment;    
    private double Tax;
    
    public Invoice() {}

    public Invoice(double BasicPayment, double Tax) {
        this.BasicPayment = BasicPayment;
        this.Tax = Tax;
    }

    public double getBasicPayment() {
        return this.BasicPayment;
    }

    public void setBasicPayment(double BasicPayment) {
        this.BasicPayment = BasicPayment;
    }

    public double getTax() {
        return this.Tax;
    }

    public void setTax(double Tax) {
        this.Tax = Tax;
    }


    public Double getTotalPayment() {
        return getBasicPayment() + getTax();
    }
}
