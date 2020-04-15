package com.project.service;

import java.util.List;
import java.util.Optional;

import com.project.model.Reponse;



public interface ServiceReponse {
	
	public Reponse addOrModifyReponse(Reponse u);
	public void deleteReponse(Reponse p);
	public List<Reponse> getAllReponse();
	public Optional<Reponse> findById(int id);
	public void deletebyid(int id);


}
