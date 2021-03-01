package application;

import java.util.List;

import model.dao.DAOFactory;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		System.out.println("==== Teste 1: Seller findById ====");
		SellerDAO sellerDao = DAOFactory.createSellerDAO();		
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n==== Teste 2: Seller findByDepartment ====");
		Department department = new Department(2, null);
		List<Seller> sellers = sellerDao.findByDepartment(department);
		
		for (Seller obj : sellers) {
			System.out.println(obj);			
		}
	}
}