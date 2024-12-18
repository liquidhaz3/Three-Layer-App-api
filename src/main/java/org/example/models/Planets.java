package org.example.models;

public class Planets {
    private int id;
    private String name;
    private String climate;
    private long population;

    // Default constructor
    public Planets() {}

    // Parameterized constructor
    public Planets(int id, String name, String climate, long population) {
        this.id = id;
        this.name = name;
        this.climate = climate;
        this.population = population;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }
}