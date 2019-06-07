package com.bae.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.bae.persistence.domain.Classroom;
import com.bae.persistence.domain.Trainee;

public class DomainModelTest {
	private Classroom classroomA;
	private Trainee traineeA;

	@Before
	public void setup() {
		classroomA = new Classroom();
		classroomA.setId(1);
		classroomA.setTrainer("Matt Hunt");

		traineeA = new Trainee(1, "Joe Bloggs", 1);

	}

	@Test
	@Ignore
	public void testClassroom() {
		assertEquals(1, classroomA.getId());
		assertEquals("Matt Hunt", classroomA.getTrainer());
	}

	@Test
	@Ignore
	public void testTrainee() {
		assertEquals(1, traineeA.getId());
		assertEquals(1, traineeA.getClassroom());
		assertEquals("Joe Bloggs", traineeA.getName());
	}

}
