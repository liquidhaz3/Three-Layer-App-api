package org.example.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {

    public static Connection connection;

    public static Connection getConnection() throws SQLException {
        if (connection != null && connection.isValid(0)) {
            return connection;
        }

        // Load environment variables - we need to add them to edit config
        String username = System.getenv("DB_USERNAME");
        String password = System.getenv("DB_PASSWORD");
        String host = System.getenv("DB_HOST");
        String database = System.getenv("DB_DATABASE");

        if (username == null || password == null || host == null || database == null) {
            throw new IllegalArgumentException("Missing required environment variables: "
                    + "DB_USERNAME, DB_PASSWORD, DB_HOST, DB_DATABASE");
        }


        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://" + host + "/" + database + "?useSSL=false",
                    username,
                    password
            );
            System.out.println("Connected to database successfully.");
        } catch (SQLException e) {
            System.err.println("Failed to connect to the database: " + e.getMessage());
            throw e;
        }

        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Database connection closed.");
            } catch (SQLException e) {
                System.err.println("Failed to close database connection: " + e.getMessage());
            }
        }
    }
}
