package entities;

import entities.enums.*;

public abstract class Shape 
{
    private Color Color;

    public Shape () {}

    public Shape (Color color) {
        this.Color = color;
    }

    public Color getColor() {
        return this.Color;
    }

    public void setColor(Color Color) {
        this.Color = Color;
    }

    public abstract double Area();
}