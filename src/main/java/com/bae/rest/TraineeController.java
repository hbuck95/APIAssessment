package com.bae.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.bae.business.service.TraineeService;

@Path("/trainee")
public class TraineeController {

	@Inject
	private TraineeService traineeService;

	@Path("/addTrainee")
	@POST
	@Produces({ "application/json" })
	public String addTrainee(String trainee) {
		return traineeService.addTrainee(trainee);
	}

	@Path("/getTrainee/{id}")
	@GET
	@Produces({ "application/json" })
	public String getTrainee(@PathParam("id") int id) {
		return traineeService.getTrainee(id);
	}

}
