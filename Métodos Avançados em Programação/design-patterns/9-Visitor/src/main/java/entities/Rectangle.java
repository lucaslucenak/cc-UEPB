package entities;

import interfaces.ConcreteElementIF;
import interfaces.VisitorIF;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Rectangle implements ConcreteElementIF {

    private Double height;
    private Double width;

    public Rectangle(Double height, Double width) {
        this.height = height;
        this.width = width;
    }

    public Rectangle() {
    }

    @Override
    public void acceptVisit(VisitorIF visitorIF) {
        Double result = visitorIF.visitRectangle(this);

        if (result != 0.0) {
            System.out.println(result);
        }
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "height=" + height +
                ", width=" + width +
                '}';
    }
}
