import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        Estudante[] vetor = new Estudante[10];

        System.out.print("How many rooms will be rented? ");
        int quartos = sc.nextInt();
        
        for (int i = 0; i < quartos; i++) {
            System.out.print("\nRent #" + (i + 1) + "\nName: ");
            sc.nextLine();
            String name = sc.nextLine();

            System.out.print("Email: ");
            String email = sc.nextLine();

            System.out.print("Room: ");
            int room = sc.nextInt();

            Estudante student = new Estudante(name, email);
            vetor[room] = student;
        }

        System.out.println("Busy Rooms:");
        for (int i = 0; i < vetor.length; i++) {
            if(vetor[i] != null) {
                System.out.print("Room " + i + ": ");
                System.out.println(vetor[i]);
            }
        }

        sc.close();
    }
}
