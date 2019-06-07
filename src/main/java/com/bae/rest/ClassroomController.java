package com.bae.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
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
	public String addClassroom(String classroom) {
		return classroomService.addClassroom(classroom);

	}

	@Path("/deleteClassroom/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteClassroom(@PathParam("id") int id) {
		return classroomService.deleteClassroom(id);

	}

	public String updateClassroom(int id, String classroom) {
		return null;

	}

	public String getClassroom(int id) {
		return null;

	}

}
