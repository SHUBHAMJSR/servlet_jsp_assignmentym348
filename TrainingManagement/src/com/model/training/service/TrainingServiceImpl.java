package com.model.training.service;

import java.util.List;

import com.model.training.Exception.DataAccessException;
import com.model.training.persistence.Training;
import com.model.training.persistence.TrainingDao;
import com.model.training.persistence.TrainingDaoImpl;

public class TrainingServiceImpl implements TrainingService{

	private TrainingDao trainingdao=null;
	public TrainingServiceImpl()
	{
		trainingdao=new TrainingDaoImpl();
	}
	@Override
	public List<Training> getAll() throws DataAccessException {
		
		return trainingdao.getAll();
	}

	@Override
	public Training addTrainee(Training trainee) {
		return trainingdao.addTrainee(trainee);
	}

}
