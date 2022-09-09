package visitors;

import entities.Circle;
import entities.Rectangle;
import entities.Trapezium;
import entities.Triangle;
import interfaces.VisitorIF;

public class VisitorCalculateArea implements VisitorIF {

    @Override
    public Double visitRectangle(Rectangle rectangle) {
        return rectangle.getHeight() * rectangle.getWidth();
    }

    @Override
    public Double visitTriangle(Triangle triangle) {
        return (triangle.getBase() * triangle.getHeight()) / 2;
    }

    @Override
    public Double visitCircle(Circle circle) {
        return Math.PI * Math.pow(circle.getRadius(), 2);
    }

    @Override
    public Double visitTrapezium(Trapezium trapezium) {
        return ((trapezium.getBiggestBase() + trapezium.getSmallestBase()) * trapezium.getHeight()) / 2;
    }
}
