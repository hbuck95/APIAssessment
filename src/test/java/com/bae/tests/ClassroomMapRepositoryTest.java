package com.bae.tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.bae.persistence.domain.Classroom;
import com.bae.persistence.domain.Trainee;
import com.bae.persistence.repository.ClassroomMapRepository;
import com.bae.util.JSONUtil;

public class ClassroomMapRepositoryTest {
	private ClassroomMapRepository cmr;
	private JSONUtil json;
	private Classroom classroomA;
	private Trainee traineeA;
	private String classroomAJson;
	private String traineeAJson;

	@Before
	public void setup() {
		cmr = new ClassroomMapRepository();
		json = new JSONUtil();
		classroomA = new Classroom(1, "Matt Hunt", new ArrayList<Trainee>());
		traineeA = new Trainee(1, "Joe Bloggs", 1);
		classroomA.getTrainees().add(traineeA);
		classroomAJson = "{\"classroomID\":1,\"trainer\":\"Matt Hunt\",\"trainees\":[{\"traineeID\":1,\"traineeName\":\"Joe Bloggs\",\"classroom\":1}]}";
	}

	@Test
	public void addClassroomWithObjectTest() {
		cmr.addClassroom(json.getJSONForObject(classroomA));
		assertEquals(1, cmr.getClassroomMap().size());
		assertEquals("Matt Hunt", cmr.getClassroomMap().get(1).getTrainer());
	}

	@Test
	public void addClassroomWithStringTest() {
		cmr.addClassroom(classroomAJson);
		assertEquals(1, cmr.getClassroomMap().size());
		assertEquals("Matt Hunt", cmr.getClassroomMap().get(1).getTrainer());
	}

}
