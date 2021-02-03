package model.entities;

public class Vehicle 
{
    private String Model;

    public Vehicle() {}

    public Vehicle(String model) {
        this.Model = model;
    }

    public String getModel() {
        return this.Model;
    }

    public void setModel(String Model) {
        this.Model = Model;
    }

}
