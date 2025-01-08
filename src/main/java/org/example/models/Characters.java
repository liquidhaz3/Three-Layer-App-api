package org.example.models;

public class Characters {
    private int id;
    private String name;
    private String species;
    private int planet;

    public Characters() {
        // Default constructor
    }

    public Characters(int id, String name, String species, int planet) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.planet = planet;
    }

    public Characters(String name, String species) {
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

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getPlanet() {
        return planet;
    }

    public void setPlanet(int planet) {
        this.planet = planet;
    }
}