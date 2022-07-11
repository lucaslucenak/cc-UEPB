import entities.FigurasGeometricas;

public class BrincandoComAsFigurasGeometricas {
    public static void main(String[] args) {
        FigurasGeometricas figurasGeometricas = new FigurasGeometricas();
        figurasGeometricas.getRetangulo().setAltura(10);
        figurasGeometricas.getRetangulo().setBase(5);
        figurasGeometricas.getCirculo().setRaio(25);
        figurasGeometricas.getQuadrado().setLado(7);

        System.out.println("Perímetro do retângulo: " + figurasGeometricas.getRetangulo().getPerimetro());
        System.out.printf("Perímetro do círculo: %.2f %n", figurasGeometricas.getCirculo().getPerimetro());
        System.out.println("Perímeto do quadrado: " + figurasGeometricas.getQuadrado().getPerimetro());

        System.out.println("Área do quadrado: " + figurasGeometricas.getQuadrado().getArea());
        System.out.println("Área do retângulo: " + figurasGeometricas.getRetangulo().getArea());
        System.out.println(figurasGeometricas.getAreasTodasFiguras());
        System.out.printf("Área do círculo: %.2f %n", figurasGeometricas.getCirculo().getArea());

        System.out.println(figurasGeometricas.getCirculo().toString());
        System.out.println(figurasGeometricas.getQuadrado().toString());
        System.out.println(figurasGeometricas.getAtributosTodasFiguras());

    }
}
