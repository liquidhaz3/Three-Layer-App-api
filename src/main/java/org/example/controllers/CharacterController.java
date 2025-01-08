package org.example.controllers;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.dtos.CharactersDTO;
import org.example.models.Characters;
import org.example.models.Planets;
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
    @Path("/species/{species}")
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

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createCharacter(Characters character) throws SQLException {
        charactersService.createCharacter(character);
        return Response.status(Response.Status.CREATED).entity(character).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePlanet(@PathParam("id") int id, Characters character) throws SQLException {
        character.setId(id);
        charactersService.updateCharacter(character);
        return Response.ok(character).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteCharacter(@PathParam("id") int id) throws SQLException {
        charactersService.deleteCharacter(id);
        return Response.noContent().build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCharacterById(@PathParam("id") int id) throws SQLException {
        Characters character = charactersService.getCharacterById(id);
        if (character != null) {
            return Response.ok(character).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
