package org.example.controllers;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.awt.*;

@Path("/api/planets")
public class PlantesController {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPlanets() {
        return Response.ok().entity("list of planets").build();
    }
}
