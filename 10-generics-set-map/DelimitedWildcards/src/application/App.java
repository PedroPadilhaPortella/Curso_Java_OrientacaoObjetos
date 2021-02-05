package application;

import java.util.ArrayList;
import java.util.List;

import entities.*;

public class App {

	public static void main(String[] args) {
		
		List<Shape> myShapes = new ArrayList<>();
		myShapes.add(new Rectangle(3.0, 2.0));
		myShapes.add(new Circle(2.0));
		
		List<Circle> myCircles = new ArrayList<>();
		myCircles.add(new Circle(4.0));
		myCircles.add(new Circle(3.0));

		List<Rectangle> myRectangles = new ArrayList<>();
		myRectangles.add(new Rectangle(4.0, 7.0));
		myRectangles.add(new Rectangle(2.0, 5.0));
		
		System.out.println("Total area: " + totalArea(myShapes));
		System.out.println("Total area: " + totalArea(myCircles));
		System.out.println("Total area: " + totalArea(myRectangles));
	}
	
    // O parametro recebido pode ser de um tipo Shape ou de algum subtipo de Shape, como Circle ou Rectangle
	public static double totalArea(List<? extends Shape> list)
    {
        //Como a lista é indefinida, não podemos adicionar elementos dentro da função, 
        //pois não se sabe se o tipo é o mesmo do que foi passado na função
        // list.add(new Rectangle(3.0, 4.0));

        double sum = 0.0;
		for (Shape s : list) {
            sum += s.area();
		}
		return sum;
	}
}