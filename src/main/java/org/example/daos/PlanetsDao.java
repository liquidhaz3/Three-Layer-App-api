package org.example.daos;

import org.example.models.Planets;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlanetsDao {
    public List<Planets> getAllPlanets() throws SQLException {
        List<Planets> planets = new ArrayList<>();

        try (Connection connection = DatabaseConnector.getConnection();){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM planets");

            while (resultSet.next()) {
                planets.add(new Planets(resultSet.getInt("id"), resultSet.getString("name"),
                        resultSet.getString("climate"), resultSet.getLong("population") ));
            }
            /*PreparedStatement statement = connection.prepareStatement("SELECT * FROM planets");*/
        }
        return planets;
    }
}
