package applications;

import java.io.File;
import java.util.Scanner;

public class Program06 {
    public static void main(String[] args) {
        
        //pegando informações do path do arquivo
        Scanner sc = new Scanner(System.in);
        
        try {
            System.out.print("Enter a file path: ");
            String strPath = sc.nextLine();
            
            File path = new File(strPath);
            System.out.println("Name Path: " + path.getName());
            System.out.println("Parent Path: " + path.getParent());
            System.out.println("Path: " + path.getPath());
            System.out.println("Absolute Path: " + path.getAbsolutePath());
            System.out.println("Total Space: " + path.getTotalSpace());
        
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        sc.close();
    }
}
