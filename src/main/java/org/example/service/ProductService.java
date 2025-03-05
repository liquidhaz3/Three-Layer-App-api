package org.example.service;

import org.example.models.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(String productType, int id, String name, String attribute1, String attribute2);
    Product getProductById(int id);
    List<Product> getAllProducts();
    void updateProduct(Product product);
    void deleteProduct(int id);

    Product createProduct(Product createdProduct);
}
