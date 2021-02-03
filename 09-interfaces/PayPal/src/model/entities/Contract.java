package model.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contract 
{
    private Integer Number;    
    private Date Date;    
    private Double TotalValue;
    private List<Installment> installments = new ArrayList<>();

    public Contract() {}

    public Contract(Integer Number, Date Date, Double TotalValue) {
        this.Number = Number;
        this.Date = Date;
        this.TotalValue = TotalValue;
    }

    public Integer getNumber() {
        return this.Number;
    }

    public void setNumber(Integer Number) {
        this.Number = Number;
    }

    public Date getDate() {
        return this.Date;
    }

    public void setDate(Date Date) {
        this.Date = Date;
    }

    public Double getTotalValue() {
        return this.TotalValue;
    }

    public void setTotalValue(Double TotalValue) {
        this.TotalValue = TotalValue;
    }

    public List<Installment> getInstallments() {
		return installments;
	}

	public void addInstallment(Installment installment) {
		installments.add(installment);
	}

	public void removeInstallment(Installment installment) {
		installments.remove(installment);
	}
}
