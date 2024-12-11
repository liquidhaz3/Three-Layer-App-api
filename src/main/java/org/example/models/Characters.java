package org.example.models;

public class Characters {

    private int id;
    private String name;
    private String species;
    private int home_planet_id;

    // Konstruktor łańcuchowy (name, species)
    public Characters(String name, String species) {
        this.name = name;
        this.species = species;
    }

    // Konstruktor łańcuchowy (name, species, home_planet_id)
    public Characters(String name, String species, int home_planet_id) {
        this.name = name;
        this.species = species;
        this.home_planet_id = home_planet_id;
    }

    // Konstruktor pełny (id, name, species, home_planet_id)
    public Characters(int id, String name, String species, int home_planet_id) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.home_planet_id = home_planet_id;
    }

    // Gettery i settery
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public int getHome_planet_id() {
        return home_planet_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setHome_planet_id(int home_planet_id) {
        this.home_planet_id = home_planet_id;
    }

    @Override
    public String toString() {
        return "Character: " + name + ", Species: " + species + ", Home Planet ID: " + home_planet_id;
    }
}