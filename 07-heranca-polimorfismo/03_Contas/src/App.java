import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        // Account acc1 = new Account(1001, "Alex", 1000.0);
        Account acc2 = new BussinessAccount(1001, "Maria", 1000.0, 500.0);
        Account acc3 = new SavingsAccount(1001, "Pedro", 1000.0, 0.01);

        List<Account> list = new ArrayList<>();

        list.add(acc2);
        list.add(acc3);

        double sum = 0.0;
        for (Account account : list) {
            sum += account.getBalance();
            System.out.println(account + "\n");
        }

        System.out.printf("Total balance: %.2f%n", sum);

        for (Account account : list) {
            account.Deposit(10.0);
        }

        for (Account account : list) {
            System.out.printf("Updated balance for account %d: %.2f%n",
            account.getNumber(), account.getBalance());
        }
    }
}
