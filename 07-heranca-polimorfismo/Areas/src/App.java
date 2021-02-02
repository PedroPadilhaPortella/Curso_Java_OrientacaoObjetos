import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.*;
import entities.enums.*;

public class App {
    public static void main(String[] args) throws Exception {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Shape> shapes = new ArrayList<>();

        System.out.print("Enter the number of shapes: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Shape #" + i + " data: ");
            System.out.print("Rectangle or Cirle (r/c)? ");
            char ch = sc.next().charAt(0);

            System.out.print("Color (Black/Blue/Red)? ");
            Color color = Color.valueOf(sc.next());

            if(ch == 'r') {
                System.out.print("Width: ");
                double width = sc.nextDouble();

                System.out.print("Height: ");
                double height = sc.nextDouble();
                
                shapes.add(new Rectangle(width, height, color));
            } else {
                System.out.print("Radius: ");
                double radius = sc.nextDouble();
                
                shapes.add(new Circle(radius, color));
            }
        }

        System.out.println("\nSHAPE AREAS: ");
        for (Shape shape : shapes) {
            System.out.println(String.format("%.2f", shape.Area()));
        }

        sc.close();
    }
}
