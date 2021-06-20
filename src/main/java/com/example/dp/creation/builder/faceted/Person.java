package com.example.dp.creation.builder.faceted;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Person {
    private String streetAddress;
    private String postcode;
    private String city;
    private String companyName;
    private String position;
    private int annualIncome;
}

class PersonBuilder {
    protected Person person = new Person();

    public PersonAddressBuilder lives() {
        return new PersonAddressBuilder(person);
    }

    public PersonJobBuilder works() {
        return new PersonJobBuilder(person);
    }

    public Person build() {
        return person;
    }
}

class PersonAddressBuilder extends PersonBuilder {

    public PersonAddressBuilder(Person person) {
        this.person = person;
    }

    public PersonAddressBuilder at(String streetAddress) {
        person.setStreetAddress(streetAddress);
        return this;
    }

    public PersonAddressBuilder withPostcode(String postcode) {
        person.setPostcode(postcode);
        return this;
    }

    public PersonAddressBuilder in(String city) {
        person.setCity(city);
        return this;
    }
}

class PersonJobBuilder extends PersonBuilder {
    public PersonJobBuilder(Person person) {
        this.person = person;
    }

    public PersonJobBuilder at(String companyName) {
        person.setCompanyName(companyName);
        return this;
    }

    public PersonJobBuilder asA(String position) {
        person.setPosition(position);
        return this;
    }

    public PersonJobBuilder earning(int annualIncome) {
        person.setAnnualIncome(annualIncome);
        return this;
    }
}

class Demo {
    public static void main(String[] args) {
        PersonBuilder pb = new PersonBuilder();
        Person person = pb.lives()
                .at("123 London")
                .in("London")
                .withPostcode("SW123BCF")
                .works()
                .at("Fabrikam")
                .asA("Engineer")
                .earning(123000)
                .build();
        System.out.println(person);
    }
}