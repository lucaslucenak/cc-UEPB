import entities.Circle;
import entities.Rectangle;
import entities.Trapezium;
import entities.Triangle;
import interfaces.VisitorIF;
import visitors.VisitorCalculateArea;
import visitors.VisitorCalculatePerimeter;
import visitors.VisitorDrawFigure;
import visitors.VisitorMaximize;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        VisitorIF area = new VisitorCalculateArea();
        VisitorIF perimeter = new VisitorCalculatePerimeter();
        VisitorIF draw = new VisitorDrawFigure();
        VisitorIF maximize = new VisitorMaximize();

        Rectangle rectangle = new Rectangle(2.0, 4.0);
        Trapezium trapezium = new Trapezium(5.0, 10.0, 4.0, 4.0,10.0);
        Circle circle = new Circle(10.0);
        Triangle triangle = new Triangle(5.0, 5.0, 5.0, 5.0, 5.0);

        System.out.println("Area das figuras:");
        System.out.print("Retangulo: ");
        triangle.acceptVisit(area);
        System.out.print("Trapezio: ");
        trapezium.acceptVisit(area);
        System.out.print("Circulo: ");
        circle.acceptVisit(area);
        System.out.print("Triangulo: ");
        triangle.acceptVisit(area);

        sc.nextLine();

        System.out.println("Perimetro das figuras:");
        System.out.print("Retangulo: ");
        triangle.acceptVisit(perimeter);
        System.out.print("Trapezio: ");
        trapezium.acceptVisit(perimeter);
        System.out.print("Circulo: ");
        circle.acceptVisit(perimeter);
        System.out.print("Triangulo: ");
        triangle.acceptVisit(perimeter);

        sc.nextLine();

        System.out.println("Desenho das figuras:");
        rectangle.acceptVisit(draw);
        trapezium.acceptVisit(draw);
        circle.acceptVisit(draw);
        triangle.acceptVisit(draw);

        sc.nextLine();

        System.out.println("Maximização das figuras:");
        rectangle.acceptVisit(maximize);
        trapezium.acceptVisit(maximize);
        circle.acceptVisit(maximize);
        triangle.acceptVisit(maximize);

    }
}
