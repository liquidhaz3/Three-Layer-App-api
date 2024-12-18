package org.example.controllers;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.models.Planets;
import org.example.service.PlanetsService;

import java.sql.SQLException;

@Path("/api/planets")
public class PlanetsController {

    private PlanetsService planetsService;

    public PlanetsController(PlanetsService planetsService) {
        this.planetsService = planetsService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPlanets() throws SQLException {
        return Response.ok(planetsService.getAllPlanets()).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPlanetById(@PathParam("id") int id) throws SQLException {
        Planets planet = planetsService.getPlanetById(id);
        if (planet != null) {
            return Response.ok(planet).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createPlanet(Planets planet) throws SQLException {
        planetsService.createPlanet(planet);
        return Response.status(Response.Status.CREATED).entity(planet).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePlanet(@PathParam("id") int id, Planets planet) throws SQLException {
        planet.setId(id);
        planetsService.updatePlanet(planet);
        return Response.ok(planet).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletePlanet(@PathParam("id") int id) throws SQLException {
        planetsService.deletePlanet(id);
        return Response.noContent().build();
    }
}