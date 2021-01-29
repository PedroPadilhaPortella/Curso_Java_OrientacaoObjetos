import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of employees: ");
        int n = sc.nextInt();

        List<Employee> lista = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.print("Employee #" + i +  " data:\nOutsourced (y/n) ? ");
            char outsourced = sc.next().charAt(0);

            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();

            System.out.print("Hours: ");
            int hours = sc.nextInt();

            System.out.print("Value Per Hour: ");
            Double valuePerHour = sc.nextDouble();

            Employee empregado;

            if(outsourced == 'y') {
                System.out.print("Additional Charge: ");
                double additional = sc.nextDouble();
                empregado = new OutsourcedEmployee(name, hours, valuePerHour, additional);
            } else {
                empregado = new Employee(name, hours, valuePerHour);
            }

            lista.add(empregado);
        }
        
        System.out.println("\n\nPAYMENTS: ");
        for (Employee employee : lista) {
            System.out.println(employee.getName() + " - R$ " + String.format("%.2f", employee.payment()));
        }
        
        sc.close();
    }
}
