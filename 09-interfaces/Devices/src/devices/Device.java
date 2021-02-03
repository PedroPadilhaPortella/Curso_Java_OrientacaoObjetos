package devices;

public abstract class Device 
{
    public String SerialNumber;

    public Device(String serialNumber) {
        this.SerialNumber = serialNumber;
    }

    public String getSerialNumber() {
        return this.SerialNumber;
    }

    public void setSerialNumber(String SerialNumber) {
        this.SerialNumber = SerialNumber;
    }

    public abstract void ProcessDoc(String doc);
}