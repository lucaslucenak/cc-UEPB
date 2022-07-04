package entities;
import exceptions.FigureWithAttributeEqualsZeroException;
import exceptions.FigureWithNegativeAttributeException;
import lombok.Getter;

@Getter
public class Circle {

    private static Circle uniqueInstance = null;
    private Double radius;

    private Circle() {
    }

    public static Circle getInstance() {
        if (uniqueInstance == null) {
            System.out.println("Criando instancia unica do Circulo");
            uniqueInstance = new Circle();
        }
        System.out.println("Retornando instancia unica do Retangulo");
        return uniqueInstance;
    }

    public void setRadius(Double radius) {
        if (radius < 0) {
            throw new FigureWithNegativeAttributeException("Raio negativo nao existe");
        }
        else if (radius == 0) {
            throw new FigureWithAttributeEqualsZeroException("Raio igual a zero nao existe");
        }
        this.radius = radius;
    }
}
