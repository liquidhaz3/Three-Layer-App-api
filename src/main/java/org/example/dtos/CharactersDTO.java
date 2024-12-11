package org.example.dtos;

public class CharactersDTO {

    private String name;
    private String planetName;

    // Constructor
    public CharactersDTO(String name, String planetName) {
        this.name = name;
        this.planetName = planetName;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlanetName() {
        return planetName;
    }

    public void setPlanetName(String planetName) {
        this.planetName = planetName;
    }
}