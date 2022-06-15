package entities;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class People {
    private String nome;
    private String CPF;
    private Address address;

    public People(String nome, String CPF, Address address) {
        this.nome = nome;
        this.CPF = CPF;
        this.address = address;
    }

    public People() {

    }
}
