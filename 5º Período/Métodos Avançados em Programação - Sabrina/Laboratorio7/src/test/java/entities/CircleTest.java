package entities;


import exceptions.FigureWithAttributeEqualsZeroException;
import exceptions.FigureWithNegativeAttributeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

public class CircleTest {
    Circle circle;

    @BeforeEach
    void setUp() {
        circle = Circle.getInstance();
    }

    @Test
    public void shouldSetCircleRadius() {
        circle.setRadius(10.0);
        Assertions.assertEquals(10.0, circle.getRadius());
    }

    @Test
    public void shouldThrowFigureWithAttributeEqualsZeroException() {
        Assertions.assertThrows(FigureWithAttributeEqualsZeroException.class, () -> {
            circle.setRadius(0.0);
        });
    }

    @Test
    public void shouldThrowFigureWithNegativeAttributeException() {
        Assertions.assertThrows(FigureWithNegativeAttributeException.class, () -> {
            circle.setRadius(-10.0);
        });
    }
}
