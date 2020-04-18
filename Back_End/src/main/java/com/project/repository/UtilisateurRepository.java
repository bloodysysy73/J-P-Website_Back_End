package com.project.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.model.Utilisateur;



@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {

	@Query("select u from Utilisateur u where u.pseudo = :pseudo")
	List<Utilisateur> findByName(@Param("pseudo") String pseudo);
	
	Utilisateur findByLogin(String login);
	
	@Query("select u from Utilisateur u where u.login = :l")
	Utilisateur findbylogin(@Param("l") String login);
	
		
	@Query("select u from Utilisateur u where u.id = :id")
	Utilisateur findByid(@Param("id") int id);

	@Query("select u.pseudo from Utilisateur u where u.login = :login")
	String retrievepseudo(@Param("login") String login);

	@Query("select u.ImgFile from Utilisateur u where u.login = :login")
	String getimg(String login);

	
}

