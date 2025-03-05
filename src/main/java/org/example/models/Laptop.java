package org.example.models;

public class Laptop implements Product {
    private int id;
    private String name;
    private String processor;
    private int ram;

    // Default constructor
    public Laptop() {}

    // Parameterized constructor
    public Laptop(int id, String name, String processor, int ram) {
        this.id = id;
        this.name = name;
        this.processor = processor;
        this.ram = ram;
    }

    // Getters and Setters
    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }
}