package awk.softwareprojekt.rest;

import de.kursverwaltung.kurs.entity.CourseTO;
import de.kursverwaltung.kurs.entity.InstructorTO;
import de.kursverwaltung.kurs.usecase.IManageCourses;
import de.kursverwaltung.kurs.usecase.IManageInstructors;
import de.kursverwaltung.kurs.usecase.IManageParticipantsInCourse;
import de.kursverwaltung.security.JWTTokenNeeded;
import de.kursverwaltung.security.Role;
import de.kursverwaltung.teilnehmer.entity.ParticipantTO;
import de.kursverwaltung.teilnehmer.usecase.IManageParticipants;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Path("course")
@Stateless
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CourseResource {

	@Inject
	IManageCourses manageCourses;
	
	@Inject
	IManageInstructors manageInstructors;
	
	@Inject
	IManageParticipantsInCourse manageParticipantsInCourse;
	
	@Inject
	IManageParticipants manageParticipants;
	
	
	@POST
	@Path("createCourse")
	@JWTTokenNeeded(Permissions = Role.ADMIN)
	public Response createCourse(CourseTO cTO) {
		if (manageCourses.createCourse(cTO)) {
			return Response.ok().build();
		} else {
			return Response.status(404, "Fehler beim Anlegen von Kurs").build();
		}

	}
	
	@POST
	@Path("createInstructor")
	@JWTTokenNeeded(Permissions = Role.ADMIN)
	public Response createInstructor(InstructorTO iTO) {
		if (manageInstructors.createInstructor(iTO)) {
			return Response.ok().build();
		} else {
			return Response.status(404, "Fehler beim Anlegen von Referent").build();
		}

	}
	
	@GET
	@Path("addParticipantToCourse/{cId}/{pId}")
	public Response addParticipnatToCourse(@PathParam("cId") long cId, @PathParam("pId") long pId) {
		if (manageParticipantsInCourse.addParticipant(cId, pId)) {
			return Response.ok().build();
		} else {
			return Response.status(404, "Fehler beim Hinzufuegen von Teilnehmer").build();
		}
	}
	
	@GET
	@Path("removeParticipantFromCourse/{cId}/{pId}")
	public Response removeParticipnatFromCourse(@PathParam("cId") long cId, @PathParam("pId") long pId) {
		if (manageParticipantsInCourse.removeParticipant(cId, pId)) {
			return Response.ok().build();
		} else {
			return Response.status(404, "Fehler beim Entfernen von Teilnehmer").build();
		}
	}
	
	@GET
	@Path("getAllInstructors")
	public Collection<InstructorTO> getAllInstructors() {
		return manageInstructors.getAllInstructors();
	}
	
	@GET
	@Path("getAllCourses")
	public Collection<CourseTO> getAllCourses() {
		return manageCourses.getAllCourses();
	}
	
	@GET
	@Path("getAllParticipantsInCourse/{cId}")
	public Collection<ParticipantTO> getAllParticipantsInCourse(@PathParam("cId") long cId) {
		
		List<Long> ids = manageParticipantsInCourse.showAllParticipantsinCourse(cId);
		Collection<ParticipantTO> participants = new ArrayList<>();
		for(long id : ids) {
			participants.add(manageParticipants.findParticipant(id));
		}
		return participants;
	}
	
	
	@GET
	@Path("getAllCoursesOfParticipant/{pId}")
	public Collection<CourseTO> getAllCoursesOfParticipant(@PathParam("pId") long pId) {
		
		return manageParticipantsInCourse.getCoursesOfParticipant(pId);
	}
		
	
}
