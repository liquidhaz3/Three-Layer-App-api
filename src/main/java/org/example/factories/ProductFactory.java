package org.example.factories;

import org.example.models.Desktop;
import org.example.models.Laptop;
import org.example.models.Monitor;
import org.example.models.Product;

import java.util.Map;

public class ProductFactory {
    public static Product createProduct(String type, int id, String name, Map<String, String> attributes) {
        switch (type.toLowerCase()) {
            case "laptop":
                return new Laptop(id, name, attributes.get("Processor"),
                        attributes.get("RAM") != null ? Integer.parseInt(attributes.get("RAM")) : 0);
            case "desktop":
                return new Desktop(id, name, attributes.get("Processor"),
                        attributes.get("Storage") != null ? Integer.parseInt(attributes.get("Storage")) : 0);
            case "monitor":
                return new Monitor(id, name,
                        attributes.get("Size") != null ? Integer.parseInt(attributes.get("Size")) : 0,
                        attributes.get("Resolution"));
            default:
                throw new IllegalArgumentException("Unknown product type: " + type);
        }
    }
}