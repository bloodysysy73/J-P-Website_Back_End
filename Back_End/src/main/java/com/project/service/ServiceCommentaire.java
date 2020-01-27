package com.project.service;

import java.util.List;
import java.util.Optional;

import com.project.model.Commentaire;



public interface ServiceCommentaire {
	
	public Commentaire addOrModifyCommentaire(Commentaire u);
	public void deleteCommentaire(Commentaire p);
	public List<Commentaire> getAllCommentaire();
	public Optional<Commentaire> findById(int id);
	public void deletebyid(int id);
	public List<Commentaire> findByNote(int note); 







}
