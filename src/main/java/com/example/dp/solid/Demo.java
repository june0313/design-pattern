package com.example.dp.solid;

import java.io.FileNotFoundException;

public class Demo {
    public static void main(String[] args) throws FileNotFoundException {
        Journal j = new Journal();
        j.addEntry("I cried today");
        j.addEntry("I ate a bug");
        System.out.println(j);

        Persistence p = new Persistence();
        String filename = "/Users/june/study/degisn-pattern/src/main/resources/journal.txt";
        p.saveToFile(j, filename, true);
    }
}
