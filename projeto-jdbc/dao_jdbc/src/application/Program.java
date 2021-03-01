package application;

import java.util.Date;

import model.dao.DAOFactory;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Department department = new Department(1, "Books");
		System.out.println(department);

		Seller seller = new Seller(1, "Bob", "bob@gmail.com", new Date(), 1200.0, department);
		System.out.println(seller);
		
		SellerDAO sellerDao = DAOFactory.createSellerDAO(); //Factory e injeção de dependecia
	}

}
