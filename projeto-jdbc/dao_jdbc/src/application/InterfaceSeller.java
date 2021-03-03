package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DAOFactory;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

public class InterfaceSeller {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		SellerDAO sellerDao = DAOFactory.createSellerDAO();		
		
		System.out.println("==== Teste 1: Seller findById ====");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n==== Teste 2: Seller findByDepartment ====");
		Department department = new Department(2, null);
		List<Seller> sellers = sellerDao.findByDepartment(department);
		for (Seller obj : sellers) {
			System.out.println(obj);			
		}
		
		System.out.println("\n==== Teste 3: Seller findAll ====");
		sellers = sellerDao.findAll();
		for (Seller obj : sellers) {
			System.out.println(obj);			
		}
		
		System.out.println("\n==== Teste 4: Seller insert ====");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted seller with id " + newSeller.getId());
		
		System.out.println("\n==== Teste 5: Seller update ====");
		seller = sellerDao.findById(8);
		seller.setName("Pedro Barcot");
		seller.setBaseSalary(900.0);
		seller.setEmail("barcot@fodasse.com.uk");
		sellerDao.update(seller);
		System.out.println("Updated seller with id " + seller.getId());
		
		System.out.println("\n==== Teste 5: Seller delete ====");
		//System.out.println("Entre com um Id para deletar: ");
		//int id = sc.nextInt();
		//sellerDao.deleteById(id);
		sellerDao.deleteById(newSeller.getId()); //deletando usuario criado no metodo insert
		System.out.println("Deleted seller with id " + newSeller.getId());
		
		
		sc.close();
	}
}