package entities;

public class Company extends TaxPayer
{
    private int NumberOfEmployees;

    public Company() { super(); }


    public Company(String Name, double AnualIncome, int NumberOfEmployees) {
        super(Name, AnualIncome);
        this.NumberOfEmployees = NumberOfEmployees;
    }

    public int getNumberOfEmployees() {
        return this.NumberOfEmployees;
    }

    public void setNumberOfEmployees(int NumberOfEmployees) {
        this.NumberOfEmployees = NumberOfEmployees;
    }

    @Override
    public double Tax() {
        if(this.getNumberOfEmployees() >= 10)
            return getAnualIncome() * 0.14;
        else
            return getAnualIncome() * 0.16;
    }
}