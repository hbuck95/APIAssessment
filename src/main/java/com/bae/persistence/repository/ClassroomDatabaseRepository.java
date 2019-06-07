package com.bae.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.bae.persistence.domain.Classroom;
import com.bae.util.Constants;
import com.bae.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class ClassroomDatabaseRepository implements ClassroomRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager entityManager;

	@Inject
	private JSONUtil json;

	@Transactional(REQUIRED)
	public String addClassroom(String classroom) {
		Classroom newClassroom = json.getObjectForJSON(classroom, Classroom.class);
		entityManager.persist(newClassroom);
		return Constants.ADD_CLASSROOM_SUCCESS;
	}

	public String deleteClassroom(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public String updateClassroom(int id, String classroom) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getClassroom(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
