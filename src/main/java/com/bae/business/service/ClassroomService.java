package com.bae.business.service;

public interface ClassroomService {
	public String addClassroom(String classroom);

	public String deleteClassroom(int id);

	public String updateClassroom(int id, String classroom);

	public String getClassroom(int id);
}
