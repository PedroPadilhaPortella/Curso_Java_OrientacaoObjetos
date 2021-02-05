package entities;

import entities.enums.*;

public class Rectangle extends AbstractShape
{
    private double Width;
    private double Heigth;

    public Rectangle(Color color, double width, double heigth) {
        super(color);
        this.Width = width;
        this.Heigth = heigth;
    }

    public double getWidth() {
        return this.Width;
    }

    public void setWidth(double Width) {
        this.Width = Width;
    }

    public double getHeigth() {
        return this.Heigth;
    }

    public void setHeigth(double Heigth) {
        this.Heigth = Heigth;
    }

    @Override
    public double Area() {
        return Width * Heigth;
    }
}