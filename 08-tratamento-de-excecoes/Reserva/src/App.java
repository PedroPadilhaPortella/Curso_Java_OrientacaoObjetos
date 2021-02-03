import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exception.DomainException;

public class App {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.print("Room Number: ");
            int number = sc.nextInt();
    
            System.out.print("CheckIn (dd/MM/yyyy): ");
            Date checkin = sdf.parse(sc.next());
            
            System.out.print("CheckOut (dd/MM/yyyy): ");
            Date checkout = sdf.parse(sc.next());
    
            Reservation reservation = new Reservation(number, checkin, checkout);
            System.out.println("Resevation: " + reservation);
    

            
            System.out.println("\nEnter data to update the reservation:");

            System.out.print("CheckIn (dd/MM/yyyy): ");
            checkin = sdf.parse(sc.next());

            System.out.print("CheckOut (dd/MM/yyyy): ");
            checkout = sdf.parse(sc.next());
            
            reservation.UpdateDates(checkin, checkout);
            System.out.println("Resevation: " + reservation);

        }
        catch(ParseException e) {
            System.out.println("Error: Invalid Date Format");
        }
        catch(IllegalArgumentException e) {
            System.out.println("Error in reservation: " + e.getMessage());
        }
        catch(DomainException e) {
            System.out.println("Error in reservation: " + e.getMessage());
        }
        catch(RuntimeException e) {
            System.out.println("Unexpected Error: " + e.getMessage());
        }
        finally {
            sc.close();
        }
    }
}
