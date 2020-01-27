package com.project.service;

import java.util.List;

import com.project.model.Avis;

public interface ServiceAvis {

	public Avis addOrModify(Avis avis);
	public void deleteById(int id);
	public List<Avis> getAll();
	
	public List<Avis> getAvisByUser(String login);
	
}
