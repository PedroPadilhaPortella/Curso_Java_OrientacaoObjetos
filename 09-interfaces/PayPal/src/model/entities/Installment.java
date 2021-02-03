package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Installment 
{
    private Date DueDate;
    private Double Amount;
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Installment() {}

    public Installment(Date DueDate, Double Amount) {
        this.DueDate = DueDate;
        this.Amount = Amount;
    }

    public Date getDueDate() {
        return this.DueDate;
    }

    public void setDueDate(Date DueDate) {
        this.DueDate = DueDate;
    }

    public Double getAmount() {
        return this.Amount;
    }

    public void setAmount(Double Amount) {
        this.Amount = Amount;
    }

    @Override
	public String toString() {
		return sdf.format(DueDate) + " - " + String.format("%.2f", Amount);
 	}
}
