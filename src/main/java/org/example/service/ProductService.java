package org.example.service;

import org.example.models.Product;

import java.util.List;
import java.util.Map;

public interface ProductService {
    Product createProduct(String productType, int id, String name, Map<String, String> attributes);
    Product getProductById(int id);
    List<Product> getAllProducts();
    void updateProduct(Product product);
    void deleteProduct(int id);
}