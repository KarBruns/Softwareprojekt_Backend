package awk.softwareprojekt.rest;


import de.kunde.awk.entity.KundeTO;
import awk.softwareprojekt.security.JWTTokenNeeded;
import awk.softwareprojekt.security.Role;
import de.kunde.awk.usecase.IKundenManagen;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Collection;

@Path("kunde")
@Stateless
@Produces(MediaType.APPLICATION_JSON)
@Consumes((MediaType.APPLICATION_JSON))
public class KundeResource {


    @Inject
    IKundenManagen kundenManagen;


    @POST
    @Path("createKunde")
    @JWTTokenNeeded(Permissions = Role.ADMIN)
    public Response createParticipant(KundeTO kTO) {
        if (kundenManagen.createKunde(kTO)) {
            return Response.ok().build();
        } else {
            return Response.status(404, "Fehler beim Anlegen von Kunde").build();
        }

    }


    @GET
    @Path("getKunde/{id}")
    public KundeTO getKunde(@PathParam("id") long id) {
        return kundenManagen.findKunde(id);
    }


    @POST
    @Path("deleteKunde/{id}")
    @JWTTokenNeeded(Permissions = Role.ADMIN)
    public Response deleteKunde(@PathParam("id") long id) {
        if (kundenManagen.deleteKunde(id)) {
            return Response.ok().build();
        } else {
            return Response.status(404, "Fehler beim Loeschen von Kunde").build();
        }
    }

    @POST
    @Path("editKunde")
    @JWTTokenNeeded(Permissions = Role.ADMIN)
    public Response editParticipant(KundeTO kTO) {
        if (kundenManagen.updateKunde(kTO)) {
            return Response.ok().build();
        } else {
            return Response.status(404, "Fehler beim Bearbeiten von Kunde").build();
        }
    }

    @GET
    @Path("getAllKunden")
    public Collection<KundeTO> getAllKunden() {
        return kundenManagen.getAllKunden();
    }


//    @GET
//    @Path("findKunde/{name}/{firstName}")
//    public KundeTO getParticipant(@PathParam("name") String name, @PathParam("firstName") String firstName) {
//        return kundenManagen.findKundeByName(name, firstName);
//    }
}
