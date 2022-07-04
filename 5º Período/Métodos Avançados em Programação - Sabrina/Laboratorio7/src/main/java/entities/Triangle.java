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

        if (side2 != null && side3 != null && !(Math.abs(side2 - side3) < this.side1) && this.side1 < side2 + side3) {
            throw new FigureCongruenceOrParallelismBreakException("Congruencia do triangulo violada.");
        }
        if (side2 != null && side3 != null && !(Math.abs(this.side1 - side3) < side2) && side2 < this.side1 + side3) {
            throw new FigureCongruenceOrParallelismBreakException("Congruencia do triangulo violada.");
        }
        if (side2 != null && side3 != null && !(Math.abs(this.side1 - side2) < this.side1) && side3 < this.side1 + side2) {
            throw new FigureCongruenceOrParallelismBreakException("Congruencia do triangulo violada.");
        }
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

        if (side1 != null && side3 != null && !(Math.abs(this.side2 - side3) < side1) && side1 < this.side2 + side3) {
            throw new FigureCongruenceOrParallelismBreakException("Congruencia do triangulo violada.");
        }
        if (side1 != null && side3 != null && !(Math.abs(side1 - side3) < this.side2) && this.side2 < side1 + side3) {
            throw new FigureCongruenceOrParallelismBreakException("Congruencia do triangulo violada.");
        }
        if (side1 != null && side3 != null && !(Math.abs(side1 - this.side2) < side1) && side3 < side1 + this.side2) {
            throw new FigureCongruenceOrParallelismBreakException("Congruencia do triangulo violada.");
        }
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

        if (side1 != null && side2 != null && !(Math.abs(side2 - this.side3) < side1) && side1 < side2 + this.side3) {
            throw new FigureCongruenceOrParallelismBreakException("Congruencia do triangulo violada.");
        }
        if (side1 != null && side2 != null && !(Math.abs(side1 - this.side3) < side2) && side2 < side1 + this.side3) {
            throw new FigureCongruenceOrParallelismBreakException("Congruencia do triangulo violada.");
        }
        if (side1 != null && side2 != null && !(Math.abs(side1 - side2) < side1) && this.side3 < side1 + side2) {
            throw new FigureCongruenceOrParallelismBreakException("Congruencia do triangulo violada.");
        }
    }
}
