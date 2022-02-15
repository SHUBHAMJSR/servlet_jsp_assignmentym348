package com.model.training.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.training.Exception.DataAccessException;

public class TrainingDaoImpl implements TrainingDao{

	private Connection connection=null;
	public TrainingDaoImpl() {
		connection=ConnectionFactory.getConnection();
	}
	
	@Override
	public List<Training> getAll() throws DataAccessException {
		System.out.println("getting all records using jdbc");
		
		List<Training> trainees = new ArrayList<Training>();
		try {
			Training training = null;

			PreparedStatement pstmt = connection.prepareStatement("select * from emp1");

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				training = new Training(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),
						rs.getDouble(5));
				trainees.add(training);
			}

		} catch (SQLException ex) {
			throw new DataAccessException(ex);
		}

		return trainees;
	}

	@Override
	public Training addTrainee(Training trainee) {
		try {
			PreparedStatement pstmt = connection.prepareStatement
					("insert into TraineeMgmt(trainee_id,trainee_name,branch,Percentage) values(?,?,?,?);");
			pstmt.setInt(1, trainee.getTrainee_id());
			pstmt.setString(2, trainee.getTrainee_name());
			pstmt.setString(3, trainee.getBranch());
			pstmt.setDouble(4, trainee.getPercentage());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return trainee;
	}
}
