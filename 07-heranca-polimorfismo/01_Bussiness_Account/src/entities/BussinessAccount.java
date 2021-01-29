package entities;

public class BussinessAccount extends Account
{
    private Double LoanLimit;
    
    public BussinessAccount() {
        super();
    }

    public BussinessAccount(Integer number, String holder, Double balance, Double loanLimit) {
        super(number, holder, balance);
        this.LoanLimit = loanLimit;
    }


    public Double getLoanLimit() { return this.LoanLimit; }

    public void setLoanLimit(Double LoanLimit) { this.LoanLimit = LoanLimit; }

    public void Loan(double amount) {
        if (amount <= LoanLimit) {
            Balance += amount - 10.0;
            System.out.println("Loan of R$ " + amount + " Approved");
        }
    }

    @Override
    public String toString() {
        return "Number: " + getNumber() + "\nHolder: " + getHolder() + "\nBalance: R$ " + getBalance() + 
        "\nLoanLimit: R$ " + getLoanLimit();
    }

    @Override
    public void WithDraw(double ammount) {
        super.WithDraw(ammount);
        this.Balance -=  2;
        System.out.println("Total of R$ " + this.Balance);
    }

}
