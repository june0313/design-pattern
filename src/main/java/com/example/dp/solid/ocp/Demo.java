package com.example.dp.solid.ocp;

import java.util.List;

public class Demo {
    public static void main(String[] args) {
        Product apple = new Product("Apple", Color.GREEN, Size.SMALL);
        Product tree = new Product("Tree", Color.GREEN, Size.LARGE);
        Product house = new Product("House", Color.BLUE, Size.LARGE);

        List<Product> products = List.of(apple, tree, house);

        System.out.println("Green products: ");
        BetterFilter filter = new BetterFilter();
        filter.filter(products, new ColorSpecification(Color.GREEN))
                .forEach(p -> System.out.println(" - " + p.getName() + " is green"));

        System.out.println("Large blue products: ");
        filter.filter(products, new AndSpecification<>(
                new ColorSpecification(Color.BLUE),
                new SizeSpecification(Size.LARGE)))
                .forEach(p -> System.out.println(" - " + p.getName() + " is blue and large"));
    }
}
