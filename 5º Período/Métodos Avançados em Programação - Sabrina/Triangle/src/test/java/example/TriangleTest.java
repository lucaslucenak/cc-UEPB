package example;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTest {

    @Test
    public void shouldReturnEQUILATERALWhenAllSidesAreEqual() throws Exception {
        Triangle triangle = new Triangle(5, 5, 5);

        Assertions.assertEquals(TriangleKind.EQUILATERAL, triangle.getKind());
    }

    @Test
    public void shouldReturnISOSCELESWhensSide1AndSide2AreEqual() throws TriangleException {
        Triangle triangle = new Triangle(10, 10, 12);

        Assertions.assertEquals(TriangleKind.ISOSCELES, triangle.getKind());
    }

    @Test
    public void shouldReturnISOSCELESWhensSide1AndSide3AreEqual() throws Exception {
        Triangle triangle = new Triangle(10, 12, 10);

        Assertions.assertEquals(TriangleKind.ISOSCELES, triangle.getKind());
    }

    @Test
    public void shouldReturnISOSCELESWhensSide2AndSide3AreEqual() throws Exception {
        Triangle triangle = new Triangle(12, 10, 10);

        Assertions.assertEquals(TriangleKind.ISOSCELES, triangle.getKind());
    }

    @Test
    public void shouldReturnSCALENEWhenTwoSidesAreEqual() throws Exception {
        Triangle triangle = new Triangle(10, 11, 12);

        Assertions.assertEquals(TriangleKind.SCALENE, triangle.getKind());
    }

    @Test
    public void shouldThrowExceptionWhenAllSidesAreZero() {
        Assertions.assertThrows(TriangleException.class, () -> {
            Triangle triangle = new Triangle(0, 0, 0);
        });
    }

    @Test
    public void shouldThrowExceptionWhenSide1IsZero() {
        Assertions.assertThrows(TriangleException.class, () -> {
            Triangle triangle = new Triangle(0, 5, 5);
        });
    }

    @Test
    public void shouldThrowExceptionWhenSide2IsZero() {
        Assertions.assertThrows(TriangleException.class, () -> {
            Triangle triangle = new Triangle(5, 0, 5);
        });
    }

    @Test
    public void shouldThrowExceptionWhenSide3IsZero() {
        Assertions.assertThrows(TriangleException.class, () -> {
            Triangle triangle = new Triangle(5, 5, 0);
        });
    }

    //ESSE FOI A MAIS
    @Test
    public void shouldThrowExceptionWhenSide1And3AreZero() {
        Assertions.assertThrows(TriangleException.class, () -> {
            Triangle triangle = new Triangle(0, 5, 0);
        });
    }

    //ESSE FOI A MAIS
    @Test
    public void shouldThrowExceptionWhenSide1And2AreZero() {
        Assertions.assertThrows(TriangleException.class, () -> {
            Triangle triangle = new Triangle(0, 0, 5);
        });
    }

    //ESSE FOI A MAIS
    @Test
    public void shouldThrowExceptionWhenSide3And2AreZero() {
        Assertions.assertThrows(TriangleException.class, () -> {
            Triangle triangle = new Triangle(5, 0, 0);
        });
    }

    //ESSE FOI A MAIS
    @Test
    public void shouldThrowExceptionWhenAllSidesAreNegative() {
        Assertions.assertThrows(TriangleException.class, () -> {
            Triangle triangle = new Triangle(-5, -5, -5);
        });
    }

    @Test
    public void shouldThrowExceptionWhenSide1IsNegative() {
        Assertions.assertThrows(TriangleException.class, () -> {
            Triangle triangle = new Triangle(-5, 0, 0);
        });
    }

    @Test
    public void shouldThrowExceptionWhenSide2IsNegative() {
        Assertions.assertThrows(TriangleException.class, () -> {
            Triangle triangle = new Triangle(0, -5, 0);
        });
    }

    @Test
    public void shouldThrowExceptionWhenSide3IsNegative() {
        Assertions.assertThrows(TriangleException.class, () -> {
            Triangle triangle = new Triangle(0, 0, -5);
        });
    }

    //ESSE FOI A MAIS
    @Test
    public void shouldThrowExceptionWhenSide1And2AreNegative() {
        Assertions.assertThrows(TriangleException.class, () -> {
            Triangle triangle = new Triangle(-5, -5, 0);
        });
    }

    //ESSE FOI A MAIS
    @Test
    public void shouldThrowExceptionWhenSide1And3AreNegative() {
        Assertions.assertThrows(TriangleException.class, () -> {
            Triangle triangle = new Triangle(-5, 0, -5);
        });
    }

    //ESSE FOI A MAIS
    @Test
    public void shouldThrowExceptionWhenSide3And2AreNegative() {
        Assertions.assertThrows(TriangleException.class, () -> {
            Triangle triangle = new Triangle(0, -5, -5);
        });
    }

    @Test
    public void shouldThrowExceptionWhenSide1PlusSide2IsMinorToSide3() {
        Assertions.assertThrows(TriangleException.class, () -> {
            Triangle triangle = new Triangle(3, 2, 6);
        });
    }

    @Test
    public void shouldThrowExceptionWhenSide1PlusSide2IsEqualToSide3() {
        Assertions.assertThrows(TriangleException.class, () -> {
            Triangle triangle = new Triangle(3, 2, 5);
        });
    }

    @Test
    public void shouldThrowExceptionWhenSide1PlusSide3IsMinorToSide2() {
        Assertions.assertThrows(TriangleException.class, () -> {
            Triangle triangle = new Triangle(3, 6, 2);
        });
    }

    @Test
    public void shouldThrowExceptionWhenSide1PlusSide3IsEqualToSide2() {
        Assertions.assertThrows(TriangleException.class, () -> {
            Triangle triangle = new Triangle(3, 5, 2);
        });
    }

    @Test
    public void shouldThrowExceptionWhenSide2PlusSide3IsMinorToSide1() {
        Assertions.assertThrows(TriangleException.class, () -> {
            Triangle triangle = new Triangle(6, 3, 2);
        });
    }

    @Test
    public void shouldThrowExceptionWhenSide2PlusSide3IsEqualToSide1() {
        Assertions.assertThrows(TriangleException.class, () -> {
            Triangle triangle = new Triangle(5, 3, 2);
        });
    }
}
