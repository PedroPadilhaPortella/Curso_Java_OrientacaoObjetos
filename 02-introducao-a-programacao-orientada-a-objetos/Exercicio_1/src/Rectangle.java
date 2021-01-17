package Exercicio_1.src;

public class Rectangle {
	public double width;
	public double height;
	
	public double getArea() {
		return width * height;
	}
	
	public double getPerimeter() {
		return 2 * width + 2 * height;
	}

	public double getDiagonal() {
		double hipotenuse = Math.pow(width, 2) + Math.pow(height, 2);
		return Math.sqrt(hipotenuse);
	}
}
