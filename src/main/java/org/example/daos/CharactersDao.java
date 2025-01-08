package org.example.daos;
import org.example.dtos.CharactersDTO;
import org.example.models.Characters;
import java.sql.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CharactersDao {

    public List<Characters> getAllCharacters() throws SQLException {
        try (Connection connection = DatabaseConnector.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT id, name, species, home_planet_id FROM characters")) {

            return Stream.generate(() -> {
                        try {
                            if (resultSet.next()) {
                                return new Characters(
                                        resultSet.getInt("id"),
                                        resultSet.getString("name"),
                                        resultSet.getString("species"),
                                        resultSet.getInt("home_planet_id")
                                );
                            }
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                        return null;
                    })
                    .takeWhile(character -> character != null)
                    .collect(Collectors.toList());
        }
    }

    public List<Characters> getCharactersBySpecies(String species) throws SQLException {
        String query = "SELECT name, species FROM characters WHERE species = '" + species + "'";

        try (Connection connection = DatabaseConnector.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            return Stream.generate(() -> {
                        try {
                            if (resultSet.next()) {
                                return new Characters(
                                        resultSet.getString("name"),
                                        resultSet.getString("species")
                                );
                            }
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                        return null;
                    })
                    .takeWhile(character -> character != null)
                    .collect(Collectors.toList());
        }
    }

    public List<CharactersDTO> getCharactersByPlanet(String planetName) throws SQLException {
        String query = "SELECT c.name AS character_name, p.name AS planet_name " +
                "FROM characters c " +
                "JOIN planets p ON c.home_planet_id = p.id " +
                "WHERE p.name = '" + planetName + "'";

        try (Connection connection = DatabaseConnector.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            return Stream.generate(() -> {
                        try {
                            if (resultSet.next()) {
                                return new CharactersDTO(
                                        resultSet.getString("character_name"),
                                        resultSet.getString("planet_name")
                                );
                            }
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                        return null;
                    })
                    .takeWhile(character -> character != null)
                    .collect(Collectors.toList());
        }
    }

    public void createCharacters(Characters character) throws SQLException {
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO characters (name, species, home_planet_id) VALUES (?, ?, ?)")) {

            statement.setString(1, character.getName());
            statement.setString(2, character.getSpecies());
            statement.setInt(3, character.getPlanet());
            statement.executeUpdate();
        }
    }

    public void updateCharacters(Characters character) throws SQLException {
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "UPDATE characters SET name = ?, species = ?, home_planet_id = ? WHERE id = ?")) {

            statement.setString(1, character.getName());
            statement.setString(2, character.getSpecies());
            statement.setInt(3, character.getPlanet());
            statement.setInt(4, character.getId());
            statement.executeUpdate();
        }
    }

    public void deleteCharacters(int id) {
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM characters WHERE id = ?")) {

            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Failed to delete character: " + e.getMessage());
        }
    }

    public Characters getCharacterById(int id) {
        Characters character = null;
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM characters WHERE id = ?")) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                character = new Characters(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("species"),
                        resultSet.getInt("home_planet_id")
                );
            }
        } catch (SQLException e) {
            System.err.println("Failed to get character by ID: " + e.getMessage());
        }
        return character;
    }
}