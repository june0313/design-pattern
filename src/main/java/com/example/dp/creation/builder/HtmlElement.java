package com.example.dp.creation.builder;

import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.nCopies;

public class HtmlElement {
    @Setter
    private String name;
    private String text;
    private final List<HtmlElement> elements = new ArrayList<>();
    private final int indentSize = 2;
    private final String newLine = System.lineSeparator();

    public HtmlElement() {
    }

    public HtmlElement(String name, String text) {
        this.name = name;
        this.text = text;
    }

    public void addElement(HtmlElement e) {
        elements.add(e);
    }

    @Override
    public String toString() {
        return toStringImpl(0);
    }

    private String toStringImpl(int indent) {
        StringBuilder sb = new StringBuilder();
        String i = String.join("", nCopies(indent * indentSize, " "));
        sb.append(String.format("%s<%s>%s", i, name, newLine));

        if (text != null && !text.isEmpty()) {
            sb.append(String.join("", nCopies(indentSize * (indent + 1), " ")))
                    .append(text)
                    .append(newLine);
        }

        for (HtmlElement e : elements) {
            sb.append(e.toStringImpl(indent + 1));
        }

        sb.append(String.format("%s</%s>%s", i, name, newLine));
        return sb.toString();
    }
}
