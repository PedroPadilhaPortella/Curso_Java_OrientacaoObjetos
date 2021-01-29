import entities.Account;
import entities.BussinessAccount;
import entities.SavingsAccount;

public class App {
    public static void main(String[] args) throws Exception {
        
        //Upcasting
        BussinessAccount bacc = new BussinessAccount(1002, "Marcio", 50.0, 500.0);
        Account acc1 = bacc;
        acc1.getBalance();

        //Downcasting
        Account acc2 = new BussinessAccount(1003, "Bob", 100.0, 1300.0);
        Account acc3 = new SavingsAccount(1004, "Ana", 100.0, 0.01);

        BussinessAccount acc4 = (BussinessAccount) acc2;
        SavingsAccount acc5 = (SavingsAccount) acc3;

        acc4.Loan(10);
        acc5.UpdateBalance();

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
    }
}
