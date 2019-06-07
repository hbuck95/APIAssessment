package com.bae.rest;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
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

	public String deleteClassroom(int id) {
		return null;

	}

	public String updateClassroom(int id, String classroom) {
		return null;

	}

	public String getClassroom(int id) {
		return null;

	}

}
