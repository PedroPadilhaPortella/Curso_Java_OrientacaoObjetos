package applications;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Program01 {

    public static void main(String[] args) {
        
        //class File e Scanner
        Scanner sc = null;
        File file = new File("files/read.txt");
        
        try {
            sc = new Scanner(file);

            while(sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
        }
        catch(IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        finally {
            if(sc != null)  sc.close();
        }
    }
}