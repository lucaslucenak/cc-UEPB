package visitors;

import entities.Circle;
import entities.Rectangle;
import entities.Trapezium;
import entities.Triangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VisitorMaximizeTest {

    Triangle triangle;
    Rectangle rectangle;
    Circle circle;
    Trapezium trapezium;
    VisitorMaximize visitorMaximize;


    @BeforeEach
    void setUp() {
        triangle = new Triangle(6.0,6.0,6.0, 6.0, (6 * Math.cbrt(3)) / 2);
        rectangle = new Rectangle(6.0, 5.0);
        circle = new Circle(6.0);
        trapezium = new Trapezium(6.0, 14.0, 5.0, 5.0, (6.0 + 14.0) / 2);
        visitorMaximize = new VisitorMaximize();
    }

    @Test
    public void shouldMaximizeTriangle() {
        visitorMaximize.visitTriangle(triangle);
        Assertions.assertEquals(12.0, triangle.getSide1());
        Assertions.assertEquals(12.0, triangle.getSide2());
        Assertions.assertEquals(12.0, triangle.getSide3());
        Assertions.assertEquals(12.0, triangle.getBase());
        Assertions.assertEquals(((6 * Math.cbrt(3)) / 2) * 2, triangle.getHeight());
        Assertions.assertEquals(0.0, visitorMaximize.visitTriangle(triangle));
    }

    @Test
    public void shouldMaximizeRectangle() {
        visitorMaximize.visitRectangle(rectangle);
        Assertions.assertEquals(12.0, rectangle.getHeight());
        Assertions.assertEquals(10.0, rectangle.getWidth());
        Assertions.assertEquals(0.0, visitorMaximize.visitRectangle(rectangle));
    }

    @Test
    public void shouldMaximizeCircle() {
        visitorMaximize.visitCircle(circle);
        Assertions.assertEquals(12.0, circle.getRadius());
        Assertions.assertEquals(0.0, visitorMaximize.visitCircle(circle));
    }

    @Test
    public void shouldMaximizeTrapezium() {
        visitorMaximize.visitTrapezium(trapezium);
        Assertions.assertEquals(12.0, trapezium.getSmallestBase());
        Assertions.assertEquals(28.0, trapezium.getBiggestBase());
        Assertions.assertEquals(10.0, trapezium.getSide1());
        Assertions.assertEquals(10.0, trapezium.getSide2());
        Assertions.assertEquals(10.0, trapezium.getSide1());
        Assertions.assertEquals(((6.0 + 14.0) / 2) * 2, trapezium.getHeight());
    }
}
