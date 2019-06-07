package com.bae.persistence.repository;

import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Alternative;
import javax.transaction.Transactional;

import com.bae.persistence.domain.Trainee;
import com.bae.util.Constants;
import com.bae.util.JSONUtil;

@Transactional(SUPPORTS)
@Alternative
public class TraineeMapRepository implements TraineeRepository {

	private Map<Integer, Trainee> traineeMap = new HashMap<>();
	private JSONUtil json = new JSONUtil();

	public Map<Integer, Trainee> getTraineeMap() {
		return traineeMap;
	}

	@Override
	public String getTrainee(int id) {
		if (!traineeMap.containsKey(id))
			return Constants.GET_CLASSROOM_FAIL;
		return json.getJSONForObject(traineeMap.get(id));
	}

}
