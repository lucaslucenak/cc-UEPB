package example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTest {

    @Test
    public void ShouldReturnNullWhenAllSidesAreZero() {
        TriangleException exception = Assertions.assertThrows(TriangleException.class, () -> {
            Triangle triangle = new Triangle(0, 0, 0);
        });

        Assertions.assertNull(exception.getMessage());
    }

    @Test
    public void ShouldReturnNullWhenSide1IsZero() {
        TriangleException exception = Assertions.assertThrows(TriangleException.class, () -> {
            Triangle triangle = new Triangle(0, 5, 5);
        });

        Assertions.assertNull(exception.getMessage());
    }

    @Test
    public void ShouldReturnNullWhenSide2IsZero() {
        TriangleException exception = Assertions.assertThrows(TriangleException.class, () -> {
            Triangle triangle = new Triangle(5, 0, 5);
        });

        Assertions.assertNull(exception.getMessage());
    }

    @Test
    public void ShouldReturnNullWhenSide3IsZero() {
        TriangleException exception = Assertions.assertThrows(TriangleException.class, () -> {
            Triangle triangle = new Triangle(5, 5, 0);
        });

        Assertions.assertNull(exception.getMessage());
    }

    @Test
    public void ShouldReturnNullWhenSide1And3AreZero() {
        TriangleException exception = Assertions.assertThrows(TriangleException.class, () -> {
            Triangle triangle = new Triangle(0, 5, 0);
        });

        Assertions.assertNull(exception.getMessage());
    }

    @Test
    public void ShouldReturnNullWhenSide1And2AreZero() {
        TriangleException exception = Assertions.assertThrows(TriangleException.class, () -> {
            Triangle triangle = new Triangle(0, 0, 5);
        });

        Assertions.assertNull(exception.getMessage());
    }

    @Test
    public void ShouldReturnNullWhenSide3And2AreZero() {
        TriangleException exception = Assertions.assertThrows(TriangleException.class, () -> {
            Triangle triangle = new Triangle(5, 0, 0);
        });

        Assertions.assertNull(exception.getMessage());
    }
}
