package example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTest {

    @Test
    public void ShouldReturnTrueWhenAllSidesAreZero() throws Exception {
        Triangle triangle = new Triangle(0, 0, 0);

        Assertions.assertTrue(triangle.allSidesAreZero(), true);
    }
}
