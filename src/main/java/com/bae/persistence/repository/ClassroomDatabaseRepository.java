package com.bae.persistence.repository;

import static com.bae.util.Constants.ADD_CLASSROOM_SUCCESS;
import static com.bae.util.Constants.REMOVE_CLASSROOM_SUCCESS;
import static com.bae.util.Constants.UPDATE_CLASSROOM_SUCCESS;
import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.bae.persistence.domain.Classroom;
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
		return ADD_CLASSROOM_SUCCESS;
	}

	@Transactional(REQUIRED)
	public String deleteClassroom(int id) {
		Classroom classToDelete = entityManager.find(Classroom.class, id);
		entityManager.remove(classToDelete);
		return REMOVE_CLASSROOM_SUCCESS;
	}

	@Transactional(REQUIRED)
	public String updateClassroom(int id, String classroom) {
		Classroom updatedClassroom = json.getObjectForJSON(classroom, Classroom.class);

		Query query = entityManager.createQuery(String.format(
				"UPDATE Classroom c SET trainer = '%s' WHERE c.classroomID = %s", updatedClassroom.getTrainer(), id));

		query.executeUpdate();

		return UPDATE_CLASSROOM_SUCCESS;
	}

	public String getClassroom(int id) {
		return json.getJSONForObject((Classroom) entityManager.find(Classroom.class, id));
	}

}
