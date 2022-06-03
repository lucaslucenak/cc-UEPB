package entities;

import exceptions.FiguraComAtributoIgualAZeroException;
import exceptions.FiguraComAtributoNegativoException;

public class Retangulo {
    private double base;
    private double altura;

    public Retangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public Retangulo() {
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        if (base < 0) {
            throw new FiguraComAtributoNegativoException("Base negativa não existe.");
        }
        else if (base == 0) {
            throw new FiguraComAtributoIgualAZeroException("Base igual a zero não existe.");
        }
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        if (altura < 0) {
            throw new FiguraComAtributoNegativoException("Altura negativa não existe.");
        }
        else if (altura == 0) {
            throw new FiguraComAtributoIgualAZeroException("Altura igual a zero não existe.");
        }
        this.altura = altura;
    }

    public double getArea() {
        return base * altura;
    }

    public double getPerimetro() {
        return  (base + altura) * 2;
    }

    @Override
    public String toString() {
        return "O retângulo criado tem altura de tamanho: " + altura + " e largura de tamanho: " + base;
    }
}
