package example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTest {

    @Test
    public void ShouldThrowExceptionWhenAllSidesAreZero() {
        TriangleException exception = Assertions.assertThrows(TriangleException.class, () -> {
            Triangle triangle = new Triangle(0, 0, 0);
        });

        Assertions.assertNull(exception.getMessage());
    }

    @Test
    public void ShouldThrowExceptionWhenSide1IsZero() {
        TriangleException exception = Assertions.assertThrows(TriangleException.class, () -> {
            Triangle triangle = new Triangle(0, 5, 5);
        });

        Assertions.assertNull(exception.getMessage());
    }

    @Test
    public void ShouldThrowExceptionWhenSide2IsZero() {
        TriangleException exception = Assertions.assertThrows(TriangleException.class, () -> {
            Triangle triangle = new Triangle(5, 0, 5);
        });

        Assertions.assertNull(exception.getMessage());
    }

    @Test
    public void ShouldThrowExceptionWhenSide3IsZero() {
        TriangleException exception = Assertions.assertThrows(TriangleException.class, () -> {
            Triangle triangle = new Triangle(5, 5, 0);
        });

        Assertions.assertNull(exception.getMessage());
    }

    @Test
    public void ShouldThrowExceptionWhenSide1And3AreZero() {
        TriangleException exception = Assertions.assertThrows(TriangleException.class, () -> {
            Triangle triangle = new Triangle(0, 5, 0);
        });

        Assertions.assertNull(exception.getMessage());
    }

    @Test
    public void ShouldThrowExceptionWhenSide1And2AreZero() {
        TriangleException exception = Assertions.assertThrows(TriangleException.class, () -> {
            Triangle triangle = new Triangle(0, 0, 5);
        });

        Assertions.assertNull(exception.getMessage());
    }

    @Test
    public void ShouldThrowExceptionWhenSide3And2AreZero() {
        TriangleException exception = Assertions.assertThrows(TriangleException.class, () -> {
            Triangle triangle = new Triangle(5, 0, 0);
        });

        Assertions.assertNull(exception.getMessage());
    }

    @Test
    public void ShouldReturnEQUILATERALWhenAllSidesAreEqual() throws Exception {
        Triangle triangle = new Triangle(5, 5, 5);

        Assertions.assertEquals(TriangleKind.EQUILATERAL, triangle.getKind());
    }

    @Test
    public void ShouldReturnISOSCELESWhenTwoSidesAreEqual() throws Exception {
        Triangle triangle = new Triangle(10, 10, 12);

        Assertions.assertEquals(TriangleKind.ISOSCELES, triangle.getKind());
    }

    @Test
    public void ShouldReturnSCALENEWhenTwoSidesAreEqual() throws Exception {
        Triangle triangle = new Triangle(10, 11, 12);

        Assertions.assertEquals(TriangleKind.SCALENE, triangle.getKind());
    }
}
