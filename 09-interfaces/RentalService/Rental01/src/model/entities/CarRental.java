package model.entities;

import java.util.Date;

public class CarRental 
{
    private Date Start;    
    private Date Finish;
    private Vehicle Vehicle;
    private Invoice Invoice;

    public CarRental() {}


    public CarRental(Date Start, Date Finish, Vehicle vehicle) {
        this.Start = Start;
        this.Finish = Finish;
        this.Vehicle = vehicle;
    }


    public Date getStart() {
        return this.Start;
    }

    public void setStart(Date Start) {
        this.Start = Start;
    }

    public Date getFinish() {
        return this.Finish;
    }

    public void setFinish(Date Finish) {
        this.Finish = Finish;
    }

    public Vehicle getVehicle() {
        return this.Vehicle;
    }

    public void setVehicle(Vehicle Vehicle) {
        this.Vehicle = Vehicle;
    }

    public Invoice getInvoice() {
        return this.Invoice;
    }

    public void setInvoice(Invoice Invoice) {
        this.Invoice = Invoice;
    }    
}
