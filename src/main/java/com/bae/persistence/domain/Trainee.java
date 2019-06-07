package com.bae.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Trainee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int traineeID;

	@Column(length = 40)
	private String traineeName;

	@Column(length = 1)
	private int classroom;

	public Trainee() {

	}

	public Trainee(int id, String name, int classroom) {
		super();
		this.traineeID = id;
		this.traineeName = name;
		this.setClassroom(classroom);
	}

	public int getId() {
		return traineeID;
	}

	public void setId(int id) {
		this.traineeID = id;
	}

	public String getName() {
		return traineeName;
	}

	public void setName(String name) {
		this.traineeName = name;
	}

	public int getClassroom() {
		return classroom;
	}

	public void setClassroom(int classroom) {
		this.classroom = classroom;
	}

}
