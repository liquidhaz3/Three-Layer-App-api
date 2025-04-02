package org.example.daos;

import org.example.models.Product;
import org.example.factories.ProductFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProductDao {
    private Connection connection;

    public List<Product> getAllProducts() throws SQLException {
        List<Product> products = new ArrayList<>();
        try (Connection connection = DatabaseConnector.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT id, name, type, attribute1, attribute2 FROM products")) {
            while (resultSet.next()) {
                products.add(createProductFromResultSet(resultSet));
            }
        }
        return products;
    }

    public Product getProductById(int id) throws SQLException {
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT id, name, type, attribute1, attribute2 FROM products WHERE id = ?")) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return createProductFromResultSet(resultSet);
                }
            }
        }
        return null;
    }

    public void createProduct(Product product) throws SQLException {
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO products (name, type, attribute1, attribute2) VALUES (?, ?, ?, ?)")) {
            statement.setString(1, product.getName());
            statement.setString(2, product.getType());
            Map<String, String> attributes = product.getAttributes();
            statement.setString(3, attributes.get("attribute1"));
            statement.setString(4, attributes.get("attribute2"));
            statement.executeUpdate();
        }
    }

    public void updateProduct(Product product) throws SQLException {
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "UPDATE products SET name = ?, attribute1 = ?, attribute2 = ? WHERE id = ?")) {
            statement.setString(1, product.getName());
            Map<String, String> attributes = product.getAttributes();
            statement.setString(2, attributes.get("attribute1"));
            statement.setString(3, attributes.get("attribute2"));
            statement.setInt(4, product.getId());
            statement.executeUpdate();
        }
    }

    public void deleteProduct(int id) throws SQLException {
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM products WHERE id = ?")) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }

    private Product createProductFromResultSet(ResultSet resultSet) throws SQLException {
        Map<String, String> attributes = Map.of(
                "attribute1", resultSet.getString("attribute1"),
                "attribute2", resultSet.getString("attribute2")
        );
        return ProductFactory.createProduct(
                resultSet.getString("type"),
                resultSet.getInt("id"),
                resultSet.getString("name"),
                attributes
        );
    }
}