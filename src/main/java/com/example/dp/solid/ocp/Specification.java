package com.example.dp.solid.ocp;

public interface Specification<T> {
    boolean isSatisfied(T item);
}
