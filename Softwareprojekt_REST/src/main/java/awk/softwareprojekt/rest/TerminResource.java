package awk.softwareprojekt.rest;


import de.kunde.awk.entity.KundeTO;
import de.kunde.awk.usecase.IKundenManagen;
import de.termin.awk.dao.FotoDAO;
import de.termin.awk.dao.TerminDAO;
import de.termin.awk.entity.FotoTO;
import de.termin.awk.entity.TechnikerTO;
import de.termin.awk.entity.TerminTO;
import de.termin.awk.entity.impl.Foto;
import de.termin.awk.entity.impl.Termin;
import de.termin.awk.usecase.IFotosInTerminManagen;
import de.termin.awk.usecase.IFotosManagen;
import de.termin.awk.usecase.IKundenInTerminManagen;
import de.termin.awk.usecase.ITechnikerManagen;
import de.termin.awk.usecase.ITermineManagen;
import awk.softwareprojekt.jwt.LogbackLogger;
import awk.softwareprojekt.security.JWTTokenNeeded;
import awk.softwareprojekt.security.Role;
import de.termin.awk.usecase.*;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

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
    
    @Inject
    ITechnikerManagen technikerManagen;
    
    
	@Inject
	@LogbackLogger
	private transient Logger logger;


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
    
    
    @POST
    @Path("deleteFoto/{id}")
    public Response deleteFoto(@PathParam("id") long id) {
        if (fotosManagen.deleteFoto(id)) {
            return Response.ok().build();
        } else {
            return Response.status(404, "Fehler beim Loeschen von Foto").build();
        }
    }
    
    
    @POST
    @Path("uploadFoto")
    @JWTTokenNeeded(Permissions = Role.ADMIN)
    public Response uploadFoto(String dateiURL) {
    	
    	logger.info("###Moin### ID: "+dateiURL.getClass());
    	
    	long fID = fotosManagen.createFoto(dateiURL);
    	
    	logger.info("###Foto### ID: "+fID);
    	
        if (fID != 0) {
            return Response.ok(fID).build();
        } else {
            return Response.status(404, "Fehler beim Anlegen vom Foto").build();
        }
    }

    @GET
    @Path("getAllTermine")
    public Collection<TerminTO> getAllTermine() {
        return termineManagen.getAllTermine();
    }
    
    @GET
    @Path("getAllTechniker")
    public Collection<TechnikerTO> getAllTechniker() {
        return technikerManagen.getAllTechniker();
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
    public List<String> getAllFotosOfTermin(@PathParam("tId") long tId) {
    	
        return fotosInTerminManagen.getAllFotosOfTermin(tId);
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
    
    @POST
    @Path("updateTermin")
    @JWTTokenNeeded(Permissions = Role.ADMIN)
    public Response updateTermin(TerminTO tTO) {
        if (termineManagen.updateTermin(tTO)) {
            return Response.ok().build();
        } else {
            return Response.status(404, "Fehler beim Bearbeiten von Termin").build();
        }
    }
}