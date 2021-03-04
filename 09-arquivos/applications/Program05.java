package applications;

import java.io.File;
import java.util.Scanner;

public class Program05 {
    public static void main(String[] args) {
        
        //manipulando pastas e arquivos com a classe File
        Scanner sc = new Scanner(System.in);

        try {
            String strPath = sc.nextLine();
            File path = new File(strPath);
            
            File[] folders = path.listFiles(File::isDirectory);
            System.out.println("Folders:");
            
            for (File folder : folders) {
                System.out.println(folder);
            }
            
            File[] files = path.listFiles(File::isFile);
            System.out.println("\nFiles:");

            for (File file : files) {
                System.out.println(file);
            }

            boolean success = new File(strPath + "/teste").mkdir();
            System.out.println("Diretory created successfully: " + success);

        }
        catch(Exception e) {
            e.printStackTrace();
        }
        sc.close();
    }
}
