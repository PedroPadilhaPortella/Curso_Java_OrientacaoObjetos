public class Account {
    private int Number;
    private String Holder;
    private double Balance;

    public Account(int number, String holder, double balance) {
        this.Number = number;
        this.Holder = holder;
        this.Balance = balance;
    }

    public Account(int number, String holder) {
        this.Number = number;
        this.Holder = holder;
        this.Balance = 0;
    }

    public void Deposit(double ammount) {
        this.Balance += ammount;
    }

    public void WithDraw(double ammount) {
        double tax = 5;
        this.Balance -= (ammount + tax);
    }

    public int getNumber() {
        return this.Number;
    }

    public String getHolder() {
        return this.Holder;
    }

    public void setHolder(String holder) {
        this.Holder = holder;
    }

    public double getBalance() {
        return this.Balance;
    }

    public String toString() {
        return "Account " + this.getNumber() + ", Holder: " + this.getHolder()
        + ", Balance: $ " + String.format("%.2f", this.getBalance());
    }

}