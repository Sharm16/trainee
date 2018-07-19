package com.qa.business.service;

import com.qa.persitence.domain.Trainee;

public interface TraineeService {

	String getAllTrainees();

	String addTrainee(String trainee);

	String updateTrainee(Long id, String trainee);

	String deleteTrainee(Long id);
	
	Trainee findTrainee (Long id);
}
