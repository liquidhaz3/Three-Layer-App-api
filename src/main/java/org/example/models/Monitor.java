package org.example.models;

import java.util.HashMap;
import java.util.Map;

public class Monitor implements Product {
    private int id;
    private String name;
    private String type;
    private Map<String, String> attributes = new HashMap<>();

    public Monitor(int id, String name, int size, String resolution) {
        this.id = id;
        this.name = name;
        this.type = "Monitor";
        this.attributes.put("Size", String.valueOf(size));
        this.attributes.put("Resolution", resolution);
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