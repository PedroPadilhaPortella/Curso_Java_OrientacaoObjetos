package model.services;

import model.entities.CarRental;
import model.entities.Invoice;

public class RentalService
{
    private Double PricePerDay;    
    private Double PricePerHour;
    private TaxService TaxService;

    public RentalService() {}

    public RentalService(Double PricePerDay, Double PricePerHour, TaxService TaxService) {
        this.PricePerDay = PricePerDay;
        this.PricePerHour = PricePerHour;
        this.TaxService = TaxService;
    }

    public void ProcessInvoice(CarRental carRental)
    {
        long t1 = carRental.getStart().getTime();
        long t2 = carRental.getFinish().getTime();
        double hours = (double)(t2 - t1) / 1000 /60 / 60;
        double basicPayment = 0.0;

        if(hours <= 12.0) {
            basicPayment = Math.ceil(hours) * PricePerHour;
        } else {
            basicPayment = Math.ceil(hours / 24) * PricePerDay;
        }

        double tax = TaxService.Tax(basicPayment);

        carRental.setInvoice(new Invoice(basicPayment, tax));
    }
}
