package com.example.dp.creation.prototype.copyconstructor;

class Address {
    public String streetAddress, city, country;

    public Address(String streetAddress, String city, String country) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.country = country;
    }

    public Address(Address other) {
        this(other.streetAddress, other.city, other.country);
    }

    @Override
    public String toString() {
        return "Address{" +
                "streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}

class Employee {
    public String name;
    public Address address;

    public Employee(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public Employee(Employee other) {
        name = other.name;
        address = new Address(other.address);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}

class Demo {
    public static void main(String[] args) {
        Employee john = new Employee("john", new Address("asdfasd asdfa", "123", "dd33"));
        Employee wayne = new Employee(john);
        wayne.address.city = "seoul";
        wayne.name = "wayne";

        System.out.println(john);
        System.out.println(wayne);
    }
}
