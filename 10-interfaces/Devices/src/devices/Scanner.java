package devices;

public class Scanner extends Device implements IScanner {
    
    public Scanner(String serialNumber) {
        super(serialNumber);
    }

    @Override
    public void ProcessDoc(String doc) {
        System.out.println("Scanner processing: " + doc);
    }

    public String Scan() {
        return "Scanning content...";
    }
}
