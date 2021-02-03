import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.*;
import model.services.*;

public class App {
    public static void main(String[] args) throws Exception 
    {
        Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		System.out.println("Enter rental data");
        System.out.print("Car model: ");
        String carModel = sc.nextLine();
        
		System.out.print("Pickup (dd/MM/yyyy HH:mm): ");
        Date start = sdf.parse(sc.nextLine());
        
		System.out.print("Return (dd/MM/yyyy HH:mm): ");
		Date finish = sdf.parse(sc.nextLine());

		CarRental carRental = new CarRental(start, finish, new Vehicle(carModel));

		System.out.print("Enter price per hour: ");
		double pricePerHour = sc.nextDouble();
		System.out.print("Enter price per day: ");
		double pricePerDay = sc.nextDouble();

		RentalService rentalService = new RentalService(pricePerDay, pricePerHour, new BrazilTaxService());

		rentalService.ProcessInvoice(carRental);

		System.out.println("INVOICE:");
		System.out.println("Basic payment: "+String.format("%.2f", carRental.getInvoice().getBasicPayment()));
		System.out.println("Tax: " + String.format("%.2f", carRental.getInvoice().getTax()));
		System.out.println("Total payment: "+String.format("%.2f", carRental.getInvoice().getTotalPayment()));

		sc.close();
    }
}
