package com.example.dp.creation.prototype.serialization;

import org.apache.commons.lang3.SerializationUtils;

import java.io.Serializable;

class Foo implements Serializable {
    public int stuff;
    public String whatever;

    public Foo(int stuff, String whatever) {
        this.stuff = stuff;
        this.whatever = whatever;
    }

    @Override
    public String toString() {
        return "Foo{" +
                "stuff=" + stuff +
                ", whatever='" + whatever + '\'' +
                '}';
    }
}

class Demo {
    public static void main(String[] args) {
        Foo foo = new Foo(1, "test");
        Foo foo2 = SerializationUtils.roundtrip(foo);

        foo2.stuff = 999;
        foo2.whatever = "zzzwy";

        System.out.println(foo);
        System.out.println(foo2);
    }
}
