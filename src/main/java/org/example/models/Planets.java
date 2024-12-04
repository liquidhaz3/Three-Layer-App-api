package org.example.models;

public class Planets {
    int id;
    String name;
    String climate;
    long population;

    public Planets(int id, String name, String climate, long population) {
        this.id = id;
        this.name = name;
        this.climate = climate;
        this.population = population;
    }

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
