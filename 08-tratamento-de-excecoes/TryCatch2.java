import java.util.InputMismatchException;
import java.util.Scanner;

public class TryCatch2 {
    public static void main(String[] args)
    {
        Metodo1();
        System.out.println("end of program");
    }
    
    public static void Metodo1() {
        System.out.println("**metodo 1 started**");
        Metodo2();
        System.out.println("**metodo 1 ended**");
    }

    public static void Metodo2() {
        System.out.println("**metodo 2 started**");
        Scanner sc = new Scanner(System.in);
        
        try {
            String[] vect = sc.nextLine().split(" ");
            int position = sc.nextInt();
            System.out.println(vect[position]);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid Position");
            e.printStackTrace();
            sc.nextLine();
        }
        catch(InputMismatchException e) {
            System.out.println("Input Error");
        }
        
        sc.close();
        System.out.println("**metodo 2 ended**");
    }
}