package entities;

public class Account 
{
    private Integer Number;    
    private String Holder;    
    protected Double Balance;

    public Account(Integer Number, String Holder, Double Balance) {
        this.Number = Number;
        this.Holder = Holder;
        this.Balance = Balance;
    }

    public Account() {}

    public Integer getNumber() { return this.Number; }
    public void setNumber(Integer Number) { this.Number = Number; }
    public String getHolder() { return this.Holder; }
    public void setHolder(String Holder) { this.Holder = Holder; }  
    public Double getBalance() { return this.Balance; }

    public void Deposit(double ammount) {
        this.Balance += ammount;
        System.out.println("Deposit of R$ " + ammount);
    }
    
    public void WithDraw(double ammount) {
        this.Balance -= ammount + 5.0;
        System.out.println("Total of R$ " + this.Balance);
    }
}

