package model.entities;

import model.exceptions.DomainException;

public class Account
{
    private int Number;
    private String Holder;
    private double Balance;
    private double WithdrawLimit;

    public Account() {}

    public Account(int Number, String Holder, double Balance, double WithdrawLimit) {
        this.Number = Number;
        this.Holder = Holder;
        this.Balance = Balance;
        this.WithdrawLimit = WithdrawLimit;
    }

    public int getNumber() {
        return this.Number;
    }

    public String getHolder() {
        return this.Holder;
    }

    public void setHolder(String Holder) {
        this.Holder = Holder;
    }

    public double getBalance() {
        return this.Balance;
    }

    public double getWithdrawLimit() {
        return this.WithdrawLimit;
    }

    public void setWithdrawLimit(double withdrawLimit) {
        this.WithdrawLimit = withdrawLimit;
    }

    public void Deposit(double amount) 
    {
        this.Balance += amount;
    }

    public void Withdraw(double amount) throws DomainException
    {
        if (amount > getWithdrawLimit())
            throw new DomainException("The amount exceeds withdraw limit");
            
		if (amount > getBalance())
			throw new DomainException("Not enough balance");
		
		this.Balance -= amount;
    }
}