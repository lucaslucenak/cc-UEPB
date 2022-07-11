package entities;

import exceptions.FiguraComAtributoIgualAZeroException;
import exceptions.FiguraComAtributoNegativoException;

public class Circulo {
    private double raio;

    public Circulo(double raio) {
        this.raio = raio;
    }

    public Circulo() {
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        if (raio < 0) {
            throw new FiguraComAtributoNegativoException("Raio negativo não existe.");
        }
        else if (raio == 0) {
            throw new FiguraComAtributoIgualAZeroException("Raio igual a zero não existe.");
        }
        this.raio = raio;
    }

    public double getArea() {
        return Math.pow(raio, 2) * Math.PI;
    }

    public double getPerimetro() {
        return 2 * Math.PI * raio;
    }

    @Override
    public String toString() {
        return "O circulo criado tem raio de tamanho: " + raio;
    }
}
