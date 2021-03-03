package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DAOFactory;
import model.dao.DepartmentDAO;
import model.entities.Department;

public class InterfaceDepartment {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		DepartmentDAO departmentDao = DAOFactory.createDepartmentDAO();		
		
		System.out.println("==== Teste 1: Department findById ====");
		Department department = departmentDao.findById(3);
		System.out.println(department);
		
		System.out.println("\n==== Teste 3: Department findAll ====");
		List<Department> departments = departmentDao.findAll();
		for (Department obj : departments) {
			System.out.println(obj);			
		}
		
		System.out.println("\n==== Teste 4: Department insert ====");
		Department newDepartment = new Department(null, "Music");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted seller with id " + newDepartment.getId());
		
		System.out.println("\n==== Teste 5: Department update ====");
		department = departmentDao.findById(3);
		department.setName("Gestão");
		departmentDao.update(department);
		System.out.println("Updated seller with id " + department.getId());
		
		System.out.println("\n==== Teste 5: Department delete ====");
		System.out.println("Entre com um Id para deletar: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		//departmentDao.deleteById(newDepartment.getId()); //deletando usuario criado no metodo insert
		System.out.println("Deleted seller with id " + newDepartment.getId());
		
		
		sc.close();
	}
}