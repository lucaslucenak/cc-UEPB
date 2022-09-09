import entities.Circle;
import entities.Retangle;
import entities.Triangle;

public class Application {
    public static void main(String[] args) {

        Circle circle = Circle.getInstance();
        circle.setRadius(10.5);
        Circle circle2 = Circle.getInstance();

        System.out.printf("%n------------------------------------------------%n%n");

        Triangle trianguloIsosceles = Triangle.getInstance();
        trianguloIsosceles.setSide1(10.0);
        trianguloIsosceles.setSide2(10.0);
        trianguloIsosceles.setSide3(5.0);
        Triangle tianguloEquilatero = Triangle.getInstance();
        tianguloEquilatero.setSide1(10.0);
        tianguloEquilatero.setSide2(10.0);
        tianguloEquilatero.setSide3(10.0);
        Triangle trianguloRetangulo = Triangle.getInstance();
        trianguloRetangulo.setSide1(13.0);
        trianguloRetangulo.setSide2(12.0);
        trianguloRetangulo.setSide3(5.0);
        Triangle triangulo = Triangle.getInstance();
//        System.out.println(triangulo.getSide1());

        System.out.printf("%n------------------------------------------------%n%n");

        Retangle retangulo1 = Retangle.getInstance();
        retangulo1.setSide1(10.0);
        retangulo1.setSide2(5.0);
        retangulo1.setSide3(10.0);
        retangulo1.setSide4(5.0);

        Retangle retangulo2 = Retangle.getInstance();
        retangulo2.setSide1(5.0);
        retangulo2.setSide2(5.0);
        retangulo2.setSide3(5.0);
        retangulo2.setSide4(5.0);

    }
}
