package devices;

public class ComboDevice extends Device implements IPrinter, IScanner{
    
    public ComboDevice(String serialNumber) {
        super(serialNumber);
    }

    @Override
    public void ProcessDoc(String doc) {
        System.out.println("Combo Device processing...");
    }

    @Override
    public String Scan() {
        return "Combo Scanning...";
    }
    
    @Override
    public void Print(String doc) {
        System.out.println("Combo Printing: " + doc);
    }
}