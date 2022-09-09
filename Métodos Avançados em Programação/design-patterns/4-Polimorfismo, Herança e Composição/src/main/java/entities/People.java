package entities;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class People {
    private String name;
    private String CPF;
    private Address address;

    public People(String name, String CPF, Address address) {
        this.name = name;
        this.CPF = CPF;
        this.address = address;
    }

    public People() {

    }
}
