package com.project.service;

import java.util.List;

import com.project.model.Publication;
import com.project.model.TimeLineCard;

public interface ServicePublication {

	public Publication addOrModify(Publication avis);
	public void deleteById(int id);
	public List<Publication> getAll();
	
	public List<Publication> getPublicationByUser(String login);
	public Publication findByid(int id);

	
}
