package com.qa.business.service;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.qa.persistence.TraineeRepository;
import com.qa.persitence.domain.Trainee;

public class TraineeServiceImpl {

	private static final Logger LOGGER = Logger.getLogger(TraineeService.class);

	@Inject
	private TraineeRepository repo;

	public String getAllTrainees() {
		LOGGER.info("In business.service TraineeServiceImpl getAllTrainees ");
		return repo.getAllTrainees();
	}

	public String addTrainee(String trainee) {
		LOGGER.info("In business.service TraineeServiceImpl addTrainee ");
		return repo.createTrainee(trainee);
	}

	public String updateTrainee(Long id, String trainee) {
		LOGGER.info("In business.service TraineeServiceImpl updateTrainee ");
		return repo.updateTrainee(id, trainee);
	}

	public String deleteTrainee(Long id) {
		LOGGER.info("In business.service TraineeServiceImpl deleteTrainee ");
		return repo.deleteTrainee(id);

	}
	
	public Trainee findTrainee(Long id) {
		LOGGER.info("In business.service TraineeServiceImpl deleteTrainee ");
		return repo.findTrainee(id);

	}

	public void setRepo(TraineeRepository repo) {
		this.repo = repo;
	}

}
