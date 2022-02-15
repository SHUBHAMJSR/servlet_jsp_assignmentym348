package com.model.training.persistence;

public class Training {
	private int id;
	private int trainee_id;
	private String trainee_name;
	private String branch;
	private Double percentage;
	
	
	public Training(int trainee_id, String trainee_name, String branch, Double percentage) {
		super();
		this.trainee_id = trainee_id;
		this.trainee_name = trainee_name;
		this.branch = branch;
		this.percentage = percentage;
	}
	
	
	
	public Training() {
		
	}



	public Training(int id, int trainee_id, String trainee_name, String branch, Double percentage) {
		super();
		this.id = id;
		this.trainee_id = trainee_id;
		this.trainee_name = trainee_name;
		this.branch = branch;
		this.percentage = percentage;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTrainee_id() {
		return trainee_id;
	}
	public void setTrainee_id(int trainee_id) {
		this.trainee_id = trainee_id;
	}
	public String getTrainee_name() {
		return trainee_name;
	}
	public void setTrainee_name(String trainee_name) {
		this.trainee_name = trainee_name;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public Double getPercentage() {
		return percentage;
	}
	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}
	
	
}
