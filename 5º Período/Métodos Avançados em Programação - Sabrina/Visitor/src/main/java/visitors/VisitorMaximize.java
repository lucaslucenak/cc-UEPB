package visitors;

import entities.*;
import interfaces.VisitorIF;

public class VisitorMaximize implements VisitorIF {

    @Override
    public Double visitRectangle(Rectangle rectangle) {
        rectangle.setHeight(rectangle.getHeight() * 2);
        rectangle.setWidth(rectangle.getWidth() * 2);

        DisplayImage displayImage = new DisplayImage("src/main/java/assets/img/rectangleMaximized.png");
        displayImage.show();

        System.out.println("Novos valores do retângulo maximizado: " + rectangle);
        return 0.0;
    }

    @Override
    public Double visitTriangle(Triangle triangle) {
        triangle.setBase(triangle.getBase() * 2);
        triangle.setHeight(triangle.getHeight() * 2);

        DisplayImage displayImage = new DisplayImage("src/main/java/assets/img/triangleMaximized.png");
        displayImage.show();

        System.out.println("Novos valores do triângulo maximizado: " + triangle);
        return 0.0;
    }

    @Override
    public Double visitCircle(Circle circle) {
        circle.setRadius(circle.getRadius() * 2);

        DisplayImage displayImage = new DisplayImage("src/main/java/assets/img/circleMaximized.jpg");
        displayImage.show();

        System.out.println("Novos valores do circulo maximizado: " + circle);
        return 0.0;
    }

    @Override
    public Double visitTrapezium(Trapezium trapezium) {
        trapezium.setBiggestBase(trapezium.getBiggestBase() * 2);
        trapezium.setSmallestBase(trapezium.getSmallestBase() * 2);
        trapezium.setSide1(trapezium.getSide1() * 2);
        trapezium.setSide2(trapezium.getSide2() * 2);
        trapezium.setHeight(trapezium.getHeight() * 2);

        DisplayImage displayImage = new DisplayImage("src/main/java/assets/img/trapeziumMaximized.jpg");
        displayImage.show();

        System.out.println("Novos valores do trapézio maximizado: " + trapezium);
        return 0.0;
    }


}
