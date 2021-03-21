import entities.*;
import entities.enums.Color;

public class App {
    public static void main(String[] args) throws Exception {
        AbstractShape s1 = new Circle(Color.Black, 2.0);
        AbstractShape s2 = new Rectangle(Color.White, 3.0, 4.0);

        System.out.println("Circle color: " + s1.getColor());
        System.out.println("Rectangle color: " + s2.getColor());
        System.out.println("Circle area: " + String.format("%.3f", s1.Area()));
        System.out.println("Rectangle area: " + String.format("%.3f", s2.Area()));
    }
}