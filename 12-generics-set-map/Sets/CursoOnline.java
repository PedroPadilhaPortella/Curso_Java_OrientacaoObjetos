import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CursoOnline {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        Set<Integer> cursoA = new HashSet<>();
        Set<Integer> cursoB = new HashSet<>();
        Set<Integer> cursoC = new HashSet<>();
        
        System.out.print("How many students for course A ? ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++)
            cursoA.add(sc.nextInt());
            
        System.out.print("How many students for course B ? ");
        n = sc.nextInt();
        for (int i = 0; i < n; i++)
            cursoB.add(sc.nextInt());

        System.out.print("How many students for course C ? ");
        n = sc.nextInt();
        for (int i = 0; i < n; i++)
            cursoC.add(sc.nextInt());

        Set<Integer> total = new HashSet<>();
        total.addAll(cursoA);
        total.addAll(cursoB);
        total.addAll(cursoC);

        System.out.println("Total students: " + total.size());

        sc.close();
    }
}
