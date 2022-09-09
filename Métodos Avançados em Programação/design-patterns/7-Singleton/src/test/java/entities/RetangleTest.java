package entities;

import exceptions.FigureCongruenceOrParallelismBreakException;
import exceptions.FigureWithAttributeEqualsZeroException;
import exceptions.FigureWithNegativeAttributeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RetangleTest {

    Retangle retangle;

    @BeforeEach
    void setUp() {
        retangle = Retangle.getInstance();
    }

    @Test
    public void shouldSetSide1() {
        retangle.setSide1(10.0);
        Assertions.assertEquals(10.0, retangle.getSide1());
    }

    @Test
    public void shouldSetSide2() {
        retangle.setSide2(5.0);
        Assertions.assertEquals(5.0, retangle.getSide2());
    }

    @Test
    public void shouldSetSide3() {
        retangle.setSide3(10.0);
        Assertions.assertEquals(10.0, retangle.getSide3());
    }

    @Test
    public void shouldSetSide4() {
        retangle.setSide4(5.0);
        Assertions.assertEquals(5.0, retangle.getSide4());
    }

    @Test
    public void shouldThrowFigureWithAttributeEqualsZeroExceptionWhenSide1IsZero() {
        Assertions.assertThrows(FigureWithAttributeEqualsZeroException.class, () -> {
            retangle.setSide1(0.0);
        });
    }

    @Test
    public void shouldThrowFigureWithAttributeEqualsZeroExceptionWhenSide2IsZero() {
        Assertions.assertThrows(FigureWithAttributeEqualsZeroException.class, () -> {
            retangle.setSide2(0.0);
        });
    }

    @Test
    public void shouldThrowFigureWithAttributeEqualsZeroExceptionWhenSide3IsZero() {
        Assertions.assertThrows(FigureWithAttributeEqualsZeroException.class, () -> {
            retangle.setSide3(0.0);
        });
    }

    @Test
    public void shouldThrowFigureWithAttributeEqualsZeroExceptionWhenSide4IsZero() {
        Assertions.assertThrows(FigureWithAttributeEqualsZeroException.class, () -> {
            retangle.setSide4(0.0);
        });
    }

    @Test
    public void shouldThrowFigureWithNegativeAttributeExceptionWhenSide1IsNegative() {
        Assertions.assertThrows(FigureWithNegativeAttributeException.class, () -> {
            retangle.setSide1(-10.0);
        });
    }

    @Test
    public void shouldThrowFigureWithNegativeAttributeExceptionWhenSide2IsNegative() {
        Assertions.assertThrows(FigureWithNegativeAttributeException.class, () -> {
            retangle.setSide2(-10.0);
        });
    }

    @Test
    public void shouldThrowFigureWithNegativeAttributeExceptionWhenSide3IsNegative() {
        Assertions.assertThrows(FigureWithNegativeAttributeException.class, () -> {
            retangle.setSide3(-10.0);
        });
    }

    @Test
    public void shouldThrowFigureWithNegativeAttributeExceptionWhenSide4IsNegative() {
        Assertions.assertThrows(FigureWithNegativeAttributeException.class, () -> {
            retangle.setSide4(-10.0);
        });
    }

    @Test
    public void shouldThrowFigureCongruenceOrParallelismBreakException() {
        Assertions.assertThrows(FigureCongruenceOrParallelismBreakException.class, () -> {
            retangle.setSide1(10.0);
            retangle.setSide3(5.0);
        });
    }

}
