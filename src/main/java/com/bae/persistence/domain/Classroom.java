package com.bae.persistence.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Classroom {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int classroomID;

	@Column(length = 40)
	private String trainer;

	@OneToMany(mappedBy = "classroom")
	private List<Trainee> trainees;

	public Classroom() {

	}

	public Classroom(int id, String trainer, List<Trainee> trainees) {
		super();
		this.classroomID = id;
		this.trainer = trainer;
		this.trainees = trainees;
	}

	public int getId() {
		return classroomID;
	}

	public void setId(int id) {
		this.classroomID = id;
	}

	public String getTrainer() {
		return trainer;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}

	public List<Trainee> getTrainees() {
		return trainees;
	}

	public void setTrainees(List<Trainee> trainees) {
		this.trainees = trainees;
	}

}
