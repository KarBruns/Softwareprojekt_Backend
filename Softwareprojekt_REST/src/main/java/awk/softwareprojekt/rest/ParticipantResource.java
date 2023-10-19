package awk.softwareprojekt.rest;

import de.kursverwaltung.security.JWTTokenNeeded;
import de.kursverwaltung.security.Role;
import de.kursverwaltung.teilnehmer.entity.ParticipantTO;
import de.kursverwaltung.teilnehmer.usecase.IManageParticipants;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Collection;

@Path("participant")
@Stateless
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ParticipantResource {

	@Inject
	IManageParticipants manageParticipants;
	
	@POST
	@Path("createParticipant")
	@JWTTokenNeeded(Permissions = Role.ADMIN)
	public Response createParticipant(ParticipantTO pTO) {
		if (manageParticipants.createParticipant(pTO)) {
			return Response.ok().build();
		} else {
			return Response.status(404, "Fehler beim Anlegen von Teilnehmer").build();
		}

	}
	
	
	@GET
	@Path("getParticipant/{id}")
	public ParticipantTO getParticipant(@PathParam("id") long id) {
		return manageParticipants.findParticipant(id);
	}
	
	
	@POST
	@Path("deleteParticipant/{id}")
	@JWTTokenNeeded(Permissions = Role.ADMIN)
	public Response deleteParticipant(@PathParam("id") long id) {
		if (manageParticipants.deleteParticipant(id)) {
			return Response.ok().build();
		} else {
			return Response.status(404, "Fehler beim Loeschen von Teilnehmer").build();
		}
	}
	
	@POST
	@Path("editParticipant")
	@JWTTokenNeeded(Permissions = Role.ADMIN)
	public Response editParticipant(ParticipantTO pTO) {
		if (manageParticipants.updateParticipant(pTO)) {
			return Response.ok().build();
		} else {
			return Response.status(404, "Fehler beim Bearbeiten von Teilnehmer").build();
		}
	}
	
	@GET
	@Path("getAllParticipants")
	public Collection<ParticipantTO> getAllParticipants() {
		return manageParticipants.getAllParticipants();
	}
	
	
	@GET
	@Path("findParticipant/{name}/{firstName}")
	public ParticipantTO getParticipant(@PathParam("name") String name, @PathParam("firstName") String firstName) {
		return manageParticipants.findParticipantByName(name, firstName);
	}
	
}
