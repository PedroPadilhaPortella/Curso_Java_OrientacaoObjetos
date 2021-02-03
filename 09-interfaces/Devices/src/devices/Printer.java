package devices;

public class Printer extends Device implements IPrinter {

    public Printer(String serialNumber) {
        super(serialNumber);
    }

    @Override
    public void ProcessDoc(String doc) {
        System.out.println("Printer processing: " + doc);
    }

    public void Print(String doc) {
        System.out.println("Printing: " + doc);
    }
}
