package entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Address {
    private String street;
    private String number;
    private String neighbourhood;
    private String city;
    private String state;
    private String country;

}
