package entities;

import entities.Circulo;
import entities.Quadrado;
import entities.Retangulo;
import exceptions.FiguraComAtributoIgualAZeroException;
import exceptions.FiguraComAtributoNegativoException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RetanguloTest {

    private Retangulo retangulo;

    @BeforeEach
    void setUp() {
        retangulo = new Retangulo(5, 6);
    }

    @Test
    public void shouldThrowFiguraComAtributoIgualAZeroExceptionWhenBaseIsZero() {
        Assertions.assertThrows(FiguraComAtributoIgualAZeroException.class, () -> {
            retangulo.setBase(0);
        });
    }

    @Test
    public void shoutThrowFiguraComAtributoNegativoExceptionWhenBaseIsNegative() {
        Assertions.assertThrows(FiguraComAtributoNegativoException.class, () -> {
            retangulo.setBase(-1);
        });
    }

    @Test
    public void shouldThrowFiguraComAtributoIgualAZeroExceptionWhenAlturaIsZero() {
        Assertions.assertThrows(FiguraComAtributoIgualAZeroException.class, () -> {
            retangulo.setAltura(0);
        });
    }

    @Test
    public void shoutThrowFiguraComAtributoNegativoExceptionWhenAlturaIsNegative() {
        Assertions.assertThrows(FiguraComAtributoNegativoException.class, () -> {
            retangulo.setAltura(-1);
        });
    }

    @Test
    public void shouldGetArea() {
        Assertions.assertEquals(retangulo.getBase() * retangulo.getAltura(), retangulo.getArea());
    }

    @Test
    public void shouldGetPerimetro() {
        Assertions.assertEquals((retangulo.getBase() + retangulo.getAltura()) * 2, retangulo.getPerimetro());
    }


}
