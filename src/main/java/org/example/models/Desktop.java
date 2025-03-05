package org.example.models;

public class Desktop implements Product {
    private int id;
    private String name;
    private String graphicsCard;
    private int storage;

    // Default constructor
    public Desktop() {}

    // Parameterized constructor
    public Desktop(int id, String name, String graphicsCard, int storage) {
        this.id = id;
        this.name = name;
        this.graphicsCard = graphicsCard;
        this.storage = storage;
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

    public String getGraphicsCard() {
        return graphicsCard;
    }

    public void setGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }
}