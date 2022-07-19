package visitors;

import entities.Circle;
import entities.Rectangle;
import entities.Trapezium;
import entities.Triangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VisitorCalculatePerimeterTest {

    Triangle triangle;
    Rectangle rectangle;
    Circle circle;
    Trapezium trapezium;
    VisitorCalculatePerimeter visitorCalculatePerimeter;


    @BeforeEach
    void setUp() {
        triangle = new Triangle(6.0,6.0,6.0, 6.0, (6 * Math.cbrt(3)) / 2);
        rectangle = new Rectangle(6.0, 5.0);
        circle = new Circle(6.0);
        trapezium = new Trapezium(6.0, 14.0, 5.0, 5.0, (6.0 + 14.0) / 2);
        visitorCalculatePerimeter = new VisitorCalculatePerimeter();
    }

    @Test
    public void shouldCalculateTrianglePerimeter() {
        Assertions.assertEquals(triangle.getBase() + (2 * triangle.getHeight()),
                visitorCalculatePerimeter.visitTriangle(triangle));
    }

    @Test
    public void shouldCalculateRectanglePerimeter() {
        Assertions.assertEquals((rectangle.getHeight() + rectangle.getWidth()) * 2,
                visitorCalculatePerimeter.visitRectangle(rectangle));
    }

    @Test
    public void shouldCalculateCirclePerimeter() {
        Assertions.assertEquals(2 * Math.PI * circle.getRadius(),
                visitorCalculatePerimeter.visitCircle(circle));
    }

    @Test
    public void shouldCalculateTrapeziumPerimeter() {
        Assertions.assertEquals(trapezium.getSmallestBase() + trapezium.getBiggestBase() + trapezium.getSide1() + trapezium.getSide2(),
                visitorCalculatePerimeter.visitTrapezium(trapezium));
    }
}
