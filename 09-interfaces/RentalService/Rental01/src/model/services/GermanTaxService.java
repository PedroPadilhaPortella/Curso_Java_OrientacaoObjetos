package model.services;

public class GermanTaxService implements TaxService
{

    @Override
    public double Tax(double amount) {
        if(amount <= 100.0)
                return amount * 0.1;
            else
                return amount * 0.05;
    }
    
}
