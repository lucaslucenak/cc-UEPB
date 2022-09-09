package entities;

import lombok.*;

@Getter
@Setter
public class Address {
    private String street;
    private String number;
    private String neighbourhood;
    private String city;
    private String state;
    private String country;

    public Address(String street, String number, String neighbourhood, String city, String state, String country) {
        this.street = street;
        this.number = number;
        this.neighbourhood = neighbourhood;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public Address() {
    }
}
