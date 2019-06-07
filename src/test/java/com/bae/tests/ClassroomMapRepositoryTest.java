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
	private Classroom classroomB;
	private Trainee traineeA;
	private String classroomAJson;
	private String traineeAJson;

	@Before
	public void setup() {
		cmr = new ClassroomMapRepository();
		json = new JSONUtil();
		classroomA = new Classroom(1, "Matt Hunt", new ArrayList<Trainee>());
		classroomB = new Classroom(1, "Chester Gardner", new ArrayList<Trainee>());
		traineeA = new Trainee(1, "Joe Bloggs", 1);
		classroomA.getTrainees().add(traineeA);
		classroomB.getTrainees().add(traineeA);
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

	@Test
	public void deleteClassroomTest() {
		cmr.getClassroomMap().put(1, classroomA);
		assertEquals(1, cmr.getClassroomMap().size()); // Check classroom was added
		cmr.deleteClassroom(1);
		assertEquals(0, cmr.getClassroomMap().size());
		assertEquals("{}", cmr.getClassroomMap().toString());
	}

	@Test
	public void updateClassroomTest() {
		cmr.getClassroomMap().put(1, classroomA);
		assertEquals(1, cmr.getClassroomMap().size()); // Check classroom was added
		cmr.updateClassroom(1, json.getJSONForObject(classroomB));
		assertEquals("Chester Gardner", cmr.getClassroomMap().get(1).getTrainer());
		assertEquals("Joe Bloggs", cmr.getClassroomMap().get(1).getTrainees().get(0).getName());
	}

	@Test
	public void getClassroomTest() {
		cmr.getClassroomMap().put(1, classroomA);
		cmr.getClassroomMap().put(2, classroomB);
		Classroom foundClass = json.getObjectForJSON(cmr.getClassroom(2), Classroom.class);
		assertEquals("Chester Gardner", foundClass.getTrainer());
		assertEquals("Joe Bloggs", foundClass.getTrainees().get(0).getName());
	}

}
