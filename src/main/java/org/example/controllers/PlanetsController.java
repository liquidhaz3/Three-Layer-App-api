package org.example.controllers;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.service.PlanetsService;

import java.sql.SQLException;

@Path("/api/planets")
public class PlanetsController {

    PlanetsService planetsService;

    public PlanetsController(PlanetsService planetsService){
        this.planetsService = planetsService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPlanets() throws SQLException {
        return Response.ok().entity(planetsService.getAllPlanets()).build();
    }
}
