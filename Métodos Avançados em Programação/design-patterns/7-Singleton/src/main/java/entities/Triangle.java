package entities;

import exceptions.FigureCongruenceOrParallelismBreakException;
import exceptions.FigureWithAttributeEqualsZeroException;
import exceptions.FigureWithNegativeAttributeException;
import lombok.Getter;

@Getter
public class Triangle {
    public static Triangle uniqueInstance = null;
    private Double side1;
    private Double side2;
    private Double side3;
    private static int count = 0;

    private Triangle() {
    }

    public static Triangle getInstance() {
        if (uniqueInstance == null || count < 3) {
            System.out.println("Criando instancia unica do Retangulo");
            uniqueInstance = new Triangle();
            count++;
        }
        System.out.println("Retornando instancia unica do Triangulo");
        return uniqueInstance;
    }

    public void setSide1(Double side1) {
        this.side1 = null;
        if (side1 < 0) {
            throw new FigureWithNegativeAttributeException("Lado negativo nao existe.");
        }
        else if (side1 == 0) {
            throw new FigureWithAttributeEqualsZeroException("Lado igual a 0 nao existe.");
        }
        this.side1 = side1;
    }

    public void setSide2(Double side2) {
        this.side2 = null;
        if (side2 < 0) {
            throw new FigureWithNegativeAttributeException("Lado negativo nao existe.");
        }
        else if (side2 == 0) {
            throw new FigureWithAttributeEqualsZeroException("Lado igual a 0 nao existe.");
        }
        this.side2 = side2;
    }

    public void setSide3(Double side3) {
        this.side3 = null;
        if (side3 < 0) {
            throw new FigureWithNegativeAttributeException("Lado negativo nao existe.");
        }
        else if (side3 == 0) {
            throw new FigureWithAttributeEqualsZeroException("Lado igual a 0 nao existe.");
        }
        this.side3 = side3;
    }
}
