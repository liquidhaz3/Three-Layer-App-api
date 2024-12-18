package org.example.daos;

import org.example.models.Planets;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlanetsDao {

    private Connection connection;

    public List<Planets> getAllPlanets() throws SQLException {
        List<Planets> planets = new ArrayList<>();

        try (Connection connection = DatabaseConnector.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM planets");

            while (resultSet.next()) {
                planets.add(new Planets(resultSet.getInt("id"), resultSet.getString("name"),
                        resultSet.getString("climate"), resultSet.getLong("population")));
            }
        }
        return planets;
    }

    public Planets getPlanetById(int id) throws SQLException {
        Planets planet = null;

        try (Connection connection = DatabaseConnector.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM planets WHERE id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                planet = new Planets(resultSet.getInt("id"), resultSet.getString("name"),
                        resultSet.getString("climate"), resultSet.getLong("population"));
            }
        }
        return planet;
    }

    public void createPlanet(Planets planet) throws SQLException {
        try (Connection connection = DatabaseConnector.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO planets (name, climate, population) VALUES (?, ?, ?)");
            statement.setString(1, planet.getName());
            statement.setString(2, planet.getClimate());
            statement.setLong(3, planet.getPopulation());
            statement.executeUpdate();
        }
    }

    public void updatePlanet(Planets planet) throws SQLException {
        try (Connection connection = DatabaseConnector.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE planets SET name = ?, climate = ?, population = ? WHERE id = ?");
            statement.setString(1, planet.getName());
            statement.setString(2, planet.getClimate());
            statement.setLong(3, planet.getPopulation());
            statement.setInt(4, planet.getId());
            statement.executeUpdate();
        }
    }

    public void deletePlanet(int id) throws SQLException {
        try (Connection connection = DatabaseConnector.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM planets WHERE id = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}