package com.example.dp.creation.builder.exercise;

import java.util.ArrayList;
        import java.util.List;

public class Exercise {

}

class CodeBuilder {
    private String className;
    private List<Field> fields = new ArrayList<>();

    public CodeBuilder(String className) {
        this.className = className;
    }

    public CodeBuilder addField(String name, String type) {
        fields.add(new Field(name, type));
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("public class %s\n", className)).append("{\n");

        for (Field field : fields) {
            sb.append(String.format("  public %s %s;\n", field.type, field.name));
        }

        sb.append("}\n");
        return sb.toString();
    }
}

class Field {
    public String name;
    public String type;

    public Field(String name, String type) {
        this.name = name;
        this.type = type;
    }
}
