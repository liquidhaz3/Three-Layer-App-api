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
}
