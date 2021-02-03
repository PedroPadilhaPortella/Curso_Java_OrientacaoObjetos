package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exception.DomainException;

public class Reservation
{
    private Integer RoomNumber;
    private Date CheckIn;
    private Date CheckOut;  

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    public Reservation() {}

    public Reservation(Integer RoomNumber, Date CheckIn, Date CheckOut) throws DomainException {
        if(!CheckOut.after(CheckIn))
            throw new DomainException("Check-out date must be after check-in date");
        this.RoomNumber = RoomNumber;
        this.CheckIn = CheckIn;
        this.CheckOut = CheckOut;
    }


    public Integer getRoomNumber() {
        return this.RoomNumber;
    }

    public void setRoomNumber(Integer RoomNumber) {
        this.RoomNumber = RoomNumber;
    }

    public Date getCheckIn() {
        return this.CheckIn;
    }

    public Date getCheckOut() {
        return this.CheckOut;
    }

    public long Duration() {
        long diff = CheckOut.getTime() - CheckIn.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public void UpdateDates(Date checkin, Date checkout) throws DomainException
    {
        Date now = new Date();
        if(checkin.before(now) || checkout.before(now))
            throw new DomainException("Error in reservation: Reservation dates for update must be future dates");
        
        if(!checkout.after(checkin))
                throw new DomainException("Error in reservation: Check-out date must be after check-in date");
        
        this.CheckIn = checkin;
        this.CheckOut = checkout;
    }

    @Override
	public String toString() {
        return "Room " + RoomNumber + ", check-in: " + sdf.format(CheckIn) 
        + ", check-out: " + sdf.format(CheckOut) + ", " + Duration() + " nights";
	}
}