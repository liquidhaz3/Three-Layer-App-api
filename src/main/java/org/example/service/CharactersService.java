package org.example.service;

import org.example.daos.CharactersDao;
import org.example.daos.PlanetsDao;
import org.example.dtos.CharactersDTO;
import org.example.models.Characters;
import org.example.models.Planets;

import java.sql.SQLException;
import java.util.List;

public class CharactersService {
    CharactersDao charactersDao;

    public CharactersService(CharactersDao charactersDao) {
        this.charactersDao = charactersDao;
    }

    public List<CharactersDTO> getCharactersByPlanet(String planet) throws SQLException {
        return charactersDao.getCharactersByPlanet(planet);
    }

    public List<Characters> getAllCharacters() throws SQLException {
        return charactersDao.getAllCharacters();
    }

    public List <Characters> getCharactersBySpecies(String species) throws SQLException {
        return charactersDao.getCharactersBySpecies(species);
    }
}
