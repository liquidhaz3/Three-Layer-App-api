package org.example.service;

import org.example.daos.PlanetsDao;
import org.example.models.Planets;

import java.sql.SQLException;
import java.util.List;

public class PlanetsService {
    PlanetsDao planetsDao;

    public PlanetsService(PlanetsDao planetsDao) {
        this.planetsDao = planetsDao;
    }

    public List<Planets> getAllPlanets() throws SQLException {
        return planetsDao.getAllPlanets();
    }

    public Planets getPlanetById(int id) throws SQLException {
        return planetsDao.getPlanetById(id);
    }

    public void createPlanet(Planets planet) throws SQLException {
        planetsDao.createPlanet(planet);
    }

    public void updatePlanet(Planets planet) throws SQLException {
        planetsDao.updatePlanet(planet);
    }

    public void deletePlanet(int id) throws SQLException {
        planetsDao.deletePlanet(id);
    }
}
