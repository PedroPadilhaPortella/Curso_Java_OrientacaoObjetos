import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import entities.User;

public class LogDeAcesso {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter file full path: ");
        String fullpath = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(fullpath))) {

            Set<User> users = new HashSet<>();
            String line = br.readLine();

            while(line != null) {
                String[] fields = line.split(" ");
                String username = fields[0];

                Date date = Date.from(Instant.parse(fields[1]));
                users.add(new User(username, date));

                line = br.readLine();
            }

            System.out.println("Total User: " + users.size());
            System.out.println(users);
        }
        catch(IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        sc.close();
    }
}
