package com.qa.persistence;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.qa.persistence.TraineeRepository;
import com.qa.persitence.domain.Trainee;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class TrainneDBRepository implements TraineeRepository{
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	private static final Logger LOGGER = Logger.getLogger(TraineeRepository.class);

	@Inject
	private JSONUtil util;

	public String getAllTrainees() {
		LOGGER.info("In persistence traineeDBrepository getAllTrainees()");
		Query query = manager.createQuery("Select a FROM Trainee a");
		Collection<Trainee> trainees = (Collection<Trainee>) query.getResultList();
		return util.getJSONForObject(trainees);
	}

	@Transactional(REQUIRED)
	public String createTrainee(String accout) {
		LOGGER.info("In persistence traineeDBrepository createTrainees()");
		Trainee anTrainee = util.getObjectForJSON(accout, Trainee.class);
		manager.persist(anTrainee);
		return "{\"message\": \"trainee has been sucessfully added\"}";
	}

	@Transactional(REQUIRED)
	public String updateTrainee(Long id, String traineeToUpdate) {
		LOGGER.info("In persistence traineeDBrepository updateTrainees()");
		Trainee updatedTrainee = util.getObjectForJSON(traineeToUpdate, Trainee.class);
		Trainee traineeFromDB = findTrainee(id);
		Query query = manager.createQuery("Select a  FROM Trainee a where id = "+id);
//		if (query.getResultList().isEmpty()) {
//			LOGGER.error("ID NOT VALID");	
//			return "{\"message\": \"trainee not found\"}";
//		}
//		else 
			if (traineeToUpdate != null) {
				traineeFromDB = updatedTrainee;
				traineeFromDB.setId(id);
				manager.merge(traineeFromDB);
			}
			return "{\"message\": \"trainee sucessfully updated\"}";
	}

	@Transactional(REQUIRED)
	public String deleteTrainee(Long id) {
		LOGGER.info("In persistence traineeDBrepository deleteTrainees()");
		Trainee traineeInDB = findTrainee(id);
		if (traineeInDB != null) {
			manager.remove(traineeInDB);
		}
		return "{\"message\": \"trainee sucessfully deleted\"}";
	}

	public Trainee findTrainee(Long id) {
		LOGGER.info("In persistence traineeDBrepository findTrainees()");
		return manager.find(Trainee.class, id);
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

}

