package org.example.service;

import org.example.factories.ProductFactory;
import org.example.models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductServiceImpl implements ProductService {
    private final List<Product> products = new ArrayList<>();

    @Override
    public Product createProduct(String productType, int id, String name, String attribute1, String attribute2) {
        Product product = ProductFactory.createProduct(productType, id, name, attribute1, attribute2);
        products.add(product);
        return product;
    }

    @Override
    public Product getProductById(int id) {
        Optional<Product> product = products.stream().filter(p -> p.getId() == id).findFirst();
        return product.orElse(null);
    }

    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }

    @Override
    public void updateProduct(Product product) {
        int index = products.indexOf(getProductById(product.getId()));
        if (index >= 0) {
            products.set(index, product);
        }
    }

    @Override
    public void deleteProduct(int id) {
        products.removeIf(p -> p.getId() == id);
    }
}