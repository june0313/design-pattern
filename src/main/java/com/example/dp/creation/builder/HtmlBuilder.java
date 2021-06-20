package com.example.dp.creation.builder;

public class HtmlBuilder {
    private final String rootName;
    private HtmlElement root = new HtmlElement();

    public HtmlBuilder(String rootName) {
        this.rootName = rootName;
        root.setName(rootName);
    }

    public HtmlBuilder addChild(String childName, String childText) {
        HtmlElement e = new HtmlElement(childName, childText);
        root.addElement(e);
        return this;
    }

    public void clear() {
        root = new HtmlElement();
        root.setName(rootName);
    }

    public String toString() {
        return root.toString();
    }
}
