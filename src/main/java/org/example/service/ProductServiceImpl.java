package org.example.service;

import org.example.daos.ProductDao;
import org.example.factories.ProductFactory;
import org.example.models.Product;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    private final ProductDao productDao;

    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public Product createProduct(String productType, int id, String name, Map<String, String> attributes) {
        Product product = ProductFactory.createProduct(productType, id, name, attributes);
        try {
            productDao.createProduct(product);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to create product", e);
        }
        return product;
    }

    @Override
    public Product getProductById(int id) {
        try {
            return productDao.getProductById(id);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to get product by id", e);
        }
    }

    @Override
    public List<Product> getAllProducts() {
        try {
            return productDao.getAllProducts();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to get all products", e);
        }
    }

    @Override
    public void updateProduct(Product product) {
        try {
            productDao.updateProduct(product);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to update product", e);
        }
    }

    @Override
    public void deleteProduct(int id) {
        try {
            productDao.deleteProduct(id);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to delete product", e);
        }
    }
}