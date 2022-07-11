package entities;
import exceptions.FigureCongruenceOrParallelismBreakException;
import exceptions.FigureWithAttributeEqualsZeroException;
import exceptions.FigureWithNegativeAttributeException;
import lombok.Getter;

@Getter
public class Retangle {

    private static Retangle uniqueInstance = null;
    private Double side1;
    private Double side2;
    private Double side3;
    private Double side4;

    private Retangle() {
    }

    public static Retangle getInstance() {
            System.out.println("Criando instancia unica do Retangulo");
            uniqueInstance = new Retangle();

        System.out.println("Retornando instancia unica do Retangulo");
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

        if (side3 != null && !side1.equals(side3)) {
            throw new FigureCongruenceOrParallelismBreakException("Lados 1 e 3 não são iguais");
        }
        if (side2 != null && side4 != null && !side2.equals(side4)) {
            throw new FigureCongruenceOrParallelismBreakException("Lados 2 e 4 não são iguais");
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

        if (side1 != null && side3 != null && !side1.equals(side3)) {
            throw new FigureCongruenceOrParallelismBreakException("Lados 1 e 3 não são iguais");
        }
        if (side4 != null && !side2.equals(side4)) {
            throw new FigureCongruenceOrParallelismBreakException("Lados 2 e 4 não são iguais");
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

        if (side1 != null && !side1.equals(side3)) {
            throw new FigureCongruenceOrParallelismBreakException("Lados 1 e 3 não são iguais");
        }
        if (side2 != null && side4 != null && !side2.equals(side4)) {
            throw new FigureCongruenceOrParallelismBreakException("Lados 2 e 4 não são iguais");
        }
    }

    public void setSide4(Double side4) {
        this.side4 = null;
        if (side4 < 0) {
            throw new FigureWithNegativeAttributeException("Lado negativo nao existe.");
        }
        else if (side4 == 0) {
            throw new FigureWithAttributeEqualsZeroException("Lado igual a 0 nao existe.");
        }
        this.side4 = side4;

        if (side1 != null && side3 != null && !side1.equals(side3)) {
            throw new FigureCongruenceOrParallelismBreakException("Lados 1 e 3 não são iguais");
        }
        if (side2 != null && !side2.equals(side4)) {
            throw new FigureCongruenceOrParallelismBreakException("Lados 2 e 4 não são iguais");
        }
    }
}
