import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import entities.Employee;

public class App {
    public static void main(String[] args) {

        List<Employee> empregados = new ArrayList<>();

        // String path = "src\\files\\names.txt";
        String path = "src\\files\\employees.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String employeeCSV = br.readLine();

            while (employeeCSV != null) {
                String[] fields = employeeCSV.split(",");
                empregados.add(new Employee(fields[0], Double.parseDouble(fields[1])));
                employeeCSV = br.readLine();
            }

            Collections.sort(empregados);

            for (Employee e : empregados) {
                System.out.println(e.getName() + ", " + e.getSalary());
            }

        }
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}