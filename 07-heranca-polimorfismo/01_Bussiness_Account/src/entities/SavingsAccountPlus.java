package entities;

public final class SavingsAccountPlus extends SavingsAccount {
    @Override
    public final void WithDraw(double amount) {
        this.Balance -= amount + 1.0;
    }
}
