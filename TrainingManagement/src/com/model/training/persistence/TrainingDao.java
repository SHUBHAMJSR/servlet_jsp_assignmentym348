package com.model.training.persistence;

import java.util.List;

import com.model.training.Exception.DataAccessException;

public interface TrainingDao {
	public List<Training> getAll()throws DataAccessException;
	public Training addTrainee(Training trainee);
}
