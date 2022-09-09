package entities;

import entities.Circulo;
import exceptions.FiguraComAtributoIgualAZeroException;
import exceptions.FiguraComAtributoNegativoException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CirculoTest {

    private Circulo circulo;

    @BeforeEach
    void setUp() {
        circulo = new Circulo(5);
    }

    @Test
    public void shouldThrowFiguraComAtributoIgualAZeroException() {
        Assertions.assertThrows(FiguraComAtributoIgualAZeroException.class, () -> {
            circulo.setRaio(0);
        });
    }

    @Test
    public void shoutThrowFiguraComAtributoNegativoException() {
        Assertions.assertThrows(FiguraComAtributoNegativoException.class, () -> {
            circulo.setRaio(-1);
        });
    }

    @Test
    public void shouldGetArea() {
        Assertions.assertEquals(Math.pow(circulo.getRaio(), 2) * Math.PI, circulo.getArea());
    }

    @Test
    public void shouldGetPerimetro() {
        Assertions.assertEquals(2 * Math.PI * circulo.getRaio(), circulo.getPerimetro());
    }

}
