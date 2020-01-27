package com.project.service.serviceimp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Commentaire;
import com.project.repository.CommentaireRepository;
import com.project.service.ServiceCommentaire;



@Service
public class ServiceImpCommentaire implements ServiceCommentaire{

	@Autowired
	CommentaireRepository CommentaireRep;

	@Override
	public Commentaire addOrModifyCommentaire(Commentaire a) {
		return CommentaireRep.save(a);
	}

	@Override
	public void deleteCommentaire(Commentaire p) {
		CommentaireRep.delete(p);
	}

	@Override
	public List<Commentaire> getAllCommentaire() {
		return CommentaireRep.findAll();
	}

	@Override
	public Optional<Commentaire> findById(int id) {
		return CommentaireRep.findById(id);
	}

	@Override
	public void deletebyid(int id) {
		CommentaireRep.deleteById(id);		
	}

	@Override
	public List<Commentaire> findByNote(int note) {
		// TODO Auto-generated method stub
		return null;
	}




	
}
