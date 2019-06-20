package com.bae.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.bae.business.service.ClassroomService;

@Path("/classroom")
public class ClassroomController {

	@Inject
	private ClassroomService classroomService;

	@Path("/addClassroom")
	@POST
	@Produces({ "application/json" })
	public String addANewClassroom(String classroom) {
		return classroomService.addClassroom(classroom);

	}

	@Path("/deleteClassroom/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteClassroom(@PathParam("id") int id) {
		return classroomService.deleteClassroom(id);

	}

	@Path("/updateClassroom/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateClassroom(@PathParam("id") int id, String classroom) {
		return classroomService.updateClassroom(id, classroom);

	}

	@Path("/getClassroom/{id}")
	@GET
	@Produces({ "application/json" })
	public String getClassroom(@PathParam("id") int id) {
		return classroomService.getClassroom(id);

	}

}
