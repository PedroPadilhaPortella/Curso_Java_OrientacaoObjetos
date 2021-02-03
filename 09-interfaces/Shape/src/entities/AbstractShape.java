package entities;

import entities.enums.Color;

public abstract class AbstractShape implements Shape
{
    private Color Color;
    
    public AbstractShape(Color color) {
        this.Color = color;
    }

    public Color getColor() {
        return this.Color;
    }

    public void setColor(Color Color) {
        this.Color = Color;
    }
}
