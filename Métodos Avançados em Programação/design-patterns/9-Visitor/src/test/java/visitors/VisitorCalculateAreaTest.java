package visitors;

import entities.Circle;
import entities.Rectangle;
import entities.Trapezium;
import entities.Triangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VisitorCalculateAreaTest {
    Triangle triangle;
    Rectangle rectangle;
    Circle circle;
    Trapezium trapezium;
    VisitorCalculateArea visitorCalculateArea;


    @BeforeEach
    void setUp() {
        triangle = new Triangle(6.0,6.0,6.0, 6.0, (6 * Math.cbrt(3)) / 2);
        rectangle = new Rectangle(6.0, 5.0);
        circle = new Circle(6.0);
        trapezium = new Trapezium(6.0, 14.0, 5.0, 5.0, (6.0 + 14.0) / 2);
        visitorCalculateArea = new VisitorCalculateArea();
    }

    @Test
    public void shouldCalculateTriangleArea() {
        Assertions.assertEquals(Math.round((Math.pow(triangle.getSide1(), 2) * Math.cbrt(3)) / 4),
                Math.round(visitorCalculateArea.visitTriangle(triangle)));
    }

    @Test
    public void shouldCalculateRectangleArea() {
        Assertions.assertEquals(Math.round(rectangle.getHeight() * rectangle.getWidth()),
                Math.round(visitorCalculateArea.visitRectangle(rectangle)));
    }

    @Test
    public void shouldCalculateCircleArea() {
        Assertions.assertEquals(Math.round(Math.PI * Math.pow(circle.getRadius(), 2)),
                Math.round(visitorCalculateArea.visitCircle(circle)));
    }

    @Test
    public void shouldCalculateTrapeziumArea() {
        Assertions.assertEquals(Math.round(trapezium.getBiggestBase() + trapezium.getSmallestBase()) * trapezium.getHeight() / 2,
                Math.round(visitorCalculateArea.visitTrapezium(trapezium)));
    }

}
