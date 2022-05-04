package example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTest {

    @Test
    public void ShouldReturnTrueWhenAllSidesAreZero() {
        TriangleException exception = Assertions.assertThrows(TriangleException.class, () -> {
            Triangle triangle = new Triangle(0, 0, 0);
        });

        Assertions.assertNull(exception.getMessage());
    }
}
