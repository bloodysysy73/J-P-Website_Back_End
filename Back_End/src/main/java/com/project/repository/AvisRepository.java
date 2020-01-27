package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.model.Avis;
import com.project.model.Utilisateur;

public interface AvisRepository extends JpaRepository<Avis, Integer> {

	@Query("select a from Avis a where a.login = :l")
	List<Avis> findAllByUser(@Param("l") String login);
	

}
