package example;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTest {

    @Test
    public void ShouldReturnEQUILATERALWhenAllSidesAreEqual() throws Exception {
        Triangle triangle = new Triangle(5, 5, 5);

        Assertions.assertEquals(TriangleKind.EQUILATERAL, triangle.getKind());
    }

    @Test
    public void ShouldReturnISOSCELESWhensSide1AndSide2AreEqual() throws Exception {
        Triangle triangle = new Triangle(10, 10, 12);

        Assertions.assertEquals(TriangleKind.ISOSCELES, triangle.getKind());
    }

    @Test
    public void ShouldReturnISOSCELESWhensSide1AndSide3AreEqual() throws Exception {
        Triangle triangle = new Triangle(10, 12, 10);

        Assertions.assertEquals(TriangleKind.ISOSCELES, triangle.getKind());
    }

    @Test
    public void ShouldReturnISOSCELESWhensSide2AndSide3AreEqual() throws Exception {
        Triangle triangle = new Triangle(12, 10, 10);

        Assertions.assertEquals(TriangleKind.ISOSCELES, triangle.getKind());
    }

    @Test
    public void ShouldReturnSCALENEWhenTwoSidesAreEqual() throws Exception {
        Triangle triangle = new Triangle(10, 11, 12);

        Assertions.assertEquals(TriangleKind.SCALENE, triangle.getKind());
    }

    @Test
    public void ShouldThrowExceptionWhenAllSidesAreZero() {
        Assertions.assertThrows(TriangleException.class, () -> {
            Triangle triangle = new Triangle(0, 0, 0);
        });
    }

    @Test
    public void ShouldThrowExceptionWhenSide1IsZero() {
        Assertions.assertThrows(TriangleException.class, () -> {
            Triangle triangle = new Triangle(0, 5, 5);
        });
    }

    @Test
    public void ShouldThrowExceptionWhenSide2IsZero() {
        Assertions.assertThrows(TriangleException.class, () -> {
            Triangle triangle = new Triangle(5, 0, 5);
        });
    }

    @Test
    public void ShouldThrowExceptionWhenSide3IsZero() {
        Assertions.assertThrows(TriangleException.class, () -> {
            Triangle triangle = new Triangle(5, 5, 0);
        });
    }

    //ESSE FOI A MAIS
    @Test
    public void ShouldThrowExceptionWhenSide1And3AreZero() {
        Assertions.assertThrows(TriangleException.class, () -> {
            Triangle triangle = new Triangle(0, 5, 0);
        });
    }

    //ESSE FOI A MAIS
    @Test
    public void ShouldThrowExceptionWhenSide1And2AreZero() {
        Assertions.assertThrows(TriangleException.class, () -> {
            Triangle triangle = new Triangle(0, 0, 5);
        });
    }

    //ESSE FOI A MAIS
    @Test
    public void ShouldThrowExceptionWhenSide3And2AreZero() {
        Assertions.assertThrows(TriangleException.class, () -> {
            Triangle triangle = new Triangle(5, 0, 0);
        });
    }

    //ESSE FOI A MAIS
    @Test
    public void ShouldThrowExceptionWhenAllSidesAreNegative() {
        Assertions.assertThrows(TriangleException.class, () -> {
            Triangle triangle = new Triangle(-5, -5, -5);
        });
    }

    @Test
    public void ShouldThrowExceptionWhenSide1IsNegative() {
        Assertions.assertThrows(TriangleException.class, () -> {
            Triangle triangle = new Triangle(-5, 0, 0);
        });
    }

    @Test
    public void ShouldThrowExceptionWhenSide2IsNegative() {
        Assertions.assertThrows(TriangleException.class, () -> {
            Triangle triangle = new Triangle(0, -5, 0);
        });
    }

    @Test
    public void ShouldThrowExceptionWhenSide3IsNegative() {
        Assertions.assertThrows(TriangleException.class, () -> {
            Triangle triangle = new Triangle(0, 0, -5);
        });
    }

    //ESSE FOI A MAIS
    @Test
    public void ShouldThrowExceptionWhenSide1And2AreNegative() {
        Assertions.assertThrows(TriangleException.class, () -> {
            Triangle triangle = new Triangle(-5, -5, 0);
        });
    }

    //ESSE FOI A MAIS
    @Test
    public void ShouldThrowExceptionWhenSide1And3AreNegative() {
        Assertions.assertThrows(TriangleException.class, () -> {
            Triangle triangle = new Triangle(-5, 0, -5);
        });
    }

    //ESSE FOI A MAIS
    @Test
    public void ShouldThrowExceptionWhenSide3And2AreNegative() {
        Assertions.assertThrows(TriangleException.class, () -> {
            Triangle triangle = new Triangle(0, -5, -5);
        });
    }

    @Test
    public void ShouldThrowExceptionWhenSide1PlusSide2IsMinorToSide3() {
        Assertions.assertThrows(TriangleException.class, () -> {
            Triangle triangle = new Triangle(3, 2, 6);
        });
    }

    @Test
    public void ShouldThrowExceptionWhenSide1PlusSide2IsEqualToSide3() {
        Assertions.assertThrows(TriangleException.class, () -> {
            Triangle triangle = new Triangle(3, 2, 5);
        });
    }

    @Test
    public void ShouldThrowExceptionWhenSide1PlusSide3IsMinorToSide2() {
        Assertions.assertThrows(TriangleException.class, () -> {
            Triangle triangle = new Triangle(3, 6, 2);
        });
    }

    @Test
    public void ShouldThrowExceptionWhenSide1PlusSide3IsEqualToSide2() {
        Assertions.assertThrows(TriangleException.class, () -> {
            Triangle triangle = new Triangle(3, 5, 2);
        });
    }

    @Test
    public void ShouldThrowExceptionWhenSide2PlusSide3IsMinorToSide1() {
        Assertions.assertThrows(TriangleException.class, () -> {
            Triangle triangle = new Triangle(6, 3, 2);
        });
    }

    @Test
    public void ShouldThrowExceptionWhenSide2PlusSide3IsEqualToSide1() {
        Assertions.assertThrows(TriangleException.class, () -> {
            Triangle triangle = new Triangle(5, 3, 2);
        });
    }
}