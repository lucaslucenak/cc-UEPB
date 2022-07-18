package visitors;

import entities.Circle;
import entities.Rectangle;
import entities.Trapezium;
import entities.Triangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VisitorDrawFigureTest {

    Triangle triangle;
    Rectangle rectangle;
    Circle circle;
    Trapezium trapezium;
    VisitorDrawFigure visitorDrawFigure;


    @BeforeEach
    void setUp() {
        triangle = new Triangle(6.0,6.0,6.0, 6.0, (6 * Math.cbrt(3)) / 2);
        rectangle = new Rectangle(6.0, 5.0);
        circle = new Circle(6.0);
        trapezium = new Trapezium(6.0, 14.0, 5.0, 5.0, (6.0 + 14.0) / 2);
        visitorDrawFigure = new VisitorDrawFigure();
    }

    @Test
    public void shouldDrawTriangle() {
        Assertions.assertEquals(0.0, visitorDrawFigure.visitTriangle(triangle));
    }

    @Test
    public void shouldDrawRectangle() {
        Assertions.assertEquals(0.0, visitorDrawFigure.visitRectangle(rectangle));
    }

    @Test
    public void shouldDrawCircle() {
        Assertions.assertEquals(0.0, visitorDrawFigure.visitCircle(circle));
    }

    @Test
    public void shouldDrawTrapezium() {
        Assertions.assertEquals(0.0, visitorDrawFigure.visitTrapezium(trapezium));
    }
}
