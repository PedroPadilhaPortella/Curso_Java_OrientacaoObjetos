package entities;

public class Individual extends TaxPayer
{
    private double HealthExpeditures;

    public Individual() { super(); }

    public Individual(String Name, double AnualIncome, double HealthExpeditures) {
        super(Name, AnualIncome);
        this.HealthExpeditures = HealthExpeditures;
    }

    public double getHealthExpeditures() {
        return this.HealthExpeditures;
    }

    public void setHealthExpeditures(double HealthExpeditures) {
        this.HealthExpeditures = HealthExpeditures;
    }

    @Override
    public double Tax()
    {
        if(this.getAnualIncome() < 20000.0)
            return getAnualIncome() * 0.15 - this.getHealthExpeditures() * 0.5;
        else
            return getAnualIncome() * 0.25 - this.getHealthExpeditures() * 0.5;
    }
}
