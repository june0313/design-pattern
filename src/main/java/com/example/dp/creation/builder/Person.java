package com.example.dp.creation.builder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Person {
    private String name;
    private String position;
}

class PersonBuilder<SELF extends PersonBuilder<SELF>> {
    protected Person person = new Person();

    public SELF withName(String name) {
        person.setName(name);
        return self();
    }

    public Person build() {
        return person;
    }

    protected SELF self() {
        return (SELF) this;
    }
}

class EmployeeBuilder extends PersonBuilder<EmployeeBuilder> {
    public EmployeeBuilder worksAt(String position) {
        person.setPosition(position);
        return self();
    }

    @Override
    protected EmployeeBuilder self() {
        return this;
    }
}
