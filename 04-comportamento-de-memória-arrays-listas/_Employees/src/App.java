import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class App {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        
        List<Employee> empregados = new ArrayList<Employee>();

        // PART 1 - READING DATA:

        System.out.print("How many employees will be registered? ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
			System.out.println("\nEmployee #" + i + ": ");

			System.out.print("Id: ");
            int id = sc.nextInt();
            while (hasId(empregados, id)) {
                System.out.print("Id already taken. Try again: ");
				id = sc.nextInt();
            }

            System.out.print("Name: ");
			sc.nextLine();
            String name = sc.nextLine();
            
			System.out.print("Salary: ");
            double salary = sc.nextDouble();
            
            Employee empregado = new Employee(id, name, salary);
            empregados.add(empregado);
        }

        // PART 2 - UPDATING SALARY OF GIVEN EMPLOYEE:

        System.out.print("Enter the employee id that will have salary increase: ");
        int id = sc.nextInt();
        Employee empregado = empregados.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        if (empregado == null) {
			System.out.println("This id does not exist!");
		} else {
            System.out.print("Enter the percentage: ");
			empregado.IncreaseSalary(sc.nextDouble());
        }

        // PART 3 - LISTING EMPLOYEES:

        System.out.println("\n------------------\nList of employees:");
        for (Employee employee : empregados) {
            System.out.println(employee);
        }

        sc.close();
    }

    public static boolean hasId(List<Employee> lista, int id) {
        Employee empregado = lista.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        return empregado != null;
    }
}