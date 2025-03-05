package org.example.dtos;

public class ProductDTO {

    private int id;
    private String name;
    private String type;
    private String attribute1;
    private String attribute2;

    // Default constructor
    public ProductDTO() {}

    // Parameterized constructor
    public ProductDTO(int id, String name, String type, String attribute1, String attribute2) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.attribute1 = attribute1;
        this.attribute2 = attribute2;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAttribute1() {
        return attribute1;
    }

    public void setAttribute1(String attribute1) {
        this.attribute1 = attribute1;
    }

    public String getAttribute2() {
        return attribute2;
    }

    public void setAttribute2(String attribute2) {
        this.attribute2 = attribute2;
    }
}
