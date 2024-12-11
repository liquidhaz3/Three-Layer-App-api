package org.example.controllers;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.dtos.CharactersDTO;
import org.example.models.Characters;
import org.example.service.CharactersService;

import java.sql.SQLException;
import java.util.List;

@Path("/api/characters")
public class CharacterController {

    CharactersService charactersService;

    public CharacterController(CharactersService charactersService){
        this.charactersService = charactersService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCharacters() throws SQLException {
        return Response.ok().entity(charactersService.getAllCharacters()).build();
    }

    @GET
    @Path("/{species}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCharactersBySpecies(@PathParam("species")String species) throws SQLException {
        List<Characters> characters = charactersService.getCharactersBySpecies(species);
        return Response.ok(characters).build();
    }

    @GET
    @Path("/planet/{planet}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCharactersByPlanet(@PathParam("planet")String planet) throws SQLException {
        List<CharactersDTO> characters = charactersService.getCharactersByPlanet(planet);
        return Response.ok(characters).build();
    }
}
