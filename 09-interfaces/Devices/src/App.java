import devices.*;

public class App {
    public static void main(String[] args) throws Exception {

        //Como resolver o problema do Diamante

        Printer p = new Printer("74832");
        String document = "My Letter";
        p.ProcessDoc(document);
        p.Print(document);

        Scanner s = new Scanner("53222");
        document = "My email";
        s.ProcessDoc(document);
        System.out.println("Scan Result: " + s.Scan());

        ComboDevice c = new ComboDevice("4242");
        document = "My dissertation";
        c.ProcessDoc(document);
        c.Print(document);
        System.out.println("Combo device scan Result:" + c.Scan());
    }
}
