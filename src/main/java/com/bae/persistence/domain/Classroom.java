package com.bae.persistence.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Classroom {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "classroomID")
	private int classroomID;

	@Column(name = "trainer")
	private String trainer;

	@JoinColumn(name = "classroom", referencedColumnName = "classroomID")
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
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
