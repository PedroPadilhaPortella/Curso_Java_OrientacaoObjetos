package entities;

public abstract class TaxPayer 
{
    private String Name;
    private double AnualIncome;

    public TaxPayer() {}

    public TaxPayer(String Name, double AnualIncome) {
        this.Name = Name;
        this.AnualIncome = AnualIncome;
    }
    

    public String getName() {
        return this.Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public double getAnualIncome() {
        return this.AnualIncome;
    }

    public void setAnualIncome(double AnualIncome) {
        this.AnualIncome = AnualIncome;
    }

    public abstract double Tax();
}