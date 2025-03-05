package org.example.models;

public class Monitor implements Product {
    private int id;
    private String name;
    private String resolution;
    private int size;

    // Default constructor
    public Monitor() {}

    // Parameterized constructor
    public Monitor(int id, String name, String resolution, int size) {
        this.id = id;
        this.name = name;
        this.resolution = resolution;
        this.size = size;
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

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}