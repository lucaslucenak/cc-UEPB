package entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bill {
    private String name;
    private Double value;

    public Bill(String name, Double value) {
        this.name = name;
        this.value = value;
    }
}
