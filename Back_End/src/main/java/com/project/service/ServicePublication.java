package com.project.service;

import java.util.List;

import com.project.model.Publication;

public interface ServicePublication {

	public Publication addOrModify(Publication avis);
	public void deleteById(int id);
	public List<Publication> getAll();
	
	public List<Publication> getPublicationByUser(String login);
	
}
