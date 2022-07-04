package entities;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Retangle {

    private static Retangle uniqueInstance = null;
    private Double side1 = 0.0;
    private Double side2 = 0.0;
    private Double side3 = 0.0;
    private Double side4 = 0.0;

    private Retangle(Double side1, Double side2, Double side3, Double side4) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.side4 = side4;
    }

    private Retangle() {
    }

    public static Retangle getInstance() {
        if (uniqueInstance == null){
            System.out.println("Criando instancia unica do Retangulo");
            uniqueInstance = new Retangle();
        }

        System.out.println("Retornando instancia unica do Retangulo");
        return uniqueInstance;
    }
}
