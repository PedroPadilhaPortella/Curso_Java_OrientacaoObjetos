import entities.Account;
import entities.BussinessAccount;
import entities.SavingsAccount;

public class App {
    public static void main(String[] args) throws Exception {
    
        Account acc = new Account(1001, "Alex", 0.0);
        BussinessAccount bacc = new BussinessAccount(1002, "Marcio", 50.0, 500.0);

        //Upcasting
        Account acc1 = bacc;
        Account acc2 = new BussinessAccount(1003, "Bob", 0.0, 1300.0);
        Account acc3 = new SavingsAccount(1004, "Ana", 0.0, 0.01);

        //Downcasting
        BussinessAccount acc4 = (BussinessAccount) acc2;
        SavingsAccount acc5 = (SavingsAccount) acc3;

        
        if(acc3 instanceof BussinessAccount){
            BussinessAccount acc6 = (BussinessAccount) acc3;
            acc6.Loan(100.0);
            System.out.println("Emprestimo");
        }
        
        if(acc3 instanceof SavingsAccount) {
            SavingsAccount acc6 = (SavingsAccount) acc3;
            acc6.UpdateBalance();
            System.out.println("Update");
        }

        //Override
        Account acc7 = new Account(1004, "Ana", 500.0);
        acc7.WithDraw(100);

        SavingsAccount acc8 = new SavingsAccount(1004, "Ana", 500.0, 0.01);
        acc8.WithDraw(100);

        BussinessAccount acc9 = new BussinessAccount(1004, "Ana", 500.0, 200.0);
        acc9.WithDraw(100);


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
