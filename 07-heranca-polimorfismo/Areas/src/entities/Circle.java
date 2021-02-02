package entities;

import entities.enums.*;

public class Circle extends Shape
{
    private double Radius;

    public Circle() { super(); }


    public Circle(double Radius, Color color) {
        super(color);
        this.Radius = Radius;
    }


    public double getRadius() {
        return this.Radius;
    }

    public void setRadius(double Radius) {
        this.Radius = Radius;
    }


    @Override
    public double Area() {
        return Math.PI * Math.pow(Radius, 2);
    }
    
}
