import java.io.*;
import java.util.*;

import entities.Product;
import services.CalculationService;

public class App {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		
		List<Product> list = new ArrayList<>();

		String path = "src\\in.txt";

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(",");
				list.add(new Product(fields[0], Double.parseDouble(fields[1])));
				line = br.readLine();
			}
			
            Product x = CalculationService.max(list);
            for (Product product : list) {
                System.out.println(product);
            }
			System.out.print("Most expensive:\n-->");
			System.out.println(x);

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		} 
	}
}