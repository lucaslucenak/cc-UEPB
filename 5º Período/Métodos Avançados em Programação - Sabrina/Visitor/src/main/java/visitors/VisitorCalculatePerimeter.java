package visitors;

import entities.Circle;
import entities.Rectangle;
import entities.Trapezium;
import entities.Triangle;
import interfaces.VisitorIF;

public class VisitorCalculatePerimeter implements VisitorIF {

    @Override
    public Double visitRectangle(Rectangle rectangle) {
        return (rectangle.getHeight() + rectangle.getWidth()) * 2;
    }

    @Override
    public Double visitTriangle(Triangle triangle) {
        return  triangle.getBase() + (2 * triangle.getHeight());
    }

    @Override
    public Double visitCircle(Circle circle) {
        return 2 * Math.PI * circle.getRadius();
    }

    @Override
    public Double visitTrapezium(Trapezium trapezium) {
        return trapezium.getSmallestBase() + trapezium.getBiggestBase() + trapezium.getSide1() + trapezium.getSide2();
    }
}
