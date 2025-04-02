package org.example.models;

import java.util.Map;

public interface Product {
    int getId();
    void setId(int id);
    String getName();
    void setName(String name);
    String getType();
    void setType(String type);
    Map<String, String> getAttributes();
    void setAttributes(Map<String, String> attributes);
}