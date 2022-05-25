package com.map.labdois.entities;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class People {

    private String name;
    private Integer age;
    private String email;
    private String phoneNumber;

    public People(String name, Integer age, String email, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public People() {
    }
}
