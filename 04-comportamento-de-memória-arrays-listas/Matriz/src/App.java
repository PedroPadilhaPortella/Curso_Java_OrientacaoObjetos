import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int ordem = sc.nextInt();

        int[][] matriz = new int[ordem][ordem];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = sc.nextInt();
            }
        }

        System.out.println("Main diagonal:");
        for (int i = 0; i < matriz.length; i++) {
            System.out.println(matriz[i][i] + " ");
        }


        int negatives = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if(matriz[i][j] < 0) {
                    negatives++;
                }
            }
        }
        System.out.println("Negative numbers = " + negatives);

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("[  " + matriz[i][j] + " ]  ");
            }
            System.out.println();
        }

        sc.close();
   }
}
