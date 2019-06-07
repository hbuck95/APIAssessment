package com.bae.persistence.repository;

import static javax.transaction.Transactional.TxType.SUPPORTS;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.bae.persistence.domain.Trainee;
import com.bae.util.Constants;
import com.bae.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class TraineeDatabaseRepository implements TraineeRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager entityManager;

	@Inject
	private JSONUtil json;

	@Override
	public String getTrainee(int id) {
		return json.getJSONForObject((Trainee) entityManager.find(Trainee.class, id));
	}

	@Override
	public String addTrainee(String trainee) {
		Trainee newTrainee = json.getObjectForJSON(trainee, Trainee.class);
		entityManager.persist(newTrainee);
		return Constants.ADD_TRAINEE_SUCCESS;
	}

}
