public final class OutsourcedEmployee extends Employee
{
    private Double AdditionalCharge;   
    
    public OutsourcedEmployee() {
        super();
    }

    public OutsourcedEmployee(String name, Integer hours, Double valuePerHour, Double AdditionalCharge) {
        super(name, hours, valuePerHour);
        this.AdditionalCharge = AdditionalCharge;
    }

    public Double getAdditionalCharge() {
        return this.AdditionalCharge;
    }

    public void setAdditionalCharge(Double AdditionalCharge) {
        this.AdditionalCharge = AdditionalCharge;
    }

    @Override
    public double payment() {
        return super.payment() + this.AdditionalCharge * 1.1;
    }
}