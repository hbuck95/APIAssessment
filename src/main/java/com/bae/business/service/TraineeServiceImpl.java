package com.bae.business.service;

import javax.inject.Inject;

import com.bae.persistence.repository.TraineeRepository;

public class TraineeServiceImpl implements TraineeService {

	@Inject
	private TraineeRepository repo;

	@Override
	public String getTrainee(int id) {
		return repo.getTrainee(id);
	}

	@Override
	public String addTrainee(String trainee) {
		return repo.addTrainee(trainee);
	}

}
