package entities;

public class SavingsAccount extends Account 
{
    private Double InterestRate;

    public SavingsAccount() {
        super();
    }

    public SavingsAccount(Integer number, String holder, Double balance, Double interestRate) {
        super(number, holder, balance);
        this.InterestRate = interestRate;
    }

    public Double getInterestRate() { return this.InterestRate; }
    public void setInterestRate(Double interestRate) { this.InterestRate = interestRate; }

    public void UpdateBalance() {
        this.Balance += this.Balance * this.InterestRate;
    }
    
    @Override
    public void WithDraw(double ammount) {
        this.Balance -= ammount;
        System.out.println("Total of R$ " + this.Balance);
    }
}