package awk.softwareprojekt.rest;


import awk.entity.FotoTO;
import awk.entity.KundeTO;
import awk.entity.TerminTO;
import awk.softwareprojekt.security.JWTTokenNeeded;
import awk.softwareprojekt.security.Role;
import awk.usecase.*;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Path("termin")
@Stateless
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TerminResource {

    @Inject
    ITermineManagen termineManagen;

    @Inject
    IFotosManagen fotosManagen;

    @Inject
    IFotosInTerminManagen fotosInTerminManagen;

    @Inject
    IKundenManagen kundenManagen;

    @Inject
    IKundenInTerminManagen kundenInTerminManagen;


    @POST
    @Path("createTermin")
    @JWTTokenNeeded(Permissions = Role.ADMIN)
    public Response createTermin(TerminTO tTO) {
        if (termineManagen.createTermin(tTO)) {
            return Response.ok().build();
        } else {
            return Response.status(404, "Fehler beim Anlegen vom Termin").build();
        }
    }

    @POST
    @Path("deleteTermin/{id}")
    @JWTTokenNeeded(Permissions = Role.ADMIN)
    public Response deleteTermin(@PathParam("id") long id) {
        if (termineManagen.deleteTermin(id)) {
            return Response.ok().build();
        } else {
            return Response.status(404, "Fehler beim Loeschen von Termin").build();
        }
    }

    @GET
    @Path("getAllTermine")
    public Collection<TerminTO> getAllTermine() {
        return termineManagen.getAllTermine();
    }


    @GET
    @Path("addFotoToTermin/{fId}/{tId}")
    public Response addFotoToTermin(@PathParam("fId") long fId, @PathParam("tId") long tId) {
        if (fotosInTerminManagen.addFoto(fId, tId)) {
            return Response.ok().build();
        } else {
            return Response.status(404, "Fehler beim Hinzufuegen von Foto").build();
        }
    }

    @GET
    @Path("removeFotoFromTermin/{fId}/{tId}")
    public Response removeFotoFromTermin(@PathParam("fId") long fId, @PathParam("tId") long tId) {
        if (fotosInTerminManagen.removeFoto(fId, tId)) {
            return Response.ok().build();
        } else {
            return Response.status(404, "Fehler beim Entfernen von Foto").build();
        }
    }

    @GET
    @Path("getAllFotosOfTermin/{tId}")
    public Collection<FotoTO> getAllFotosOfTermin(@PathParam("tId") long tId) {

        List<Long> ids = fotosInTerminManagen.getAllFotosOfTermin(tId);
        Collection<FotoTO> fotos = new ArrayList<>();
        for(long id : ids) {
            fotos.add(fotosManagen.findFoto(id));
        }
        return fotos;
    }

    @GET
    @Path("getTerminOfFoto/{fId}")
    public Collection<TerminTO> getTerminOfFoto(@PathParam("fId") long fId) {

        return fotosInTerminManagen.getTerminOfFoto(fId);
    }


    @GET
    @Path("addKundeTermin/{kId}/{tId}")
    public Response addKundeToTermin(@PathParam("kId") long kId, @PathParam("tId") long tId) {
        if (kundenInTerminManagen.addKunde(kId, tId)) {
            return Response.ok().build();
        } else {
            return Response.status(404, "Fehler beim Hinzufuegen von Kunde").build();
        }
    }

    @GET
    @Path("removeKundeFromTermin/{kId}/{tId}")
    public Response removeKundeFromTermin(@PathParam("kId") long kId, @PathParam("tId") long tId) {
        if (kundenInTerminManagen.removeKunde(kId, tId)) {
            return Response.ok().build();
        } else {
            return Response.status(404, "Fehler beim Entfernen von Kunde").build();
        }
    }

    @GET
    @Path("getKundeOfTermin/{tId}")
    public KundeTO getKundeOfTermin(@PathParam("tId") long tId) {

        long kundenId = kundenInTerminManagen.getKundeOfTermin(tId);
        return kundenManagen.findKunde(kundenId);
    }

    @GET
    @Path("getTermineOfKunde/{kId}")
    public Collection<TerminTO> getTermineOfKunde(@PathParam("kId") long kId) {

        return kundenInTerminManagen.getTermineOfKunde(kId);
    }
}