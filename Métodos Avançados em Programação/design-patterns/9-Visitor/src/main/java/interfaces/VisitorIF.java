package interfaces;

import entities.Circle;
import entities.Rectangle;
import entities.Trapezium;
import entities.Triangle;

public interface VisitorIF {
    Double visitRectangle(Rectangle rectangle);
    Double visitTriangle(Triangle triangle);
    Double visitCircle(Circle circle);
    Double visitTrapezium(Trapezium trapezium);
}
