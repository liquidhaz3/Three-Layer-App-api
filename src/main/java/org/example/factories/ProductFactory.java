package org.example.factories;

import org.example.models.Desktop;
import org.example.models.Laptop;
import org.example.models.Monitor;
import org.example.models.Product;

public class ProductFactory {

    public static Product createProduct(String productType, int id, String name, String... attributes) {
        switch (productType) {
            case "Laptop":
                return new Laptop(id, name, attributes[0], Integer.parseInt(attributes[1]));
            case "Desktop":
                return new Desktop(id, name, attributes[0], Integer.parseInt(attributes[1]));
            case "Monitor":
                return new Monitor(id, name, attributes[0], Integer.parseInt(attributes[1]));
            default:
                throw new IllegalArgumentException("Unknown product type: " + productType);
        }
    }
}