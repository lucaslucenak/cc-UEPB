package entities;

import exceptions.FigureWithAttributeEqualsZeroException;
import exceptions.FigureWithNegativeAttributeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TriangleTest {

    Triangle triangle;

    @BeforeEach
    void setUp() {
        triangle = Triangle.getInstance();
    }

    @Test
    public void shouldSetSide1() {
        triangle.setSide1(10.0);
        Assertions.assertEquals(10.0, triangle.getSide1());
    }

    @Test
    public void shouldSetSide2() {
        triangle.setSide2(5.0);
        Assertions.assertEquals(5.0, triangle.getSide2());
    }

    @Test
    public void shouldSetSide3() {
        triangle.setSide3(10.0);
        Assertions.assertEquals(10.0, triangle.getSide3());
    }

    @Test
    public void shouldThrowFigureWithAttributeEqualsZeroExceptionWhenSide1IsZero() {
        Assertions.assertThrows(FigureWithAttributeEqualsZeroException.class, () -> {
            triangle.setSide1(0.0);
        });
    }

    @Test
    public void shouldThrowFigureWithAttributeEqualsZeroExceptionWhenSide2IsZero() {
        Assertions.assertThrows(FigureWithAttributeEqualsZeroException.class, () -> {
            triangle.setSide2(0.0);
        });
    }

    @Test
    public void shouldThrowFigureWithAttributeEqualsZeroExceptionWhenSide3IsZero() {
        Assertions.assertThrows(FigureWithAttributeEqualsZeroException.class, () -> {
            triangle.setSide3(0.0);
        });
    }

    @Test
    public void shouldThrowFigureWithNegativeAttributeExceptionWhenSide1IsNegative() {
        Assertions.assertThrows(FigureWithNegativeAttributeException.class, () -> {
            triangle.setSide1(-10.0);
        });
    }

    @Test
    public void shouldThrowFigureWithNegativeAttributeExceptionWhenSide2IsNegative() {
        Assertions.assertThrows(FigureWithNegativeAttributeException.class, () -> {
            triangle.setSide2(-10.0);
        });
    }

    @Test
    public void shouldThrowFigureWithNegativeAttributeExceptionWhenSide3IsNegative() {
        Assertions.assertThrows(FigureWithNegativeAttributeException.class, () -> {
            triangle.setSide3(-10.0);
        });
    }
}
