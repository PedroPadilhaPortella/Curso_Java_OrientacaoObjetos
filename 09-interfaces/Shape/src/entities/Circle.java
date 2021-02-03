package entities;

import entities.enums.*;

public class Circle extends AbstractShape
{
    private double Radius;

    public Circle(Color color, double Radius) {
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