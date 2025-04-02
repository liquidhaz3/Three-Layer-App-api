package org.example.models;

import java.util.HashMap;
import java.util.Map;

public class Laptop implements Product {
    private int id;
    private String name;
    private String type;
    private Map<String, String> attributes = new HashMap<>();

    public Laptop(int id, String name, String processor, int ram) {
        this.id = id;
        this.name = name;
        this.type = "Laptop";
        this.attributes.put("Processor", processor);
        this.attributes.put("RAM", String.valueOf(ram));
    }

    @Override
    public int getId() { return id; }
    @Override
    public void setId(int id) { this.id = id; }
    @Override
    public String getName() { return name; }
    @Override
    public void setName(String name) { this.name = name; }
    @Override
    public String getType() { return type; }
    @Override
    public void setType(String type) { this.type = type; }
    @Override
    public Map<String, String> getAttributes() { return attributes; }
    @Override
    public void setAttributes(Map<String, String> attributes) { this.attributes = attributes; }
}