package entities;

import exceptions.FiguraComAtributoIgualAZeroException;
import exceptions.FiguraComAtributoNegativoException;

public class Quadrado {
    private double lado;

    public Quadrado(double lado) {
        this.lado = lado;
    }

    public Quadrado() {
    }

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        if (lado < 0) {
            throw new FiguraComAtributoNegativoException("Lado negativo não existe.");
        }
        else if (lado == 0) {
            throw new FiguraComAtributoIgualAZeroException("Lado igual a zero não existe.");
        }
        this.lado = lado;
    }

    public double getArea() {
        return Math.pow(lado, 2);
    }

    public double getPerimetro() {
        return lado * 4;
    }

    @Override
    public String toString() {
        return "O quadrado criado tem lados de tamanho: " + lado;
    }
}
