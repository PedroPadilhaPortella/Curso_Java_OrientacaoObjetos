package applications;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Program04 {
    
    public static void main(String[] args) {
        
        //class FileWriter and BufferedWriter
        String[] lines = new String[] { "Bom dia", "Buenos Dias", "Good Morning", "Доброе утро (Dobroye utro)", 
        "おはようございます (Ohayōgozaimasu)", "صباح الخير  (sabah al khair)", "Guten Morgen" };
        
        String path = "files/write.txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) 
        {    
            System.out.println("Writing data...");
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
            bw.newLine();
            System.out.println("Data wrote...");
        }
        catch(IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
