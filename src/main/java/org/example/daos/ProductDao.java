package org.example.daos;

import org.example.models.Product;
import org.example.models.Laptop;
import org.example.models.Desktop;
import org.example.models.Monitor;

import java.sql.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductDao {

    public List<Product> getAllProducts() throws SQLException {
        try (Connection connection = DatabaseConnector.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT id, name, type, attribute1, attribute2 FROM products")) {

            return Stream.generate(() -> {
                        try {
                            if (resultSet.next()) {
                                String type = resultSet.getString("type");
                                switch (type) {
                                    case "Laptop":
                                        return new Laptop(
                                                resultSet.getInt("id"),
                                                resultSet.getString("name"),
                                                resultSet.getString("attribute1"),
                                                resultSet.getInt("attribute2")
                                        );
                                    case "Desktop":
                                        return new Desktop(
                                                resultSet.getInt("id"),
                                                resultSet.getString("name"),
                                                resultSet.getString("attribute1"),
                                                resultSet.getInt("attribute2")
                                        );
                                    case "Monitor":
                                        return new Monitor(
                                                resultSet.getInt("id"),
                                                resultSet.getString("name"),
                                                resultSet.getString("attribute1"),
                                                resultSet.getInt("attribute2")
                                        );
                                    default:
                                        throw new IllegalArgumentException("Unknown product type: " + type);
                                }
                            }
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                        return null;
                    })
                    .takeWhile(product -> product != null)
                    .collect(Collectors.toList());
        }
    }

    public Product getProductById(int id) throws SQLException {
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT id, name, type, attribute1, attribute2 FROM products WHERE id = ?")) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String type = resultSet.getString("type");
                switch (type) {
                    case "Laptop":
                        return new Laptop(
                                resultSet.getInt("id"),
                                resultSet.getString("name"),
                                resultSet.getString("attribute1"),
                                resultSet.getInt("attribute2")
                        );
                    case "Desktop":
                        return new Desktop(
                                resultSet.getInt("id"),
                                resultSet.getString("name"),
                                resultSet.getString("attribute1"),
                                resultSet.getInt("attribute2")
                        );
                    case "Monitor":
                        return new Monitor(
                                resultSet.getInt("id"),
                                resultSet.getString("name"),
                                resultSet.getString("attribute1"),
                                resultSet.getInt("attribute2")
                        );
                    default:
                        throw new IllegalArgumentException("Unknown product type: " + type);
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
            statement.setString(2, product.getClass().getSimpleName());
            if (product instanceof Laptop) {
                statement.setString(3, ((Laptop) product).getProcessor());
                statement.setInt(4, ((Laptop) product).getRam());
            } else if (product instanceof Desktop) {
                statement.setString(3, ((Desktop) product).getGraphicsCard());
                statement.setInt(4, ((Desktop) product).getStorage());
            } else if (product instanceof Monitor) {
                statement.setString(3, ((Monitor) product).getResolution());
                statement.setInt(4, ((Monitor) product).getSize());
            }
            statement.executeUpdate();
        }
    }

    public void updateProduct(Product product) throws SQLException {
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "UPDATE products SET name = ?, attribute1 = ?, attribute2 = ? WHERE id = ?")) {

            statement.setString(1, product.getName());
            if (product instanceof Laptop) {
                statement.setString(2, ((Laptop) product).getProcessor());
                statement.setInt(3, ((Laptop) product).getRam());
            } else if (product instanceof Desktop) {
                statement.setString(2, ((Desktop) product).getGraphicsCard());
                statement.setInt(3, ((Desktop) product).getStorage());
            } else if (product instanceof Monitor) {
                statement.setString(2, ((Monitor) product).getResolution());
                statement.setInt(3, ((Monitor) product).getSize());
            }
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
}
