package com.example.dp.creation.builder;

public class Demo2 {
    public static void main(String[] args) {
        PersonBuilder pb = new PersonBuilder();
        Person wayne = pb.withName("Wayne").build();

        EmployeeBuilder eb = new EmployeeBuilder();
        Person wayne2 = eb.withName("wayne").worksAt("Developer").build();
        System.out.println(wayne2);

    }
}
