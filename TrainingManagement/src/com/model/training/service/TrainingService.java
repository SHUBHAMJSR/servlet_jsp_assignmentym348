package com.model.training.service;

import java.util.List;

import com.model.training.Exception.DataAccessException;
import com.model.training.persistence.Training;

public interface TrainingService {
	public List<Training> getAll()throws DataAccessException;
	public Training addTrainee(Training trainee);
}
