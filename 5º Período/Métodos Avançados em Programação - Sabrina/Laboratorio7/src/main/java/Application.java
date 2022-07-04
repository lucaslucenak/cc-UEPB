import entities.Circle;
import entities.Retangle;
import entities.Triangle;

public class Application {
    public static void main(String[] args) {

        Circle circle = Circle.getInstance();
        Circle circle2 = Circle.getInstance();
        circle.setRadius(10.5);
        System.out.println(circle.getRadius());

        System.out.printf("%n------------------------------------------------%n%n");

        Triangle trianguloIsosceles = Triangle.getInstance();
        trianguloIsosceles.setSide1(10);
        trianguloIsosceles.setSide2(10);
        trianguloIsosceles.setSide3(5);
        Triangle tianguloEquilatero = Triangle.getInstance();
        tianguloEquilatero.setSide1(10);
        tianguloEquilatero.setSide2(10);
        tianguloEquilatero.setSide3(10);
        Triangle trianguloRetangulo = Triangle.getInstance();
        trianguloRetangulo.setSide1(13);
        trianguloRetangulo.setSide2(12);
        trianguloRetangulo.setSide3(5);
        Triangle triangulo = Triangle.getInstance();

        System.out.printf("%n------------------------------------------------%n%n");

        Retangle retangulo1 = Retangle.getInstance();
        retangulo1.setSide1(10.0);
        retangulo1.setSide2(5.0);
        retangulo1.setSide3(10.0);
        retangulo1.setSide4(5.0);
    }
}
