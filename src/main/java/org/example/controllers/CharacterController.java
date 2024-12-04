package org.example.controllers;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/characters")
public class CharacterController {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCharacters() {
        return Response.ok("{\"characters\":[]}").build();
    }
}
