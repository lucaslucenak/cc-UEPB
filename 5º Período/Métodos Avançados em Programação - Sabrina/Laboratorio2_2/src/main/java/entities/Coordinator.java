package entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Coordinator extends People {
    public Coordinator(String name, Integer age, String email, String phoneNumber) {
        super(name, age, email, phoneNumber);
    }

    public Coordinator() {
    }


}
