package com.qa.persistence;

import com.qa.persitence.domain.Trainee;

public interface TraineeRepository {
	String getAllTrainees();

	String createTrainee(String trainee);

	String updateTrainee(Long id, String trainee);

	String deleteTrainee(Long id);
	
	Trainee findTrainee (Long id);
}
