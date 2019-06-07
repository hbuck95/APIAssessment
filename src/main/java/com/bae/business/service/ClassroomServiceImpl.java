package com.bae.business.service;

import javax.inject.Inject;

import com.bae.persistence.repository.ClassroomRepository;

public class ClassroomServiceImpl implements ClassroomService {

	@Inject
	private ClassroomRepository repo;

	@Override
	public String addClassroom(String classroom) {
		return repo.addClassroom(classroom);
	}

	@Override
	public String deleteClassroom(int id) {
		return repo.deleteClassroom(id);
	}

	@Override
	public String updateClassroom(int id, String classroom) {
		return repo.updateClassroom(id, classroom);
	}

	@Override
	public String getClassroom(int id) {
		return repo.getClassroom(id);
	}

}
