package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.model.Commentaire;
import com.project.model.Utilisateur;



@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire, Integer> {

	
	

	


	
}

