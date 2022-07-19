package entities;

import interfaces.ConcreteElementIF;
import interfaces.VisitorIF;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Circle implements ConcreteElementIF {

    private Double radius;

    public Circle(Double radius) {
        this.radius = radius;
    }

    public Circle() {
    }

    @Override
    public void acceptVisit(VisitorIF visitorIF) {
        Double result = visitorIF.visitCircle(this);

        if (result != 0.0) {
            System.out.println(result);
        }
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }
}
