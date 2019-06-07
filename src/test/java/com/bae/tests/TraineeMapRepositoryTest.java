package com.bae.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.bae.persistence.domain.Trainee;
import com.bae.persistence.repository.TraineeMapRepository;
import com.bae.util.JSONUtil;

public class TraineeMapRepositoryTest {
	private TraineeMapRepository tmr;
	private JSONUtil json;
	private Trainee traineeA;
	private Trainee traineeB;

	@Before
	public void setup() {
		tmr = new TraineeMapRepository();
		json = new JSONUtil();
		traineeA = new Trainee(1, "Joe Bloggs", 1);
		traineeB = new Trainee(2, "John Smith", 1);
	}

	@Test
	public void getTraineeTest() {
		tmr.getTraineeMap().put(1, traineeA);
		tmr.getTraineeMap().put(2, traineeB);
		Trainee trainee = json.getObjectForJSON(tmr.getTrainee(2), Trainee.class);
		assertEquals("John Smith", trainee.getName());
		assertEquals(2, trainee.getId());
	}

	@Test
	public void addTrainee() {
		String traineeJson = json.getJSONForObject(traineeA);
		tmr.addTrainee(traineeJson);
		assertEquals(1, tmr.getTraineeMap().size());
	}

}
