package visitors;

import entities.*;
import interfaces.VisitorIF;

public class VisitorDrawFigure implements VisitorIF {

    @Override
    public Double visitRectangle(Rectangle rectangle) {
        System.out.println("Desenhando retangulo: " + rectangle.toString());
        DisplayImage displayImage = new DisplayImage("src/main/java/assets/img/retangle.png");
        displayImage.show();
        return 0.0;
    }

    @Override
    public Double visitTriangle(Triangle triangle) {
        System.out.println("Desenhando triangulo: " + triangle.toString());
        DisplayImage displayImage = new DisplayImage("src/main/java/assets/img/triangle.png");
        displayImage.show();
        return 0.0;
    }

    @Override
    public Double visitCircle(Circle circle) {
        System.out.println("Desenhando circulo: " + circle.toString());
        DisplayImage displayImage = new DisplayImage("src/main/java/assets/img/circle.jpg");
        displayImage.show();
        return 0.0;
    }

    @Override
    public Double visitTrapezium(Trapezium trapezium) {
        System.out.println("Desenhando trapezio: " + trapezium.toString());
        DisplayImage displayImage = new DisplayImage("src/main/java/assets/img/trapezium.jpg");
        displayImage.show();
        return 0.0;
    }
}
