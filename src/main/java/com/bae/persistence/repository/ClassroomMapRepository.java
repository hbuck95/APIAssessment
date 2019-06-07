package com.bae.persistence.repository;

import static com.bae.util.Constants.ADD_CLASSROOM_SUCCESS;
import static com.bae.util.Constants.GET_CLASSROOM_FAIL;
import static com.bae.util.Constants.REMOVE_CLASSROOM_SUCCESS;
import static com.bae.util.Constants.UPDATE_CLASSROOM_SUCCESS;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Alternative;
import javax.transaction.Transactional;

import com.bae.persistence.domain.Classroom;
import com.bae.util.JSONUtil;

@Transactional(SUPPORTS)
@Alternative
public class ClassroomMapRepository implements ClassroomRepository {
	private Map<Integer, Classroom> classroomMap = new HashMap<>();

	private JSONUtil json = new JSONUtil(); // New keyword for testing

	public String addClassroom(String classroom) {
		Classroom newClassroom = json.getObjectForJSON(classroom, Classroom.class);
		classroomMap.put(newClassroom.getId(), newClassroom);
		return ADD_CLASSROOM_SUCCESS;
	}

	public String deleteClassroom(int id) {
		classroomMap.remove(id);
		return REMOVE_CLASSROOM_SUCCESS;
	}

	public String updateClassroom(int id, String classroom) {
		Classroom updatedClassroom = json.getObjectForJSON(classroom, Classroom.class);
		classroomMap.put(id, updatedClassroom);
		return UPDATE_CLASSROOM_SUCCESS;
	}

	public String getClassroom(int id) {
		if (!classroomMap.containsKey(id))
			return GET_CLASSROOM_FAIL;
		return json.getJSONForObject(classroomMap.get(id));
	}

	public Map<Integer, Classroom> getClassroomMap() {
		return classroomMap;
	}

}
