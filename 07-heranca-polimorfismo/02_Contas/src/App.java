import entities.Account;
import entities.BussinessAccount;
import entities.SavingsAccount;

public class App {
    public static void main(String[] args) throws Exception {
    
        //Override
        Account acc1 = new Account(1004, "Ana", 500.0);
        acc1.WithDraw(100);

        SavingsAccount acc2 = new SavingsAccount(1004, "Ana", 500.0, 0.01);
        acc2.WithDraw(100);

        BussinessAccount acc3 = new BussinessAccount(1004, "Ana", 500.0, 200.0);
        acc3.WithDraw(100);


        //Polimorfismo

        Account x = new Account(0001, "Pedro", 1000.0);
        Account y = new BussinessAccount(0001, "Pedro", 1000.0, 500.0);
        Account z = new SavingsAccount(0001, "Pedro", 1000.0, 0.1);

        x.WithDraw(50.0);
        y.WithDraw(50.0);
        z.WithDraw(50.0);

        System.out.println(x.getBalance());
        System.out.println(y.getBalance());
        System.out.println(z.getBalance());
    }
}
