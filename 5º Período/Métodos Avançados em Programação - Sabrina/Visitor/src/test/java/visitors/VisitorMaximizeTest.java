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
        Assertions.assertEquals(0.0, visitorMaximize.visitTriangle(triangle));
    }

    @Test
    public void shouldMaximizeRectangle() {
        Assertions.assertEquals(0.0, visitorMaximize.visitRectangle(rectangle));
    }

    @Test
    public void shouldMaximizeCircle() {
        Assertions.assertEquals(0.0, visitorMaximize.visitCircle(circle));
    }

    @Test
    public void shouldMaximizeTrapezium() {
        Assertions.assertEquals(0.0, visitorMaximize.visitTrapezium(trapezium));
    }
}
